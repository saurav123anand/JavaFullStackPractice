import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Recipe } from '../model/recipe.model';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-recipe-edit',
  templateUrl: './recipe-edit.component.html',
  styleUrls: ['./recipe-edit.component.css']
})
export class RecipeEditComponent implements OnInit {
  id:number;
  editMode=false;
  recipeForm:FormGroup;

  constructor(private route:ActivatedRoute,private recipeService:RecipeService,private router:Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params:Params)=>{
        this.id=+params['id']
        this.editMode=params['id']!=null;
        this.initForm()
      }
    )
  }
  onAddIngredient(){
    (<FormArray>this.recipeForm.get('ingredients')).push(
      new FormGroup({
        'name':new FormControl(null,Validators.required),
        'amount':new FormControl(null,Validators.required)
      })
    )
  }
  onCancel(){
      this.router.navigate(['../'],{relativeTo:this.route})
  }

  private initForm(){
    let recipeName='';
    let recipeImageUrl='';
    let recipeDescription=''
    let recipeIngredients=new FormArray([])
    if(this.editMode){
      const recipe=this.recipeService.getRecipe(this.id)
      recipeName=recipe.name;
      recipeImageUrl=recipe.imageUrl;
      recipeDescription=recipe.description;
      if(recipe['ingredients']){
        for(const ingredient of recipe.ingredients){
           recipeIngredients.push(
            new FormGroup({
              'name':new FormControl(ingredient.name,Validators.required),
              'amount':new FormControl(ingredient.amount,Validators.required)
            })
           )
        }
      }
    }
    this.recipeForm=new FormGroup(
      {
        'name':new FormControl(recipeName,Validators.required),
        'imageUrl':new FormControl(recipeImageUrl,Validators.required),
        'description':new FormControl(recipeDescription,Validators.required),
        'ingredients':recipeIngredients
      }
    )
  }
  onDeleteIngredient(index:number){
     (<FormArray>this.recipeForm.get('ingredients')).removeAt(index)
  }
  onSubmit(){
    //console.log(this.recipeForm)
    const newRecipe=new Recipe(this.recipeForm.value['name'],this.recipeForm.value['description'],
    this.recipeForm.value['imageUrl'],this.recipeForm.value['ingredients']);
    if(this.editMode){
      this.recipeService.updateRecipe(this.id,newRecipe)
    }
    else{
      this.recipeService.addRecipe(newRecipe)
    }
    this.onCancel();
  }




}
