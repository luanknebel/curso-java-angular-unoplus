import { Injectable } from '@angular/core';
import { RestClientService } from '../rest-client/rest-client.service';
import { ProdutoDTO } from '../model/produto.dto';

@Injectable({
  providedIn: 'root'
})
export class CadastroProdutoService {

  constructor(private restClientService: RestClientService) { }

  consultarProdutos(){
    return this.restClientService.get<ProdutoDTO[]>('produto');
  }

  salvarProduto(produtoDTO: ProdutoDTO){
    if(produtoDTO.idProduto){
      return this.atualizarProduto(produtoDTO);
    }else{
      return this.incluirProduto(produtoDTO);
    }
  }

  excluirProduto(idProduto: number){
    return this.restClientService.delete(`produto/${idProduto}`);
  }
  
  private incluirProduto(produtoDTO: ProdutoDTO){
    return this.restClientService.post<ProdutoDTO>('produto',produtoDTO);
  }

  private atualizarProduto(produtoDTO: ProdutoDTO){
    return this.restClientService.put<ProdutoDTO>('produto',produtoDTO);
  }

}
