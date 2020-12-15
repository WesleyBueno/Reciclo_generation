import { Component, OnInit } from '@angular/core';
import { text } from '@fortawesome/fontawesome-svg-core';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    window.scroll(0, 0)
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
