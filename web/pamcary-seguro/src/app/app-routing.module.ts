import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditPessoaComponent } from './edit-pessoa/edit-pessoa.component';

import { PessoaComponent } from './pessoa/pessoa.component';

const routes: Routes = [

  {path: '', pathMatch: 'full', redirectTo:'pessoa'},

  {

    path: 'pessoa',
    loadChildren: () => import('./pessoa/pessoa.module').then(m => m.PessoaModule)
  },

  {

    path: 'add-pessoa',
    loadChildren: () => import('./add-pessoa/add-pessoa.module').then(m => m.AddPessoaModule)
  },

  {
    path: 'edit-pessoa/:codigo', component: EditPessoaComponent

  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
