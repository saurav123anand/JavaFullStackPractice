import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Subscription } from 'rxjs';
import { interval } from 'rxjs';
import { filter, map } from 'rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit,OnDestroy {
  private firstObsSubscription:Subscription
  constructor() { }

  ngOnInit(): void {
    // this.firstObsSubscription=interval(1000).subscribe(count=>{
    //   console.log(count)
    // })

    //custom observable
    const customObservable=Observable.create(observer=>{
       let count=0;
       setInterval(()=>{
        //for getting the future data(next method)
        observer.next(count)
        if(count===2){
          observer.complete();
        }
        if(count>3){
          observer.error(new Error("count greater than 3"))
        }
        count++;
       },1000)
    })
    this.firstObsSubscription=customObservable.pipe(filter(data=>{
      return data>0;
    }),map((data:number)=>{
      return "round "+(data+1);
    })).subscribe(data=>{
      console.log(data)
    },error=>{
      console.log(error.message)
    },()=>{
      console.log("completed")
    })

  }
  ngOnDestroy(): void {
    this.firstObsSubscription.unsubscribe();
  }

}
