import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoriaTable } from '../model/CategoriaTable';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http: HttpClient) { }

  token = {
    headers: new HttpHeaders().set('Authorization',localStorage.getItem('token')!)
  }

  getAllCategorias():Observable<CategoriaTable[]>{
    return this.http.get<CategoriaTable[]>('http://localhost:8080/categoria',this.token)
  }

  getByIdCategoria(id : number):Observable<CategoriaTable>{
    return this.http.get<CategoriaTable>(`http://localhost:8080/categoria/id/${id}`,this.token)
  }

  postCategoria(categoria: CategoriaTable):Observable<CategoriaTable>{
    return this.http.post<CategoriaTable>('http://localhost:8080/categoria',this.token)
  }
  putCategoria(id : number):Observable<CategoriaTable>{
    return this.http.put<CategoriaTable>(`http://localhost:8080/categoria/${id}` , this.token)
  }
  deleteCategoria(id : number):Observable<CategoriaTable>{
    return this.http.delete<CategoriaTable>(`http://localhost:8080/categoria/${id}`, this.token)
  }
  getByNomeCategoria(categoriaNome : string):Observable<CategoriaTable[]>{
    return this.http.get<CategoriaTable[]>(`http://localhost:8080/categoria/${categoriaNome}`, this.token)
  }
}
