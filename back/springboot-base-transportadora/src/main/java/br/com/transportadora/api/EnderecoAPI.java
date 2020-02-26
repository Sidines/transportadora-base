package br.com.transportadora.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.transportadora.exception.BadResquestException;
import br.com.transportadora.model.Endereco;
import br.com.transportadora.service.EnderecoService;
import br.com.transportadora.util.TipoConsultaEnum;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "v1/")
public class EnderecoAPI {
	
	@Autowired
	private EnderecoService eService;
	
	@RequestMapping(method=RequestMethod.GET,value="endereco/{tipoConsulta}/{entrada}", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "GET", value = "Buscar Endereco")
	public ResponseEntity<List<Endereco>> obterTransportadora(
						@PathVariable ("tipoConsulta") String tipoConsulta,
						@PathVariable ("entrada") String entrada) {
		
		if (tipoConsulta.length() < 2 || entrada.length() < 2) {
			throw new BadResquestException("numero de caracteres não pode ser menor do que 2");
		}else {
			if(tipoConsulta.contentEquals(TipoConsultaEnum.MUNICIPIO.toString()) ||
			   tipoConsulta.contentEquals(TipoConsultaEnum.UF.toString())) {
				
				List<Endereco> retorno = null;
				
				if(tipoConsulta.contentEquals(TipoConsultaEnum.MUNICIPIO.toString())) {
					retorno = eService.findTransportadoraByCidade(entrada);
					
				}else {
					retorno = eService.findTransportadoraByUF(entrada);
				}
				
				return new ResponseEntity<>(retorno,HttpStatus.OK);
			}else {
				throw new BadResquestException("Tipo Consulta Invalida");
			}
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="endereco/tipoConsulta", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "GET", value = "Tipos de consulta")
	public ResponseEntity<List<String>> tipoConsultaTransportadora() {
		List<String> tipoConsulta = new ArrayList<>();
		tipoConsulta.add(TipoConsultaEnum.MUNICIPIO.toString());
		tipoConsulta.add(TipoConsultaEnum.UF.toString());
		return new ResponseEntity<>(tipoConsulta,HttpStatus.OK);
	}
	
}
