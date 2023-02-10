import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Post } from './Post.model';
import { PostsService } from './posts.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit,OnDestroy {
  loadedPosts: Post[] = [];
  isFetching = false;
  error=null;
  private errorSub:Subscription
  constructor(private http: HttpClient, private postService: PostsService) { }
  ngOnInit() {
    this.errorSub=this.postService.error.subscribe(
      errorMsg=>{
        this.error=errorMsg;
      }
    )
    //this.fetchPosts();
    this.isFetching = true
    return this.postService.fetchPosts().subscribe(
      posts => {
        this.isFetching = false;
        this.loadedPosts = posts;
      },errorObj=>{
        this.isFetching=false;
        this.error=errorObj.message;
      }
    );
  }
  onCreatePost(postData: Post) {
    this.postService.createAndStorePosts(postData.title, postData.content)
    this.errorSub=this.postService.error.subscribe(
      errorMsg=>{
        this.error=errorMsg;
      }
    )
  }
  onFetchPosts() {
    //this.fetchPosts()
    this.isFetching = true
    return this.postService.fetchPosts().subscribe(
      posts => {
        this.isFetching = false;
        this.loadedPosts = posts;
      },
      errorObj=>{
        this.error=errorObj.message;
        this.isFetching=false;
      }
    );

  }
  //private fetchPosts(){
  // this.isFetching=true;
  // this.http.get<{[key:string]:Post}>("https://angular-http-13c5b-default-rtdb.firebaseio.com/posts.json")
  // .pipe(map(responseData=>{
  //   const postsArray=[];
  //   for(const key in responseData){
  //     if(responseData.hasOwnProperty(key)){
  //       postsArray.push({...responseData[key],id:key});
  //     }
  //   }
  //   return postsArray;
  // }
  //   )).subscribe(
  //   posts=>{
  //     //console.log(posts);
  //     this.isFetching=false;
  //     this.loadedPosts=posts;
  //   }
  // )
  //}

  onDeletePosts() {
    this.postService.deletePosts().subscribe(() => {
      this.loadedPosts = []
    })
  }
  ngOnDestroy(): void {
    this.errorSub.unsubscribe()
  }
  onHandleError(){
    this.error=null
  }

}
