import { OnInit } from '@angular/core';
import { OnDestroy } from '@angular/core';
import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit,OnDestroy{
  userActivated=false;
  private activatedSub:Subscription
  title = 'observable-demo';
  constructor(private userService:UserService){}
  ngOnInit(): void {
    this.activatedSub=this.userService.activatedEmitter.subscribe(activated=>{
      this.userActivated=activated;
    })
  }
  ngOnDestroy(): void {
    this.activatedSub.unsubscribe()
  }
}
