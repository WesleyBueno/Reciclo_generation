import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserLoginTable } from '../model/UserLoginTable';
import { UsuarioTable } from '../model/UsuarioTable';
import { AuthService } from '../service/auth.service';
import { UsuarioServiceService } from '../service/usuario-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  userLogin: UserLoginTable= new UserLoginTable()
  usuario:UsuarioTable=new UsuarioTable()

  constructor(
    private authService: AuthService,
    private router: Router,
    private usuarioService:UsuarioServiceService
  ) { }

  ngOnInit() {
  }

  // Método que busca o usuario no banco de dados e verifica o usuário
  entrar(){
    this.authService.logar(this.userLogin).subscribe((resp: UserLoginTable)=>{            
      // Verifica se ouve algum erro quando for puxar o usuario do banco.
      // Caso nao tenha encontrado o email ou a senha estiver incorreta
      // Vai para o bloco do else e emite um alerta!
      if(resp != null)
      {
        this.userLogin = resp
        // Armazena o token no loacalStorage
        localStorage.setItem('token', this.userLogin.token)   
        this.acesso()        
        // vai para o componente shop
        this.router.navigate(['/shop'])
      }
      else
        alert("Email ou senha incorreto!")      
    })
            
  }

  acesso()
  {
    console.log(this.userLogin.usuario)
    console.log(this.usuarioService.findIdByEmail(this.userLogin.usuario))
    this.usuarioService.findIdByEmail(this.userLogin.usuario).subscribe((resp: UsuarioTable) => {
      this.usuario = resp
      localStorage.setItem('acesso', this.usuario.usuarioTipo)
    })
  }

}
