import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { exhaustMap, map, take, tap } from 'rxjs/operators';
import { AuthService } from '../auth/auth.service';
import { Recipe } from './model/recipe.model';
import { RecipeService } from './recipe.service';

@Injectable({
  providedIn: 'root'
})
export class DataStorageService {

  constructor(private http: HttpClient, private recipeService: RecipeService, private authService: AuthService) { }

  storeRecipes() {
    const recipes = this.recipeService.getRecipes();
    this.http.put("https://project-40d18-default-rtdb.firebaseio.com/recipes.json", recipes).subscribe(
      response => {
        console.log(response)
      }
    )
  }
  // fetchRecipes(){
  //   return this.http.get<Recipe[]>("https://project-40d18-default-rtdb.firebaseio.com/recipes.json")
  //   .pipe(map(recipes=>{
  //      return recipes.map(recipe=>{
  //       return {...recipe,ingredients: recipe.ingredients ? recipe.ingredients : []}
  //      })
  //   }))
  //   .subscribe(
  //     recipes=>{
  //       console.log(recipes)
  //       this.recipeService.setRecipes(recipes);
  //     }
  //   )
  // }

  // fetchRecipes(){
  //   
  //   return this.http.get<Recipe[]>("https://project-40d18-default-rtdb.firebaseio.com/recipes.json")
  //   .pipe(map(recipes=>{
  //      return recipes.map(recipe=>{
  //       return {...recipe,ingredients: recipe.ingredients ? recipe.ingredients : []}
  //      })
  //   })
  //   ,tap((recipes:Recipe[])=>{
  //     this.recipeService.setRecipes(recipes)
  //   }))

  // }

  //sending token to outgoing request
  fetchRecipes() {
      return this.http.get<Recipe[]>(
        "https://project-40d18-default-rtdb.firebaseio.com/recipes.json").pipe(
        map(recipes => {
          return recipes.map(recipe => {
            return { ...recipe, ingredients: recipe.ingredients ? recipe.ingredients : [] }
          })
        })

      , tap((recipes: Recipe[]) => {
        this.recipeService.setRecipes(recipes)
      }))

  }
}
