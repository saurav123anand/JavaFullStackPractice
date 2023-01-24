import { EventEmitter, Injectable } from '@angular/core';
import { Recipe } from './model/recipe.model';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  recipeSelected=new EventEmitter<Recipe>();
  private recipes:Recipe[]=[new Recipe("baby corn","this is baby corn",
  'https://img.onmanorama.com/content/dam/mm/en/food/readers-recipe/images/2020/7/18/corn-fry.jpg'),new Recipe("French fries","this is french fries","https://static.toiimg.com/thumb/54659021.cms?imgsize=275086&width=800&height=800")]

  constructor() { }
  getRecipes(){
    return this.recipes;
  }

}
