import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

const TOKEN_HEADER="Authorization";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private loginService:LoginService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    //add the jwt token(localstorage)
    let modifiedReq=request;
    const token=this.loginService.getToken();
    if(token!=null){
      modifiedReq = request.clone({ 
        headers: request.headers.set(TOKEN_HEADER, `Bearer ${token}`),
      });
    }
    return next.handle(modifiedReq);
  }
}
