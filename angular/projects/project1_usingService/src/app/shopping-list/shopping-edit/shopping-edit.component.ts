import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { Ingredient } from 'src/app/shared/Ingredient.model';
import { ShoppingListService } from '../shopping-list.service';

@Component({
  selector: 'app-shopping-edit',
  templateUrl: './shopping-edit.component.html',
  styleUrls: ['./shopping-edit.component.css']
})
export class ShoppingEditComponent implements OnInit {
  @ViewChild('amountInput') amountInput:ElementRef|undefined;
  constructor(private shoppingListService:ShoppingListService) { }

  ngOnInit(): void {
  }
  onAdded(nameInput:HTMLInputElement){
     let ingredient:Ingredient=new Ingredient(nameInput.value,this.amountInput?.nativeElement.value);
     this.shoppingListService.addIngredient(ingredient);
  }

}
