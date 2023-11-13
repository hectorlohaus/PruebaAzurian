import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }
  getData(){
    let url="https://pruebaazurian.up.railway.app/products"
    return this.http.get(url);
  }
}
