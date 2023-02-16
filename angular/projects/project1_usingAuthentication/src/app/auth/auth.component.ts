import { NgForOf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthResponseData, AuthService } from './auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  constructor(private authService:AuthService,private router:Router) { }
  isLoginMode=true;
  isLoading=false;
  error:string=null;

  ngOnInit(): void {
  }
  onSwitchMode(){
    this.isLoginMode=!this.isLoginMode;
  }
  onClicked(){
    this.error=null;
  }
  onSubmit(authForm:NgForm){
    //console.log(authForm.value)
    if(!authForm.valid){
      return;
    }
    const email=authForm.value.email;
    const password=authForm.value.password;
    this.isLoading=true;
    let authObs:Observable<AuthResponseData>;
    if(this.isLoginMode){
      authObs= this.authService.login(email,password)
    }
    else{
      authObs=this.authService.signUp(email,password);
    }
    authObs.subscribe(
      resData=>{
        console.log(resData)
        this.isLoading=false;
        this.router.navigate(['/recipes'])
      },
      errorMsg=>{
        this.error=errorMsg
        this.isLoading=false
      }
    )
    authForm.reset()
  }
}
