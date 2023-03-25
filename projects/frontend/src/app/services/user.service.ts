import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { baseUrl } from '../utils/helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  // add user
  public addUser(user:User){
    return this.http.post(`${baseUrl}/user/`,user)
  }
}
