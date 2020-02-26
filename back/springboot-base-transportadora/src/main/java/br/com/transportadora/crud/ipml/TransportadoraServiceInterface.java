package br.com.transportadora.crud.ipml;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.transportadora.model.Endereco;
import br.com.transportadora.model.Transportadora;

public interface TransportadoraServiceInterface {
	
	Transportadora save(Transportadora entrada);
	
	boolean update(Transportadora transportadora);
	
	boolean deleta(Transportadora transportadora);
	
	List<Transportadora> buscarTodas();
	
	Transportadora buscar(Long id);
	
	List<Transportadora> findTransportadoraByNome(String nome);
			
	List<Transportadora> findTransportadoraByTipoModal(String tipoModal);
	
}
