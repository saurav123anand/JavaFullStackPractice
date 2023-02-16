import { EventEmitter, Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Ingredient } from '../shared/Ingredient.model';

@Injectable({
  providedIn: 'root'
})
export class ShoppingListService {
  ingredientChanged=new EventEmitter<Ingredient[]>();
  startEditing=new Subject<number>();
  private ingredients:Ingredient[]=[new Ingredient("Tomato",23),new Ingredient("pineapple",45)]
  constructor() { }
  getIngredients(){
    return this.ingredients.slice();
  }
  getIngredient(index:number){
    return this.ingredients[index];
  }
  addIngredient(ingredient:Ingredient){
    this.ingredients.push(ingredient);
    this.ingredientChanged.emit(this.ingredients.slice())
  }
  addIngredients(ingredients:Ingredient[]){
      this.ingredients.push(...ingredients);
      this.ingredientChanged.emit(this.ingredients.slice())
  }
  updateIngredients(index:number,newIngredient:Ingredient){
    this.ingredients[index]=newIngredient;
    this.ingredientChanged.emit(this.ingredients.slice());
  }
  deleteIngredient(index:number){
     this.ingredients.splice(index,1);
     this.ingredientChanged.emit(this.ingredients.slice());
  }
}
