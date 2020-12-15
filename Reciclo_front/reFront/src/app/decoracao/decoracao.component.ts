import { Component, OnInit } from '@angular/core';
import { CategoriaTable } from '../model/CategoriaTable';
import { CategoriaService } from '../service/categoria.service';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-decoracao',
  templateUrl: './decoracao.component.html',
  styleUrls: ['./decoracao.component.css']
})
export class DecoracaoComponent implements OnInit {

  key = 'data'
  reverse = true

  categoria : CategoriaTable = new CategoriaTable()
  listaCategorias!: CategoriaTable[]
  categoriaNome!: string

  constructor(
    private produtoService : ProdutoService,
    private categoriaService : CategoriaService,
  ) { }

  ngOnInit(){
    window.scroll(0,0)
    this.findByCategoriaNome()
  }

  findAllCategorias(){
    this.categoriaService.getAllCategorias().subscribe((resp: CategoriaTable[]) =>{
      this.listaCategorias = resp
    })
  }

  findByCategoriaNome(){
    if(this.categoriaNome === 'Decoração'){
      this.findAllCategorias()
    }else{
      this.categoriaService.getByNomeCategoria(this.categoriaNome).subscribe((resp: CategoriaTable[]) =>{
        this.listaCategorias = resp
      })
    }
  }

}
