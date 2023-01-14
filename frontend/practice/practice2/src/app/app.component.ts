import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'practice2';
  showSecret=false;
  logs:number[]=[]
  index=1;
  onToggle(){
    if(this.showSecret==false){
      this.showSecret=true;
    }
    else{
      this.showSecret=false;
    }
    this.logs.push(this.index++);
  }
}