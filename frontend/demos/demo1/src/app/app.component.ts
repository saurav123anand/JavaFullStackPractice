import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo1';
  targetValue="_blank"
  isBoolean=false;
  firstname="jdwffhhf";
  link="https://www.javadevjournal.com/spring-boot/microservices-with-spring-boot/";
  imageUrl="https://cdn.pixabay.com/photo/2018/05/12/17/41/forest-3394066_960_720.jpg"
  val=24
  showMsg(){
    alert("hello world")
  }
  valueChanged(){
    if(this.val==24){
      this.val=89;
    }
    else{
      this.val=24;
    }
  }
}
