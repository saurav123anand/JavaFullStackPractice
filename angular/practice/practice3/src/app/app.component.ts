import { ViewEncapsulation } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit{
  title = 'practice3';
  oddNumbers:number[]=[];
  evenNumbers:number[]=[];
  onIntervalFired(firedNumber:number){
     if(firedNumber%2==0){
      this.evenNumbers.push(firedNumber);
     }
     else{
      this.oddNumbers.push(firedNumber);
     }
  }
  sum(num1:number,num2:number){
    console.log(num1+num2);
  }
  constructor(){
     console.log("constructor called")
  }
  ngOnInit(): void {
    console.log("ngOnInit called")
    this.sum(4,7);
  }
  
}
