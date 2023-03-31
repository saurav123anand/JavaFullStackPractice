import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseUrl } from '../utils/helper';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) { }

  //load all the categories
  public categories(){
     return this.http.get(`${baseUrl}/category/`)
  }

  //add new category
  public addCategory(category){
    return this.http.post(`${baseUrl}/category/`,category)
  }
}
