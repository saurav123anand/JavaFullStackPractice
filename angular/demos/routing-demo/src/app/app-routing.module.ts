import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditServerComponent } from './servers/edit-server/edit-server.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ServerComponent } from './servers/server/server.component';
import { ServersComponent } from './servers/servers.component';
import { UsersComponent } from './users/users.component';
import { HomeComponent } from './home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './users/user/user.component';
import { AuthGuardService } from './auth-guard.service';

const routes:Routes=[
  {
    path:"",
    component:HomeComponent,
    pathMatch:"full"
  },
  {
    path:"users",
    component:UsersComponent,
    children:[
      {
        path:':id/:name',
        component:UserComponent
      }
    ]
  },
  {
    path:"users/:id/:name",
    component:UserComponent,
    pathMatch:"full"
  },
  {
    path:"servers",
    //canActivate:[AuthGuardService],
    canActivateChild:[AuthGuardService],
    component:ServersComponent,
    children:[
      {
        path:":id",
        component:ServerComponent
      },
      {
        path:":id/edit",
        component:EditServerComponent
      }
    ]
  },
  {
    path:"servers/:id",
    component:ServerComponent,
    pathMatch:"full"
  },
  {
    path:"servers/:id/edit",
    component:EditServerComponent,
    pathMatch:"full"
  },
  {
    path:'not-found',component:PageNotFoundComponent
  },
  {
    path:"**",
    redirectTo:'/not-found'
  }
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
