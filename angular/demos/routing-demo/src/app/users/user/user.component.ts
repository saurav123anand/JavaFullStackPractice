import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs-compat';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit,OnDestroy {
  user: {id: number, name: string};

  subscription:Subscription

  constructor(private route:ActivatedRoute) { }

  ngOnInit() {
    this.user={
      id:this.route.snapshot.params['id'],
      name:this.route.snapshot.params['name']
    }
    //to update the same component 
    this.subscription=this.route.params.subscribe(
      (params:Params)=>{
        this.user.id=params['id']
        this.user.name=params['name']
      }
    )
  }
  //optional
  ngOnDestroy(): void {
    console.log("destroyed")
    this.subscription.unsubscribe()
  }

}
