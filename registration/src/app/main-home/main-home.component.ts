import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-home',
  templateUrl: './main-home.component.html',
  styleUrls: ['./main-home.component.css']
})
export class MainHomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  course= [
    {'id':1,'name':'Create Team','description':'','image':'../../assets/logo1.png','url':'createteam'},
    {'id':2,'name':'Create Player','description':'','image':'../../assets/logo2.jpg'},
    {'id':3,'name':'Show Team ','description':'','image':'../../assets/logo1.png'},
    {'id':4,'name':'Show Player','description':'','image':'../../assets/logo2.jpg'},
  ]
}
