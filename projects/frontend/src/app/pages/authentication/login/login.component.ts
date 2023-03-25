import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData={
    username:"",
    password:""
  }
  

  constructor(private snackBar: MatSnackBar,private loginService:LoginService,private router:Router) { }

  ngOnInit(): void {
    
  }
  formSubmit(){
    console.log(this.loginData)
    if(this.loginData.username==null || this.loginData.username.trim()==''){
      this.snackBar.open("Username is required !!", '', {
        duration: 3000
      })
      return;
    }
    if(this.loginData.password==null || this.loginData.password.trim()==''){
      this.snackBar.open("password is required !!", '', {
        duration: 3000
      })
      return;
    }

    //request server to generate token
    this.loginService.generateToken(this.loginData).subscribe(
      data=>{
        console.log(data)
        this.loginService.loginUser(data['token']);
        this.loginService.getCurrentUser().subscribe(
          (user)=>{
            this.loginService.setUser(user);
            console.log(user)
            //redirect... ADMIN:Admin dashboard
            if(this.loginService.getUserRole()=='ADMIN'){
              this.router.navigate(['/admin'])
              this.loginService.loginStatusSubject.next(true);
            }
            //redirect... NORMAL:Normal dashboard
            else if(this.loginService.getUserRole()=='NORMAL'){
              this.router.navigate(['/user-dashboard'])
              this.loginService.loginStatusSubject.next(true);
            }
            else{
              this.loginService.logout();
            }

          }
        )
      },
      err=>{
        console.log("Error !");
        console.log(err);
        this.snackBar.open('Invalid details !! Try again','',{
          duration:3000
        })
      }
    )
  }

}
