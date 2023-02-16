import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, catchError, Subject, tap, throwError } from 'rxjs';
import { User } from './user.model';

export interface AuthResponseData{
  idToken:string,
  email:string,
  refreshToken:string,
  expiresIn:string,
  localId:string,
  registered?:string;
}
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  // user=new Subject<User>();
  user=new BehaviorSubject<User>(null);
  private tokenExpirationTimer:any;
  constructor(private http:HttpClient,private router:Router) { }

  signUp(email:string,password:string){
    return this.http.post<AuthResponseData>(
    "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyDHM85sSfNikqrK25l595P65aORXG5WfZg",
    {
      email:email,
      password:password,
      returnSecureToken:true
    })
    .pipe(catchError(this.handleError),tap(resData=>{
      this.handleAuthentication(resData.email,resData.localId,resData.idToken,resData.expiresIn);
    }))
  }

  login(email:string,password:string){
    return this.http.post<AuthResponseData>(
      "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDHM85sSfNikqrK25l595P65aORXG5WfZg",
      {
        email:email,
        password:password,
        returnSecureToken:true
      }).pipe(catchError(this.handleError),tap(resData=>{
        this.handleAuthentication(resData.email,resData.localId,resData.idToken,resData.expiresIn);
      }));
  }
  autoLogin(){
    const userData:{email:string,id:string,_token:string,_tokenExpirationDate:string}=
    JSON.parse(localStorage.getItem('userData'));
    if(!userData){
      return;
    }
    const loadedUser=new User(userData.email,userData.id,userData._token,userData._tokenExpirationDate);
    if(loadedUser.token){
      this.user.next(loadedUser);
      const expirationDuration=new Date(userData._tokenExpirationDate).getTime()-new Date().getTime();
      this.autoLogout(expirationDuration);
    }
  }
  autoLogout(expirationDuration:number){
    this.tokenExpirationTimer=setTimeout(() => {
       this.logout()
    }, expirationDuration);
  }
  logout(){
    this.user.next(null);
    this.router.navigate(['/auth'])
    localStorage.removeItem('userData');
    if(this.tokenExpirationTimer){
      clearTimeout(this.tokenExpirationTimer)
    }
    this.tokenExpirationTimer=null;

  }
  private handleAuthentication(email:string,userId:string,token:string,expiresIn:string){
    const expirationDate=new Date(new Date().getTime()+ +expiresIn*1000);
    const user=new User(email,userId,token,expirationDate);
    this.user.next(user);
    localStorage.setItem('userData',JSON.stringify(user));
  }
  private handleError(errorRes:HttpErrorResponse){
    let errorMessage="An unknown error occurred";
    if(!errorRes.error || !errorRes.error.error){
      return throwError(errorMessage);
    }
    switch (errorRes.error.error.message) {
      case "EMAIL_EXISTS":
        errorMessage="this email exists already"
        break;
        case "EMAIL_NOT_FOUND":
        errorMessage="this email does not exist"
        break;
        case "INVALID_PASSWORD":
          errorMessage="This Password is not correct"
          break;
    }
    return throwError(errorMessage);
  }
}
