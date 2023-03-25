import { Component, ElementRef, HostListener, OnInit, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  @ViewChild('navbar') navbar: any;
  @ViewChild('nav_link') nav_link: any;
  constructor() { }

  ngOnInit(): void {
  }
  @HostListener('window:scroll') scrollHandler(eventData: Event) {
    this.navbar.nativeElement.classList.toggle('extend', document.documentElement.scrollTop > 0)
    this.nav_link.nativeElement.classList.toggle('nav_link_extend', document.documentElement.scrollTop > 0)
  }

}
