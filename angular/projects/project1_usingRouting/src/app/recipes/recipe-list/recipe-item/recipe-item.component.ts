import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Recipe } from '../../model/recipe.model';

@Component({
  selector: 'app-recipe-item',
  templateUrl: './recipe-item.component.html',
  styleUrls: ['./recipe-item.component.css']
})
export class RecipeItemComponent implements OnInit {
  @Input() recipe:Recipe|undefined
  @Input() index:number
  constructor() { }

  ngOnInit(): void {
  }

}
