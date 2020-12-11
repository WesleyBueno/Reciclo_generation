import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLoginTable } from '../model/UserLoginTable';
import { UsuarioTable } from '../model/UsuarioTable';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  logar(userLogin: UserLoginTable){
    return this.http.post<UserLoginTable>('http://localhost:8080/usuarios/logar', UserLoginTable)
  }
  cadastrar(user: UsuarioTable): Observable<UsuarioTable> {
    return this.http.post<UsuarioTable>('http://localhost:8080/usuarios/cadastrar', UsuarioTable)
  }
  btnSair() {
    let ok = false
    let token = localStorage.getItem('token')

    if (token != null) {
      ok = true
    }
    return ok
  }

  btnLogin() {
    let ok = false
    let token = localStorage.getItem('token')

    if (token == null) {
      ok = true
    }
    return ok
  }
}
