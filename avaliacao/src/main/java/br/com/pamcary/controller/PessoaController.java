package br.com.pamcary.controller;

import br.com.pamcary.entity.Pessoa;
import br.com.pamcary.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping("/gravar")
    public ResponseEntity<?> gravarPessoa(@RequestBody Pessoa pessoa){

        return ResponseEntity.ok(service.gravarPessoa(pessoa));
    }

    @PostMapping("/alterar")
    public ResponseEntity<?> alterarPessoa(@RequestBody Pessoa pessoa){

        return ResponseEntity.ok(service.alterarPessoa(pessoa));
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir (@PathVariable long id) {
        return ResponseEntity.ok(service.excluirPessoa(id));
    }

    @GetMapping("/pesquisar/{cpf}")
    public ResponseEntity<?> pesquisar(@PathVariable String cpf) {
        return ResponseEntity.ok(service.buscarPessoa(cpf));
    }


    @GetMapping("/listar")
    @CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listarPessoa());
    }

}
