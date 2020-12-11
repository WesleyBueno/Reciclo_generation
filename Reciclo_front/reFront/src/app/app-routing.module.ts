
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CadastroPagamentoComponent } from './cadastro-pagamento/cadastro-pagamento.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PagamentoComponent } from './pagamento/pagamento.component';
import { PaginaUsuarioComponent } from './pagina-usuario/pagina-usuario.component';
import { PostCategoriaComponent } from './post-categoria/post-categoria.component';
import { ShopComponent } from './shop/shop.component';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch:'full'},
  { path: 'home', component: HomeComponent},
  { path: 'shop', component: ShopComponent},
  { path: 'pagina-usuario', component: PaginaUsuarioComponent},
  { path: 'cadastro' , component: CadastroComponent},
  { path: 'cadastro-pagamento', component: CadastroPagamentoComponent},
  { path: 'carrinho', component: CarrinhoComponent},
  { path: 'login', component: LoginComponent},
  { path: 'pagamento', component: PagamentoComponent},
  { path: 'post-categoria', component: PostCategoriaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
