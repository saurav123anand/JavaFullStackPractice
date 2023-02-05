import { EventEmitter } from '@angular/core';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  // activatedEmitter=new EventEmitter<boolean>();
  activatedEmitter=new Subject<boolean>();
  constructor() { }
}
