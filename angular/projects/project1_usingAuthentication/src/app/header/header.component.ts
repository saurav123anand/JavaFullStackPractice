import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { DataStorageService } from '../recipes/data-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  constructor(private dataStorageService: DataStorageService,private authService:AuthService) { }
  isAuthenticated=false;
  ngOnInit(): void {
     this.authService.user.subscribe(user=>{
      this.isAuthenticated=!user ? false :true;
     })
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
  onLogout(){
    this.authService.logout()
  }

}
