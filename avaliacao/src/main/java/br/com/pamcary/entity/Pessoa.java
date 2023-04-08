package br.com.pamcary.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PESSO_FISICA")
public class Pessoa {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_pessoa_fisica"
    )
    @SequenceGenerator(
            name = "sequence_pessoa_fisica"
    )
    @Column(name="CODIGO")
    private Long codigo;

    @Column(name="CPF")
    private String cpf;


    @Column(name="NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
