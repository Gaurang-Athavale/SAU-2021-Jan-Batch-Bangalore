import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SessionComponent } from './session/session.component';
import { ApiModuleComponent } from './api-module/api-module.component';


const routes: Routes = [
  { path: "api", component: ApiModuleComponent },
  { path: "", component: SessionComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
