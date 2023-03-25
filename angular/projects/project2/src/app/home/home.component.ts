import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  sliderData=[
    {img:"https://rstheme.com/products/html/gimnas/images/classes2/1.jpg",title:"BODYBUILDING"
    ,text:"Lorem ipsum dolor, sit amet consectetur adipisicing elit. Cumque, iusto.",buttonData:"JOIN NOW"},
    {img:"https://rstheme.com/products/html/gimnas/images/classes2/2.jpg",title:"LOSE WEIGHT"
    ,text:"Lorem ipsum dolor, sit amet consectetur adipisicing elit. Cumque, iusto.",buttonData:"JOIN NOW"},
    {img:"https://rstheme.com/products/html/gimnas/images/classes2/3.jpg",title:"YOGA FITNESS"
    ,text:"Lorem ipsum dolor, sit amet consectetur adipisicing elit. Cumque, iusto.",buttonData:"JOIN NOW"},
    {img:"https://rstheme.com/products/html/gimnas/images/classes2/4.jpg",title:"BOXING"
    ,text:"Lorem ipsum dolor, sit amet consectetur adipisicing elit. Cumque, iusto.",buttonData:"JOIN NOW"}
  ]

}
