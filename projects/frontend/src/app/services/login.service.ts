import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { baseUrl } from '../utils/helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public loginStatusSubject=new Subject<boolean>();
  constructor(private http:HttpClient) { }

  //current user: which is loggedIn
  public getCurrentUser(){
    return this.http.get(`${baseUrl}/current-user`)
  }

  //generate token
  public generateToken(loginData:{username:string,password:string}){
    return this.http.post(`${baseUrl}/generate-token`,loginData)
  }

  //login user : set token in local storage
  public loginUser(token){
    localStorage.setItem("token",token);
    return true;
  }

  //isLogin : user is logged in or not 
  public isLoggedIn(){
    let tokenStr=localStorage.getItem('token');
    if(tokenStr==undefined || tokenStr=='' || tokenStr==null){
      return false;
    }
    return true;
  }

  //logout : remove token froom localstorage
  public logout(){
    localStorage.removeItem("token");
    localStorage.removeItem('user')
    return true;
  }

  //get token 
  public getToken(){
    return localStorage.getItem("token");
  }

  //set user details
  public setUser(user){
    localStorage.setItem('user',JSON.stringify(user))
  }

  //get user 
  public getUser(){
    let userStr=localStorage.getItem('user');
    if(userStr!=null){
      return JSON.parse(userStr);
    }
    else{
      this.logout();
      return null;
    }
  }

  //get user role
  public getUserRole(){
    let user=this.getUser();
    return user.authorities[0].authority;
  }

}


