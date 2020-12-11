import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProdutoTable } from '../model/ProdutoTable';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http: HttpClient) { }


  token = {
    headers: new HttpHeaders().set('Authorization',localStorage.getItem('token')!)
  }

  getAllProdutos():Observable<ProdutoTable[]>{
    return this.http.get<ProdutoTable[]>('http://localhost:8080/produto/all')
  }

  getByIdProdutos(id : number):Observable<ProdutoTable>{
    return this.http.get<ProdutoTable>(`http://localhost:8080/produto/id${id}`)
  }

  postProduto(produto: ProdutoTable):Observable<ProdutoTable>{
    return this.http.post<ProdutoTable>('http://localhost:8080/produto',produto)
  }
}
