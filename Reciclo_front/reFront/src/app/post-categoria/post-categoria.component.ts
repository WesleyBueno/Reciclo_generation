import { CategoriaService } from './../service/categoria.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoriaTable } from '../model/CategoriaTable';



@Component({
  selector: 'app-post-categoria',
  templateUrl: './post-categoria.component.html',
  styleUrls: ['./post-categoria.component.css']
})
export class PostCategoriaComponent implements OnInit {

  categoria: CategoriaTable = new CategoriaTable()
  listaCategorias!: CategoriaTable[]
  

  constructor(
    private categoriaService : CategoriaService, 
    private router : Router
  ) { }

  ngOnInit() {
    this.findAllCategorias()
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

  cadastrar(){
    if(this.categoria.categoriaNome == null){
      alert('Preencha o campo')
    } else {
      this.categoriaService.postCategoria(this.categoria).subscribe((resp: CategoriaTable) =>{
        this.categoria = resp        
        alert('Tema cadastrado com sucesso!')
        this.findAllCategorias()
      })
    }
  }

  }
