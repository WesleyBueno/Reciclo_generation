import { Component, OnInit } from '@angular/core';
import { text } from '@fortawesome/fontawesome-svg-core';
import Swal from 'sweetalert2'
import { ProdutoTable } from '../model/ProdutoTable';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  produto:ProdutoTable = new ProdutoTable();
  listaProdutos: ProdutoTable[] = [];

  constructor(public produtoService:ProdutoService) { }

  ngOnInit() {
    window.scroll(0, 0)
    this.findAllProdutos()
  }

  findAllProdutos()
  {
    this.produtoService.getAllProdutos().subscribe((resp:ProdutoTable[])=>
    {
      this.listaProdutos=resp
    })
  }


  info(){
    Swal.fire({
      imageUrl: 'https://placeholder.pics/svg/300x1500',
      imageWidth: 250,
      imageHeight: 250,
      imageAlt: 'A tall image',
      text:'feito no japão!'
    })
  }

}
