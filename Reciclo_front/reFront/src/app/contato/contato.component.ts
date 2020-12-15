import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrls: ['./contato.component.css']
})
export class ContatoComponent implements OnInit {
/*nome = this.nome
email= this.contato.email
mensagem= this.contato.mensagem*/


  constructor( ) { }

  ngOnInit(): void {
  }
  /*enviar(){
    if(this.contato.nome==null || this.contato.email==null || this.contato.mensagem==null){
    
        alert('Mensagem não pode ser enviada, complete todos os campos antes de enviar!')
        
      })
    }else {
      alert('Mensagem Enviada com sucesso!')
    } */

}
