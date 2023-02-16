import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, tap } from 'rxjs/operators';
import { Recipe } from './model/recipe.model';
import { RecipeService } from './recipe.service';

@Injectable({
  providedIn: 'root'
})
export class DataStorageService {

  constructor(private http:HttpClient,private recipeService:RecipeService) { }

  storeRecipes(){
    const recipes=this.recipeService.getRecipes();
    this.http.put("https://project-40d18-default-rtdb.firebaseio.com/recipes.json",recipes).subscribe(
      response=>{
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

  fetchRecipes(){
    return this.http.get<Recipe[]>("https://project-40d18-default-rtdb.firebaseio.com/recipes.json")
    .pipe(map(recipes=>{
       return recipes.map(recipe=>{
        return {...recipe,ingredients: recipe.ingredients ? recipe.ingredients : []}
       })
    })
    ,tap((recipes:Recipe[])=>{
      this.recipeService.setRecipes(recipes)
    }))
    
  }
}
