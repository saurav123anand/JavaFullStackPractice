import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggingService {

  constructor() { }
  logToConsole(logData:string){
    console.log(logData);
  }
}
