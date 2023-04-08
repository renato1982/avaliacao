import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, tap } from 'rxjs';

import { IPessoa } from './../model/i-pessoa';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  private API = "http://localhost:8080/pessoa";
  constructor(private httpClient : HttpClient) {
  }

  pesquisar() {
    return this.httpClient.get(this.API + '/listar');
  }
  recuperar(cpf : number) {
    return this.httpClient.get(this.API + '/pesquisar/' + cpf);
  }
  excluir(id: number) {
    return this.httpClient.delete(this.API + '/excluir' + id);
  }
  atualizar(pessoa: IPessoa) {
    return this.httpClient.post(this.API + '/alterar', pessoa);
  }
  listarTodos() {
    return this.httpClient.get<IPessoa[]>(this.API + '/listar')
    .pipe(
        first(),
        tap(pessoa => console.log(pessoa))
    );
  }
  salvar(pessoa : IPessoa) {
    return this.httpClient.post(this.API + '/gravar', pessoa);
  }
}
