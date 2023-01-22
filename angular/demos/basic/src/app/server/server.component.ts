import { Component, OnInit } from '@angular/core';

@Component({
  // class selector
  //selector:'.app-server'

  // Attribute selector
  //selector:'[app-server]'
  
  //element selector
  selector:'app-server',
  templateUrl: './server.component.html',
  styleUrls: ['./server.component.css']
})
export class ServerComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  //interpolation
  serverName="test";
  serverStatus="online"
  newServer="";
  newStatus="";
  serverLocation="delhi";
  imageLink="https://thumbs.dreamstime.com/b/built-maharaja-ranjit-singh-gurudwara-patna-sahib-evokes-memory-guru-gobind-tenth-sikhs-takht-sri-gurudwar-bihar-83953356.jpg"
  disabledValue=false;
  active=true
  getSatus():string{
    return this.serverStatus;
  }

  addServer(){
    this.newServer="dev";
    this.newStatus="online"
  }

}
