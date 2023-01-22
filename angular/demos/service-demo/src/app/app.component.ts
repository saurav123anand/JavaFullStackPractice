import { Component, OnInit } from '@angular/core';
import { AccountService } from './services/account.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  constructor(private accountService:AccountService){}
  accounts:{name:string,status:string}[]=[]
  ngOnInit(): void {
    this.accounts=this.accountService.accounts;
  }
}
