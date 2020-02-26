package br.com.transportadora.crud.ipml;

import java.util.List;

import br.com.transportadora.model.Endereco;

public interface EnderecoServiceInterface {
    
	Endereco save(Endereco entrada);
	
	List<Endereco> saveAll(List<Endereco> entrada);
	
	boolean update(Endereco entrada);
	
	boolean deleta(Endereco entrada);
	
	List<Endereco> buscarTodas();
	
	Endereco buscar(Long id);
	
	List<Endereco> findTransportadoraByCidade(String cidade);
	
	List<Endereco> findTransportadoraByUF(String uf);
}
