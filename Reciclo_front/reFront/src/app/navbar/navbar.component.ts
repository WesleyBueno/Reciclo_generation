import { ProdutoService } from './../service/produto.service';
import { CategoriaTable } from './../model/CategoriaTable';
import { ProdutoTable } from './../model/ProdutoTable';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { SidebarComponent } from "../sidebar/sidebar.component";
import { CategoriaService } from '../service/categoria.service';
import { faShoppingCart, faUser } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  faShoppingCart = faShoppingCart
  faUser = faUser

  key = 'data'
  reverse = true

  produto : ProdutoTable = new ProdutoTable()
  listaProdutos!: ProdutoTable[]
  produtoNome!: string

  categoria : CategoriaTable = new CategoriaTable()
  listaCategorias!: CategoriaTable[]
  categoriaNome!: string


  constructor(
    private router: Router,
    public auth: AuthService,
    private produtoService : ProdutoService,
    private categoriaService : CategoriaService,

  ) { }

  ngOnInit(): void 
  {         
    
  }

  sair(){
    this.router.navigate(['/login'])
    localStorage.clear()
  }

  findAllProdutos(){
    this.produtoService.getAllProdutos().subscribe((resp: ProdutoTable[]) =>{
      this.listaProdutos = resp
    })
  }

  findByNomeProduto(){
    if(this.produtoNome ===''){
      this.findAllProdutos()
    }else{
      this.produtoService.getByNomeProduto(this.produtoNome).subscribe((resp: ProdutoTable[]) =>{
        this.listaProdutos = resp
      })
    }
    this.router.navigate(['/shop'])
  }

}


