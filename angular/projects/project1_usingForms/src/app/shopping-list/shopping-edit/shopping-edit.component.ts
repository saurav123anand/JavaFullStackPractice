import { Component, ElementRef, EventEmitter, OnDestroy, OnInit, Output, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Ingredient } from 'src/app/shared/Ingredient.model';
import { ShoppingListService } from '../shopping-list.service';

@Component({
  selector: 'app-shopping-edit',
  templateUrl: './shopping-edit.component.html',
  styleUrls: ['./shopping-edit.component.css']
})
export class ShoppingEditComponent implements OnInit ,OnDestroy{
  @ViewChild('amountInput') amountInput: ElementRef | undefined;
  constructor(private shoppingListService: ShoppingListService) { }
  editMode = false;
  editedItemIndex: number;
  editedItem:Ingredient;
  @ViewChild('f') shoppingListForm;
  subscription:Subscription;

  ngOnInit(): void {
    this.subscription=this.shoppingListService.startEditing.subscribe(
      (index: number) => {
        this.editMode = true;
        this.editedItemIndex = index;
        this.editedItem=this.shoppingListService.getIngredient(index);
        this.shoppingListForm.setValue({
          name:this.editedItem.name,
          amount:this.editedItem.amount
        })
      }
    )
  }
  onSubmit(form: NgForm) {
    const value = form.value;
    let ingredient: Ingredient = new Ingredient(value.name, value.amount);
    if(this.editMode){
      this.shoppingListService.updateIngredients(this.editedItemIndex,ingredient)
    }
    else{
      this.shoppingListService.addIngredient(ingredient);
    }
    this.editMode=false;
    form.reset()
  }
  ngOnDestroy(): void {
      this.subscription.unsubscribe()
  }
  onClear(){
    this.shoppingListForm.reset();
    this.editMode=false;
  }
  onDeleteItem(){
    this.shoppingListService.deleteIngredient(this.editedItemIndex)
    this.onClear()
  }
}
