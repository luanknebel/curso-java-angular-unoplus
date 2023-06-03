import { Component, OnInit } from '@angular/core';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { ProdutoDTO } from 'src/app/core/model/produto.dto';

@Component({
  selector: 'app-cadastro-produto',
  templateUrl: './cadastro-produto.component.html',
  styleUrls: ['./cadastro-produto.component.css']
})
export class CadastroProdutoComponent implements OnInit {

  public produtoDTO!: ProdutoDTO;

  constructor() { 
    this.produtoDTO = new ProdutoDTO();
  }

  datepickerEvent(event: MatDatepickerInputEvent<Date>) {
    this.produtoDTO.dataCadastro = event.value;
  }

  ngOnInit(): void {
  }

}
