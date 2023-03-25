import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm: FormGroup;
  constructor(private userService: UserService, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.initForm();
  }
  //,this.whitespaceValidation.bind(this)

  private initForm() {
    this.signupForm = new FormGroup({
      'username': new FormControl(null, [Validators.required,
        this.whitespaceValidation.bind(this),this.nameValidation.bind(this)]),
      'password': new FormControl(null, [Validators.required,this.passwordValidator.bind(this)]),
      'firstName': new FormControl(null, [Validators.required,
        this.whitespaceValidation.bind(this)
      ,this.nameValidation.bind(this)]),
      'lastName': new FormControl(null, [Validators.required,this.whitespaceValidation.bind(this)
      ,this.nameValidation.bind(this)]),
      'email': new FormControl(null, [Validators.required, Validators.email,this.whitespaceValidation.bind(this)]),
      'phone': new FormControl(null, [Validators.required,this.phoneValidation.bind(this)])
    })

  }

  onSignup() {
    //addUser:UserService
    const user = new User(this.signupForm.value['username'], this.signupForm.value['password'], this.signupForm.value['firstName'],
      this.signupForm.value['lastName'], this.signupForm.value['email'], this.signupForm.value['phone'])
    this.userService.addUser(user).subscribe(
      (data) => {
        Swal.fire(
          'Success!',
          'Successfully registered!',
          'success'
        )
      },
      err => {
        // console.log(err);
        // console.log(err.message)
        // console.log(err.status)
        if(err.status===403){
          this.snackBar.open(err.error, '', {
            duration: 3000
          })
        }
        else{
          this.snackBar.open("Something went wrong !!", '', {
            duration: 3000
          })
        }
      }
    )
  }

  //username validation 
  whitespaceValidation(control: FormControl): { [s: string]: boolean } {
    let isWhitespace = (control.value || '').trim().length === 0;
    if (isWhitespace) {
      return { 'whitespace': true };
    }
    return null;
  }
  phoneValidation(control: FormControl): { [s: string]: boolean } {
    //let phoneLength=(control.value).length;
    if((control.value)?.length < 10 || (control.value)?.length > 10){
      return { 'phoneInvalid': true };
    }
    return null;
  }
  nameValidation(control: FormControl): { [s: string]: boolean } {
    if((control.value)?.length<3 || (control.value)?.length>20){
      return { 'nameInvalid': true };
    }
    return null;
  }
  passwordValidator(control: FormControl): { [s: string]: boolean } {
    if((control.value)?.length<6 || (control.value)?.length>20){
      return { 'passwordInvalid': true };
    }
    return null;
  }
}
