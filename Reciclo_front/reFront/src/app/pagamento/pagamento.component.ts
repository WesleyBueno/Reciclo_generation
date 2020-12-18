import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import Swal from 'sweetalert2'

  declare var paypal: { Buttons: (arg0: { createOrder: (data: any, actions: any) => any; onApprove: (data: any, actions: any) => Promise<void>; onError: (err: any) => void; }) => { (): any; new(): any; render: { (arg0: any): void; new(): any; }; }; };
@Component({
  selector: 'app-pagamento',
  templateUrl: './pagamento.component.html',
  styleUrls: ['./pagamento.component.css']
})
export class PagamentoComponent implements OnInit {

  @ViewChild('paypal',{static: true}) paypalElement!: ElementRef;

  product = {
    price: 39.99,
    description: 'Camiseta', 

  }

  paidFor = false

  constructor() { }

  ngOnInit(){
    paypal.Buttons({
      createOrder: (data:any, actions:any) => {
        return actions.order.create({
          purchase_units: [{
            description: this.product.description,
            amount: {
              currency_code: 'BRL',
              value: this.product.price
            }
          }]
        })
      },
      onApprove: async (data:any, actions:any) => {
        const order = await actions.order.capture()
        this.paidFor = true,
        console.log(order)
      },
      onError: (err: any) => {
        console.log(err)
      }
    })
    .render(this.paypalElement.nativeElement)  }

    qrcodeAlert(){
      Swal.fire({
        title: 'Seu pedido foi enviado!',
        text: 'Apresente esse QR Code em qualquer uma de nossas lojas para finalizar o pagamento e retirar seu pedido',
        imageUrl: 'https://api.qrserver.com/v1/create-qr-code/?size=250x250&data=http://localhost:8080/pedidos/F5A3rs9as93koas31a',
        imageWidth: 250,
        imageHeight: 250,
        imageAlt: 'QR Code',
        footer: 'Esse QR Code foi enviado para seu email'
      })
    }
  
  

}
