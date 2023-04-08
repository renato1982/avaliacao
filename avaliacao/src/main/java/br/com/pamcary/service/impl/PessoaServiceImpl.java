package br.com.pamcary.service.impl;


import br.com.pamcary.entity.Pessoa;
import br.com.pamcary.repository.PessoaRepository;
import br.com.pamcary.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repository;
    @Override
    public String gravarPessoa(Pessoa pessoa) {
        Pessoa pessoaRep = repository.findByCpf(pessoa.getCpf());
        if(pessoaRep != null){
            return "CPF já existe na base";
        }
        repository.save(pessoa);
        return "Pessoa inserida com successo!";
    }

    @Override
    public String alterarPessoa(Pessoa pessoa) {
        Pessoa pessoaRep = this.buscarPessoaId(pessoa);
       if(pessoaRep != null) {
           BeanUtils.copyProperties(pessoa, pessoaRep);
           repository.save(pessoa);
           return "Pessoa atualizada com sucesso!";
       }
        return "Erro ao atualizar pessoa";
    }

    @Override
    public List<Pessoa> listarPessoa() {
        List<Pessoa> listPessoas = new ArrayList<Pessoa>();
        repository.findAll().forEach(listPessoas::add);
        return listPessoas;
    }

    @Override
    public String excluirPessoa(Long id) {
        repository.deleteById(id);
        return "Pessoa excluida com sucesso";
    }

    @Override
    public Pessoa buscarPessoa(String cpf) {
        return repository.findByCpf(cpf);
    }


    public Pessoa buscarPessoaId(Pessoa pessoa){
        Optional<Pessoa> p = repository.findById(pessoa.getCodigo());
        if (p.isPresent()){
            return p.get();
        }
        return null;
    }
}
