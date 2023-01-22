import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CounterService {
  activeToInactiveCounter=0;
  inactiveToActiveCounter=0;
  incrementActiveToInactive(){
    this.activeToInactiveCounter++;
    console.log("active to inactive count: "+this.activeToInactiveCounter);
  }
  incrementInactiveToActive(){
    this.inactiveToActiveCounter++;
    console.log("inactive to active count: "+this.inactiveToActiveCounter);
  }
  constructor() { }
}
