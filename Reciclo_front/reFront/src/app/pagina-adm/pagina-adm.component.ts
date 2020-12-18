import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProdutoTable } from '../model/ProdutoTable';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-pagina-adm',
  templateUrl: './pagina-adm.component.html',
  styleUrls: ['./pagina-adm.component.css']
})
export class PaginaAdmComponent implements OnInit {

  listaProdutos!:ProdutoTable[]
  idProd!:number

  constructor(public produtoService:ProdutoService,
    private activatedRoute: ActivatedRoute,
    private router:Router) { }

  ngOnInit() 
  {
    window.scroll(0, 0)
    let params = this.activatedRoute.snapshot
    this.idProd = params.params["id"]
    if (params && params.params["id"]) 
    {
      this.delete ()
      this.router.navigate(['/pagina-adm'])
      this.findAllProdutos()
    }

    this.findAllProdutos()
  }

  delete()
  {

    this.produtoService.deleteProduto(this.idProd).subscribe(response =>
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
