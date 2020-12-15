import { Component, OnInit } from '@angular/core';
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

  categoria: CategoriaTable = new CategoriaTable()
  listaCategorias!: CategoriaTable[]
  idCategoria!: number
  categoriaNome!: string


  constructor(
    private produtoService : ProdutoService,
    private categoriaService : CategoriaService
  ) { }

  ngOnInit(){
    window.scroll(0 , 0)

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

    if(this.produto.produtoNome == null || this.produto.produtoDescricao == null || this.produto.categoria == null){
      alert('preencha todos os campos antes de publicar!')
    } else{
      this.produtoService.postProduto(this.produto).subscribe((resp: ProdutoTable) =>{
        this.produto = resp
        this.produto = new ProdutoTable()
        alert('Postagem realizada com sucesso!')
        this.findAllProdutos()
      })
    }
  }



  findAllCategorias(){
    this.categoriaService.getAllCategorias().subscribe((resp: CategoriaTable[]) =>{
      this.listaCategorias = resp
    })
  }

  findByIdCategoria() {
    this.categoriaService.getByIdCategoria(this.categoria.idCategoria).subscribe((resp: CategoriaTable) =>{
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
