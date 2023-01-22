import { Component, Input, OnInit, Output,EventEmitter } from '@angular/core';
import { statSync } from 'fs';
import { AccountService } from '../services/account.service';
import { LoggingService } from '../services/logging.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  @Input() account:{ name: string; status: string; } | undefined;
  @Input() id;
  constructor(private loggingService:LoggingService,private accountService:AccountService) { }

  ngOnInit(): void {
  }
  onSetTo(status:string){
    this.accountService.updateStatus(this.id,status)

    // console.log("new status changed "+status)
    this.loggingService.logToConsole("new status changed "+status)
  }

}
