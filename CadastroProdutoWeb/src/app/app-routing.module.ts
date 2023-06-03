import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CadastroProdutoComponent } from './cadastro/cadastro-produto/cadastro-produto.component';

const routes: Routes = [
  {
    path:'',
    children:[
      {
        path: '',
        component: LoginComponent
      },
      {
        path: 'cadastro/produto',
        component: CadastroProdutoComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
