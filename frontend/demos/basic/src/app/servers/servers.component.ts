import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',

  //inline html
//  template:`
//  <h1>this is heading</h1>
//  <p>servers works!</p>
// <app-server></app-server>
// <app-server></app-server>
//  `,
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
     
  }
  servers=["sql Server","Java Server","Tomcat server","Netty Server"]
 // customServer=new Server("disney server",8787);

 styles={color:'red',backgroundColor:'black'};
 num=47
}

// class Server{
//   constructor(private serverName:string,private serverport:number){}
// }