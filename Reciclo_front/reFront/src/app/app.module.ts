
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ShopComponent } from './shop/shop.component';
import { BrowserModule } from '@angular/platform-browser';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FormsModule } from '@angular/forms';
import {HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { PagamentoComponent } from './pagamento/pagamento.component';
import { CadastroPagamentoComponent } from './cadastro-pagamento/cadastro-pagamento.component';
import { PaginaUsuarioComponent } from './pagina-usuario/pagina-usuario.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { PostCategoriaComponent } from './post-categoria/post-categoria.component';
import { ControleComponent } from './controle/controle.component';
import { OrderModule } from 'ngx-order-pipe';
import { ContatoComponent } from './contato/contato.component';
  import { from } from 'rxjs';
import { UtilitariosComponent } from './utilitarios/utilitarios.component';
import { VestuarioComponent } from './vestuario/vestuario.component';
import { DecoracaoComponent } from './decoracao/decoracao.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    CadastroComponent,
    ShopComponent,
    PagamentoComponent,
    CadastroPagamentoComponent,
    PaginaUsuarioComponent,
    NavbarComponent,
    FooterComponent,
    SidebarComponent,
    PostCategoriaComponent,
    ControleComponent,
    ContatoComponent,
    UtilitariosComponent,
    VestuarioComponent,
    DecoracaoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    FontAwesomeModule,
    HttpClientModule,
    OrderModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }