import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { ProdutoDTO } from 'src/app/core/model/produto.dto';
import { CadastroProdutoService } from 'src/app/core/services/cadastro-produto.service';
import { NotifierHandlerService } from 'src/app/core/services/notifier-handler.service';

@Component({
  selector: 'app-cadastro-produto',
  templateUrl: './cadastro-produto.component.html',
  styleUrls: ['./cadastro-produto.component.css']
})
export class CadastroProdutoComponent implements OnInit {

  public produtoDTO!: ProdutoDTO | null;
  displayedColumns: string[] = ['idProduto', 'descricao', 'dataCadastro', 'valor', 'actions'];

  public listaProdutos!: ProdutoDTO[];

  constructor(private cadastroProdutoService: CadastroProdutoService,
              private notifierService: NotifierHandlerService) { 
  }

  ngOnInit(): void {
    this.produtoDTO = new ProdutoDTO();
    this.consultarProdutos();
  }

  private consultarProdutos(){
    this.cadastroProdutoService.consultarProdutos()
    .subscribe({
     next: data =>{
       this.listaProdutos = data;   
     }
    });
  }

  salvarProduto(){
    if(this.produtoDTO){
      this.cadastroProdutoService.salvarProduto(this.produtoDTO)
      .subscribe({
        next: data => {
          this.consultarProdutos();
          this.notifierService.notifySucess("Produto salvo com sucesso")
      }})
    }
  }

  editarProduto(produto: ProdutoDTO){
    this.produtoDTO = structuredClone(produto);
  }

  excluirProduto(produto: ProdutoDTO){
    if(this.produtoDTO && produto.idProduto){
      this.cadastroProdutoService.excluirProduto(produto.idProduto)
      .subscribe({
        next: data => {
          this.consultarProdutos();
          this.notifierService.notifySucess("Produto excluído com sucesso");
      }})
    }
  }

  limparTela(){
    this.produtoDTO = new ProdutoDTO();
  }

  datepickerEvent(event: MatDatepickerInputEvent<Date>) {
    this.produtoDTO!.dataFabricacao = event.value;
  }

}
