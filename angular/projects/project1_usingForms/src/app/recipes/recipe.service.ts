import { EventEmitter, Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Ingredient } from '../shared/Ingredient.model';
import { ShoppingListService } from '../shopping-list/shopping-list.service';
import { Recipe } from './model/recipe.model';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  recipeSelected=new EventEmitter<Recipe>();
  recipeChanged=new Subject<Recipe[]>();
  private recipes:Recipe[]=[new Recipe("baby corn","this is baby corn",
  'https://img.onmanorama.com/content/dam/mm/en/food/readers-recipe/images/2020/7/18/corn-fry.jpg'
  ,[
    new Ingredient("Oil",13),
    new Ingredient("Salt",14)
  ]
  ),new Recipe("French fries","this is french fries",
  "https://static.toiimg.com/thumb/54659021.cms?imgsize=275086&width=800&height=800",
  [
    new Ingredient("potato",14),
    new Ingredient("salt",14)
  ])]

  constructor(private sls:ShoppingListService) { }
  getRecipes(){
    return this.recipes;
  }
  getRecipe(index:number){
    return this.recipes[index];
  }
  addIngredientToShoppingList(ingredients:Ingredient[]){
    this.sls.addIngredients(ingredients);
  }
  addRecipe(recipe:Recipe){
     this.recipes.push(recipe);
     this.recipeChanged.next(this.recipes.slice())
  }
  updateRecipe(index:number,newRecipe){
    this.recipes[index]=newRecipe;
    this.recipeChanged.next(this.recipes.slice())
  }
  deleteRecipe(index:number){
    this.recipes.splice(index,1);
    this.recipeChanged.next(this.recipes.slice())
  }

}
