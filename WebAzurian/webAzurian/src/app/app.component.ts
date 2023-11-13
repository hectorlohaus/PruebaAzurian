import {Component} from '@angular/core';
import {ProductService} from "./service/product.service";
import {Observable} from "rxjs";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'webAzurian';
  data=[] as any;
  pages=1;


  constructor(private product:ProductService) {
    this.product.getData().subscribe(data=>{
      console.warn(data)
      this.data=data;
    })
  }

}



