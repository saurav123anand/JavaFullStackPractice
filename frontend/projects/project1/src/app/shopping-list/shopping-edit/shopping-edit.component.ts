import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { Ingredient } from 'src/app/shared/Ingredient.model';

@Component({
  selector: 'app-shopping-edit',
  templateUrl: './shopping-edit.component.html',
  styleUrls: ['./shopping-edit.component.css']
})
export class ShoppingEditComponent implements OnInit {
  @Output() eventFired=new EventEmitter<Ingredient>();
  @ViewChild('amountInput') amountInput:ElementRef|undefined;
  constructor() { }

  ngOnInit(): void {
  }
  onAdded(nameInput:HTMLInputElement){
     let ingredient:Ingredient=new Ingredient(nameInput.value,this.amountInput?.nativeElement.value);
     this.eventFired.emit(ingredient);
  }

}
