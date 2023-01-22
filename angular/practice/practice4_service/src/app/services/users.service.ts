import { Injectable } from '@angular/core';
import { CounterService } from './counter.service';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  activeUsers = ["Sara", "Rahul", "Varun", "Ryan"]
  inactiveUsers = ["Guchhu", "Govind", "Rohan", "Yash"]
  setToInactive(id: number) {
    this.inactiveUsers.push(this.activeUsers[id]);
    this.activeUsers.splice(id, 1)
    this.counterService.incrementActiveToInactive();
  }
  setToActive(id: number) {
    this.activeUsers.push(this.inactiveUsers[id]);
    this.inactiveUsers.splice(id, 1)
    this.counterService.incrementInactiveToActive();
  }
  constructor(private counterService:CounterService) { }
}
