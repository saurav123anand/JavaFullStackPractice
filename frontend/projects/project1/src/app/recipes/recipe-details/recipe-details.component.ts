import { Component, Input, OnInit } from '@angular/core';
import { Recipe } from '../model/recipe.model';

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css']
})
export class RecipeDetailsComponent implements OnInit {
  @Input() recipe:Recipe|undefined
  constructor() { }

  ngOnInit(): void {
  }

}

