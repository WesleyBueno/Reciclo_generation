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
    return this.http.get<ProdutoTable>(`http://localhost:8080/produto/id/${id}`, this.token)
  }

  postProduto(produto: ProdutoTable):Observable<ProdutoTable>{
    return this.http.post<ProdutoTable>('http://localhost:8080/produto',produto, this.token)
  }
  putProduto(produto: ProdutoTable):Observable<ProdutoTable>{
    return this.http.put<ProdutoTable>(`http://localhost:8080/produto/${produto.idProduto}`, produto, this.token) 
  }
  deleteProduto(id: number):Observable<ProdutoTable>{
    return this.http.delete<ProdutoTable>(`http://localhost:8080/produto/${id}`, this.token)
  }
  getByNomeProduto(produtoNome: string):Observable<ProdutoTable[]>{
    return this.http.get<ProdutoTable[]>(`http://localhost:8080/produto/nome/${produtoNome}`)
  }
}
