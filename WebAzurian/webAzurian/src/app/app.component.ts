import { Component } from '@angular/core';
import {ProductService} from "./service/product.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webAzurian';
  data=[] as any;

  constructor(private product:ProductService) {
    this.product.getData().subscribe(data=>{
      console.warn(data)
      this.data=data;
    })
  }
}
