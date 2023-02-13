import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { PostsService } from './posts.service';
import { AuthInterceptorService } from './auth-interceptor.service';
import { LoggingInterceptorService } from './logging-interceptor.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [PostsService,{
    provide: HTTP_INTERCEPTORS, 
    useClass: AuthInterceptorService, 
    multi: true
  },
  {
    provide: HTTP_INTERCEPTORS, 
    useClass: LoggingInterceptorService, 
    multi: true

  }
],
  bootstrap: [AppComponent]
})
export class AppModule { }
