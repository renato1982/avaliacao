package br.com.pamcary.service;

import br.com.pamcary.entity.Pessoa;

import java.util.List;

public interface PessoaService {

    public String gravarPessoa(Pessoa pessoa);
    public String alterarPessoa(Pessoa pessoa);
    public List<Pessoa> listarPessoa();
    public String excluirPessoa(Long id);
    public Pessoa buscarPessoa(String cpf);


}
