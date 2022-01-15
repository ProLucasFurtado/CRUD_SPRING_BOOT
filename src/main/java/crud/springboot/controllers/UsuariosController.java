package crud.springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController //Intercepta todas as requisições que fizer mapeamento (Ex: advindo de celular, navegador, postman, basta fazer a requisição da url mapeada)
public class UsuariosController {

	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String usuarioText(@PathVariable String nome) {
		return "Hello " + nome + "!";
	}

}
