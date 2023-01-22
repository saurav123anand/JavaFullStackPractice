import { Component, ElementRef, EventEmitter, Output, ViewChild } from '@angular/core';
import { AccountService } from '../services/account.service';
import { LoggingService } from '../services/logging.service';

@Component({
  selector: 'app-new-account',
  templateUrl: './new-account.component.html',
  styleUrls: ['./new-account.component.css']
})
export class NewAccountComponent  {
  accountName='';
  @ViewChild('status') statusEl:ElementRef; 
  constructor(private loggingService:LoggingService,private accountService:AccountService ) { }

  onCreateAccount(){
     this.accountService.addAccount(this.accountName,this.statusEl.nativeElement.value)
    // console.log("account created with name "+this.accountName)
    //this.loggingService.logToConsole("account created with name "+this.accountName)
  }

}
