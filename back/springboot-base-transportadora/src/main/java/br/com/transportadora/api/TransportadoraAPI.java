package br.com.transportadora.api;

import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.transportadora.exception.BadResquestException;
import br.com.transportadora.model.Transportadora;
import br.com.transportadora.service.TransportadoraService;
import br.com.transportadora.util.TipoConsultaEnum;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "v1/")
public class TransportadoraAPI {
	
	@Autowired
	private TransportadoraService service;


	@RequestMapping(method=RequestMethod.POST,value="transportadora", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "POST", value = "Salvar uma Nova Transportadora")
	public ResponseEntity<Transportadora> salvarTransportadora(@RequestBody @Valid Transportadora transportadora) {
		
		Transportadora retorno = service.save(transportadora);
		//eService.saveAll(retorno.getEndereco());
		
		return new ResponseEntity<>(retorno,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="transportadora", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "PUT", value = "Atualizar uma Transportadora")
	public ResponseEntity<Transportadora> atualizarTransportadora(@RequestBody @Valid Transportadora transportadora) {
				
		boolean retorno = service.update(transportadora);
		if(retorno) {
			return new ResponseEntity<>(transportadora,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	//lista todos
	@RequestMapping(method=RequestMethod.GET,value="transportadora", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "GET", value = "Buscar todas as Transportadoras")
	public ResponseEntity<List<Transportadora>> obterTransportadora() {
		List<Transportadora> retorno = service.buscarTodas();
		return new ResponseEntity<>(retorno,HttpStatus.OK);
	}
	
	
	//busca pelo id
	@RequestMapping(method=RequestMethod.GET,value="transportadora/{codigoTransportadora}", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "GET", value = "Buscar Transportadora por codigo")
	public ResponseEntity<Transportadora> obterTransportadora(@PathVariable ("codigoTransportadora") Long codigoTransportadora) {		
		if(codigoTransportadora < 1) {
			throw new BadResquestException("Codigo Invalido");
		}else {
			Transportadora response = service.buscar(codigoTransportadora);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="transportadora/{tipoConsulta}/{entrada}", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "GET", value = "Buscar Transportadoras")
	public ResponseEntity<List<Transportadora>> obterTransportadora(
						@PathVariable ("tipoConsulta") String tipoConsulta,
						@PathVariable ("entrada") String entrada) {
		
		if (tipoConsulta.length() < 3 || entrada.length() < 3) {
			throw new BadResquestException("numero de caracteres não pode ser menor do que 3");
		}else {
			if(tipoConsulta.contentEquals(TipoConsultaEnum.NOME.toString()) ||
			   tipoConsulta.contentEquals(TipoConsultaEnum.TIPOMODAL.toString())) {
				
				List<Transportadora> retorno = null;
				
				if(tipoConsulta.contentEquals(TipoConsultaEnum.NOME.toString())) {
					retorno = service.findTransportadoraByNome(entrada);
				}else {
					retorno = service.findTransportadoraByTipoModal(entrada);
				}
				
				return new ResponseEntity<>(retorno,HttpStatus.OK);
			}else {
				throw new BadResquestException("Tipo Consulta Invalida");
			}
		}		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="transportadora/tipoConsulta", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "GET", value = "Tipos de consulta")
	public ResponseEntity<List<String>> tipoConsultaTransportadora() {
		List<String> tipoConsulta = new ArrayList<>();
		tipoConsulta.add(TipoConsultaEnum.NOME.toString());
		tipoConsulta.add(TipoConsultaEnum.TIPOMODAL.toString());
		return new ResponseEntity<>(tipoConsulta,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="transportadora/{codigoTransportadora}", produces = MediaType.APPLICATION_JSON)
	@ApiOperation(httpMethod = "DELETE", value = "deletar consulta")
	public ResponseEntity<Void> deletarTransportadora(@PathVariable ("codigoTransportadora") Long codigoTransportadora) {
		if(codigoTransportadora < 1) {
			throw new BadResquestException("Codigo Invalido");
		}
		System.out.println(codigoTransportadora);
		Transportadora t = service.buscar(codigoTransportadora);
		service.deleta(t);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
