package crud.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import crud.springboot.models.Usuarios;
import crud.springboot.repository.UsuarioRepository;

@RestController //Intercepta todas as requisições que fizer mapeamento (Ex: advindo de celular, navegador, postman, basta fazer a requisição da url mapeada)
public class UsuariosController {

	@Autowired // IC/CD ou CDI - Injeção de Dependência
	private UsuarioRepository usuarioRepository;
	
	//Primeiro mapeamento de um endpoint chamado rest api com contexto "mostranome"
	@RequestMapping(value = "/mostranome/{nome}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String usuarioText(@PathVariable String nome) {
		return "CRUD Spring Boot completo " + nome + "!";
	}
	
	
	@RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String metodoOlaMundo(@PathVariable String nome) {
		
		Usuarios usuario = new Usuarios();
		usuario.setNome(nome);

		usuarioRepository.save(usuario); //Grava no banco de dados
	
		return "Olá Mundo " + nome;
	}
	
	@GetMapping(value = "listatodos")//(Método de API - CONSULTAR TODOS OS USUÁRIOS)
	@ResponseBody //Retorna os dados para o corpo da resposta
	public ResponseEntity<List<Usuarios>> listaUsuarios() {
		
		List<Usuarios> usuarios = usuarioRepository.findAll(); //Executa a consulta no banco de dados
		
		return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK); //Retorna a lista em JSON
	}
	
	
	@PostMapping(value = "salvar")
	@ResponseBody //Descrição da resposta
	public ResponseEntity<Usuarios> salvar(@RequestBody Usuarios usuario) {
		
		Usuarios user = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuarios>(user, HttpStatus.CREATED);
	}

}
