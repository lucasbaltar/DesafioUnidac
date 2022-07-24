import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { ItensComponent } from './itens/itens.component';

const routes: Routes = [

  {path:'', redirectTo: 'inicio', pathMatch: 'full'},

  {path: 'inicio', component: InicioComponent},
  {path: 'itens', component: ItensComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
