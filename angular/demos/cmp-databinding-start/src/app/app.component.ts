import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'cmp-databinding-start';
  serverElements = [{type: 'server',name: "test server",content:"this is a test server"}];
  onServerAdded(serverData:{serverName:string,serverContent:string}){
    this.serverElements.push({
      type:"server",
      name:serverData.serverName,
      content:serverData.serverContent
    })
  }
  onBlueprintAdded(serverData:{serverName:string,serverContent:string}){
    this.serverElements.push({
      type:"blueprint",
      name:serverData.serverName,
      content:serverData.serverContent
    })
  }
}
