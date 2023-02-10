import { HttpClient, HttpEventType, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { Post } from './Post.model';

@Injectable({
  providedIn: 'root'
})
export class PostsService {
  error=new Subject<string>();

  constructor(private http: HttpClient) { }
  createAndStorePosts(title: string, content: string) {
    const postData = { title: title, content: content };
    //send http request
    this.http.post<{ name: string }>("https://angular-http-13c5b-default-rtdb.firebaseio.com/posts.json",
      postData,
      {
        observe:'response'
      }
    ).subscribe(
      responseData => {
        console.log(responseData)
        //this.fetchPosts();
      },
      errorObj=>{
         this.error.next(errorObj.message)
      }
    )
  }
  fetchPosts() {
    //want to set multiple query params
    let searchParams=new HttpParams();
    searchParams=searchParams.append('print','preety');
    searchParams=searchParams.append('custom','key')
    return this.http.get<{ [key: string]: Post }>
    ("https://angular-http-13c5b-default-rtdb.firebaseio.com/posts.json",
    {
      headers:new HttpHeaders({'Custom-Header':'hello'}),
      //want to set single query params
      // params:new HttpParams().set('print','preety')
      //want to set multiple query params
      params:searchParams,
      responseType:'json'
    })
      .pipe(map(responseData => {
        const postsArray = [];
        for (const key in responseData) {
          if (responseData.hasOwnProperty(key)) {
            postsArray.push({ ...responseData[key], id: key });
          }
        }
        return postsArray;
      }))
  }
  // deletePosts(){
  //   return this.http.delete("https://angular-http-13c5b-default-rtdb.firebaseio.com/posts.json")
  // }

  deletePosts(){
    return this.http.delete("https://angular-http-13c5b-default-rtdb.firebaseio.com/posts.json",
    {
      observe:'events',
      responseType:'text'
    }).pipe(tap(event=>{
      console.log(event)
      if(event.type===HttpEventType.Sent){
        //...
        console.log("request sent ")
      }
      if(event.type===HttpEventType.Response){
        console.log(event.body)
      }
    }))
    ;
  }
  
}
