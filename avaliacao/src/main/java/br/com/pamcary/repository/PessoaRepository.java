package br.com.pamcary.repository;


import br.com.pamcary.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    public Pessoa findByCpf(String cpf);
}
