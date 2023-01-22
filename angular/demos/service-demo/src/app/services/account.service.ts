import { Injectable } from '@angular/core';
import { statSync } from 'fs';
import { LoggingService } from './logging.service';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private loggingService:LoggingService) { }
  accounts=[
    {
      name:"Master Account",
      status:"Active"
    },
    {
      name:"Savings Account",
      status:"Inactive"
    }
  ]
  addAccount(name:string,status:string){
    this.accounts.push({name:name,status:status});
    this.loggingService.logToConsole(status)
  }
  updateStatus(id:number,newStatus:string){
    this.accounts[id].status=newStatus;
  }
}
