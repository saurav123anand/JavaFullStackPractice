import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user = null
  greet = "Good Morning";
  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.user = this.loginService.getUser();
    this.getCurrentTime();
  }
  getCurrentTime() {
    const time = new Date().getHours()
    if (time < 12) {
      this.greet = "Good morning"
    }
    else if (time >= 12 && time < 18) {
      this.greet = "Good afternoon"
    }
    else {
      this.greet = "Good evening"
    }
  }

}
