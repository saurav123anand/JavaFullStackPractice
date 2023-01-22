import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Recipe } from '../model/recipe.model';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {
  recipes:Recipe[]=[new Recipe("baby corn","this is baby corn",'https://img.onmanorama.com/content/dam/mm/en/food/readers-recipe/images/2020/7/18/corn-fry.jpg'),new Recipe("French fries","this is french fries","https://static.toiimg.com/thumb/54659021.cms?imgsize=275086&width=800&height=800")]
  @Output() recipeWasSelected=new EventEmitter<Recipe>()
  constructor() { }

  ngOnInit(): void {
  }
  onRecipeSelected(recipe:Recipe){
    this.recipeWasSelected.emit(recipe);
  }

}
