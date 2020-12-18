import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { CategoriaTable } from '../model/CategoriaTable';
import { ProdutoTable } from '../model/ProdutoTable';
import { CategoriaService } from '../service/categoria.service';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-controle',
  templateUrl: './controle.component.html',
  styleUrls: ['./controle.component.css']
})
export class ControleComponent implements OnInit {

  key = 'data'
  reverse = true
  
  produto : ProdutoTable = new ProdutoTable()
  listaProdutos!: ProdutoTable[]
  produtoNome!: string
  idProd!:number

  categoria: CategoriaTable = new CategoriaTable()
  listaCategorias!: CategoriaTable[]
  idCategoria!: number
  categoriaNome!: string


  constructor(
    private produtoService : ProdutoService,
    private categoriaService : CategoriaService,
    private router:Router,
    private activatedRoute:ActivatedRoute
  ) { }

  ngOnInit(){
    window.scroll(0 , 0)    

    let params = this.activatedRoute.snapshot    
    console.log(this.activatedRoute.params)   
    if (params && params.params["id"])
    {
      this.idProd = params.params["id"]
      this.produtoService.getByIdProdutos(this.idProd)
        .subscribe(response=>this.produto = response ,
          errorResponse => this.produto = new ProdutoTable())
    }
    this.findAllProdutos()
    this.findAllCategorias()
  }

  findAllProdutos(){
    this.produtoService.getAllProdutos().subscribe((resp: ProdutoTable[]) =>{
      this.listaProdutos = resp
    })
  }

  publicar(){

    this.categoria.idCategoria = this.idCategoria
    this.produto.categoria = this.categoria

    if (this.idProd)
    {
      this.produtoService.putProduto(this.produto)
        .subscribe(response=>{
          alert('Edição realizada com sucesso!')
          this.router.navigate(['/pagina-adm'])
          this.findAllProdutos()
        },errorResponse=>{
            alert('Erro! Verifique os campos!')
        })
    }
    else
    {
      if(this.produto.produtoNome == null || this.produto.produtoDescricao == null || this.produto.categoria == null){
        alert('preencha todos os campos antes de publicar!')
      } else{
        this.produtoService.postProduto(this.produto).subscribe((resp: ProdutoTable) =>{
          this.produto = resp
          this.produto = new ProdutoTable()
          alert('Cadastro realizada com sucesso!')
          this.router.navigate(['/pagina-adm'])
          this.findAllProdutos()
        })
      }
    }
  }



  findAllCategorias(){
    this.categoriaService.getAllCategorias().subscribe((resp: CategoriaTable[]) =>{
      this.listaCategorias = resp
    })
  }

  findByIdCategoria() {
    this.categoriaService.getByIdCategoria(this.idCategoria).subscribe((resp: CategoriaTable) =>{
      this.categoria = resp;
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
  }

  findByCategoriaNome(){
    if(this.categoriaNome === ''){
      this.findAllCategorias()
    }else{
      this.categoriaService.getByNomeCategoria(this.categoriaNome).subscribe((resp: CategoriaTable[]) =>{
        this.listaCategorias = resp
      })
    }
  }

}
