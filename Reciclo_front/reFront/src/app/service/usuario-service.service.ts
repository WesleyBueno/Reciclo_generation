import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UsuarioTable } from '../model/UsuarioTable';

@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {

  constructor(private http: HttpClient) { }

token = {
  headers: new HttpHeaders().set('Autorization',localStorage.getItem('token')!)
}

  findIdByEmail(usuarioEmail : string):Observable<UsuarioTable>
  {
    return this.http.get<UsuarioTable>(`http://localhost:8080/usuario/email/${usuarioEmail}`);
  }

}
