import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'reactive-form';
  genders=['male','female','others']
  signupForm:FormGroup
  ngOnInit(): void {
    this.signupForm=new FormGroup({
      'username':new FormControl(null),
      "email":new FormControl(null),
      'gender':new FormControl('male')
    })
  }
}
