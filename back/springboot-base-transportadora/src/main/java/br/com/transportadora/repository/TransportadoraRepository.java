package br.com.transportadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.transportadora.model.Endereco;
import br.com.transportadora.model.Transportadora;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long>{
	
	List<Transportadora> findTransportadoraByNome(String nome);
		
	List<Transportadora> findTransportadoraByModal(String entrada);
}
