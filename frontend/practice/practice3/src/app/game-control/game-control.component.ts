import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-game-control',
  templateUrl: './game-control.component.html',
  styleUrls: ['./game-control.component.css']
})
export class GameControlComponent implements OnInit {
  @Output() intervalFired=new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }
  interval:any;
  incrementedNum=0
  onStartGame(){
    this.interval=setInterval(()=>{
      this.intervalFired.emit(this.incrementedNum+1)
      this.incrementedNum++;
    },1000)
  }
  onPauseGame(){
    clearInterval(this.interval)
  }

}
