import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { DataStorageService } from '../recipes/data-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  constructor(private dataStorageService: DataStorageService) { }

  ngOnInit(): void {
  }
  toggler(menus: any) {
    menus.classList.toggle('open')
  }
  onSaveRecipe() {
    this.dataStorageService.storeRecipes();
  }
  onFetchRecipe() {
    this.dataStorageService.fetchRecipes().subscribe();
  }

}
