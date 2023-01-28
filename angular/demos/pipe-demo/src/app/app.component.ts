import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  amount=45;
  servers=[
    {
      name:"Development Server",
      status:"Online",
      started:new Date(15,1,2022)
    },
    {
      name:"production Server",
      status:"Online",
      started:new Date(15,12,2021)
    },
    {
      name:"Testing Server",
      status:"Offline",
      started:new Date(1,9,2022)
    }
  ]


}
