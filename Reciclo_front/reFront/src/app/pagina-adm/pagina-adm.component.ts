import { Component, OnInit } from '@angular/core';
import { ProdutoTable } from '../model/ProdutoTable';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-pagina-adm',
  templateUrl: './pagina-adm.component.html',
  styleUrls: ['./pagina-adm.component.css']
})
export class PaginaAdmComponent implements OnInit {

  listaProdutos!:ProdutoTable[]

  constructor(public produtoService:ProdutoService) { }

  ngOnInit() 
  {
    window.scroll(0, 0)
    this.findAllProdutos()    
  }

  delete(id:number)
  {
    this.produtoService.deleteProduto(id).subscribe(response =>
      {
        alert("deletado com sucesso!")  
    }, errorResponse => {alert("Erro!")})
  }
 
  findAllProdutos() {
    this.produtoService.getAllProdutos().subscribe((resp: ProdutoTable[]) => {
      this.listaProdutos = resp
    })

  }
}
