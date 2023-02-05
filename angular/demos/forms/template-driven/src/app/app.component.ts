import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('f') signupForm: NgForm;
  title = 'template-driven';
  defaultQuestion="pet"
  genders=['Male','Female','Others']
  answer='';
  // onSubmit(form:NgForm){
  //   console.log(form)
  // }
  user={
    username:'',
    email:'',
    secretQuestion:'',
    answer:'',
    gender:''
  }
  submitted=false
  onSubmit() {
    //console.log(this.signupForm)
    this.submitted=true;
    this.user.username=this.signupForm.value.userData.username;
    this.user.email=this.signupForm.value.userData.email;
    this.user.secretQuestion=this.signupForm.value.secret;
    this.user.answer=this.signupForm.value.questionAnswer;
    this.user.gender=this.signupForm.value.gender;
    this.signupForm.reset();
  }
  suggestUserName(){
    const suggestedName="Katty";
    // this.signupForm.setValue({
    //   userData:{
    //     username:suggestedName,
    //     email:""
    //   },
    //   secret:"",
    //   questionAnswer:'',
    //   gender:''
    // })

    //better way
    this.signupForm.form.patchValue({
      userData:{
        username:suggestedName
      }
    })
  }
}
