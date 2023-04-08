package br.com.pamcary;

import br.com.pamcary.entity.Pessoa;
import br.com.pamcary.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class AvaliacaoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PessoaRepository repository;


	@Test
	public void salvar() throws Exception {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("34536521858");
		pessoa.setNome("Renato Augusto");
		pessoa.setDataNascimento(new Date());

		repository.save(pessoa);

		Pessoa pessoaRep = repository.findByCpf(pessoa.getCpf());

		assertNotNull(pessoaRep);
		assertEquals(pessoa.getCpf(), pessoaRep.getCpf());
		assertEquals(pessoa.getNome(), pessoaRep.getNome());
		assertEquals(pessoa.getDataNascimento(), pessoaRep.getDataNascimento());

	}


	@Test
	public void listar() throws Exception {

		mockMvc.perform(get("/pessoa/listar")
						.contentType("application/json")
						.param("sendWelcomeMail", "true"))
				.andExpect(status().isOk());

	}


	@Test
	public void atualizar() throws Exception {
		Pessoa pessoa = new Pessoa();
		pessoa.setCodigo(-43l);
		pessoa.setCpf("34536521858");
		pessoa.setNome("Renato Augusto Santos");
		pessoa.setDataNascimento(new Date());

		Pessoa pessoaRep = repository.findByCpf(pessoa.getCpf());

		if(pessoaRep != null) {
			BeanUtils.copyProperties(pessoa, pessoaRep);
			repository.save(pessoa);
		}

		pessoaRep = repository.findByCpf(pessoa.getCpf());
		assertNotNull(pessoaRep);
		assertEquals(pessoa.getCpf(), pessoaRep.getCpf());
		assertEquals(pessoa.getNome(), pessoaRep.getNome());
		assertEquals(pessoa.getDataNascimento(), pessoaRep.getDataNascimento());

	}


	@Test
	public void excluirSucesso() throws Exception {

		mockMvc.perform(delete("/pessoa/excluir/1")
						.contentType("application/json"))
				.andExpect(status().isOk());

	}

}
