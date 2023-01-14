import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrls: ['./cockpit.component.css'],
  //encapsulation:ViewEncapsulation.None
})
export class CockpitComponent implements OnInit {
  @Output() serverCreated = new EventEmitter<{ serverName: string, serverContent: string }>();
  @Output() blueprintCreated = new EventEmitter<{ serverName: string, serverContent: string }>();
  //using view child
  @ViewChild('serverInput') serverInput:ElementRef;
  constructor() { }

  ngOnInit(): void {
  }
  newServerName = '';
  newServerContent = '';

  // onAddServer() {
  //   this.serverCreated.emit({
  //     serverName: this.newServerName,
  //     serverContent: this.newServerContent
  //   })
  // }

  // }
  //using template variable
  // onAddServer(serverInput:HTMLInputElement) {
  //   this.serverCreated.emit({
  //     serverName:serverInput.value,
  //     serverContent:this.newServerContent
  //   })

  //using view child
  onAddServer() {
    this.serverCreated.emit({
      serverName: this.serverInput.nativeElement.value,
      serverContent: this.newServerContent
    })
  }


  // onAddBlueprint() {
  //   this.blueprintCreated.emit({
  //     serverName: this.newServerName,
  //     serverContent: this.newServerContent
  //   })
  // }

  //using template variable
  // onAddBlueprint(serverInput:HTMLInputElement) {
  //   this.blueprintCreated.emit({
  //     serverName:serverInput.value,
  //     serverContent:this.newServerContent
  //   })

  //using view child
  onAddBlueprint() {
    this.blueprintCreated.emit({
      serverName: this.serverInput.nativeElement.value,
      serverContent: this.newServerContent
    })
  }
}

