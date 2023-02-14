import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { ServersService } from '../servers.service';

@Injectable({
  providedIn: 'root'
})
export class ServerResolverService implements Resolve<{id:number,name:string,status:string}> {

  constructor(private serverService:ServersService) { }
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): { id: number; name: string; status: string; } | Observable<{ id: number; name: string; status: string; }> | Promise<{ id: number; name: string; status: string; }> {
    return this.serverService.getServer(+route.params['id'])
  }
}
