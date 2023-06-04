import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CadastroProdutoComponent } from './cadastro/cadastro-produto/cadastro-produto.component';
import { AuthGuardService } from './core/security/auth-guard.service';

const routes: Routes = [
  {
    path:'',
    children:[
      {
        path: '',
        component: LoginComponent
      },
      {
        path: 'cadastro',
        canActivate: [AuthGuardService],
        children : [
          {
            path: 'produto',
            component: CadastroProdutoComponent
          }
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
