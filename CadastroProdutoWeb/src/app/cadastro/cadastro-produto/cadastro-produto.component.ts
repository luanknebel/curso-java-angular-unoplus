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
  displayedColumns: string[] = ['idProduto', 'descricao', 'dataCadastro', 'valor', 'actions'];

  public listaProdutos: ProdutoDTO[] =[
    {idProduto: 1, descricao: 'Coca Cola', dataCadastro: new Date(), valor: 33.66},
    {idProduto: 2, descricao: 'Pizza', dataCadastro: new Date(), valor: 55.78},
    {idProduto: 3, descricao: 'Chocolate', dataCadastro: new Date(), valor: 100.00}
  ]

  constructor() { 
    this.produtoDTO = new ProdutoDTO();
  }

  datepickerEvent(event: MatDatepickerInputEvent<Date>) {
    this.produtoDTO.dataCadastro = event.value;
  }

  ngOnInit(): void {
  }

  salvarProduto(){

  }

  editarProduto(produto: ProdutoDTO){
    this.produtoDTO = produto;
    console.log('editando cadastro ' + produto.idProduto);
  }

  excluirProduto(produto: ProdutoDTO){
    console.log('editando cadastro ' + produto.idProduto);
  }

  fazerLogout(){

  }
}
