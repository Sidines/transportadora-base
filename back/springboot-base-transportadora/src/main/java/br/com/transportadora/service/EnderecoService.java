package br.com.transportadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.transportadora.crud.ipml.EnderecoServiceInterface;
import br.com.transportadora.model.Endereco;
import br.com.transportadora.repository.EnderecoRepository;

@Service
public class EnderecoService implements EnderecoServiceInterface {
	
	@Autowired
	private EnderecoRepository dao;

	@Override
	public Endereco save(Endereco entrada) {
		// TODO Auto-generated method stub
		return dao.save(entrada);
	}

	@Override
	public boolean update(Endereco entrada) {
		// TODO Auto-generated method stub
		return  dao.save(entrada) != null;
	}

	@Override
	public boolean deleta(Endereco entrada) {
		// TODO Auto-generated method stub
		try {
			dao.delete(entrada);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Endereco> buscarTodas() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Endereco buscar(Long id) {
		// TODO Auto-generated method stub
		return  dao.getOne(id);
	}

	@Override
	public List<Endereco> saveAll(List<Endereco> entrada) {
		// TODO Auto-generated method stub
		return dao.saveAll(entrada);
	}

	@Override
	public List<Endereco> findTransportadoraByCidade(String cidade) {
		// TODO Auto-generated method stub
		return dao.findEnderecoByCidade(cidade);
	}
	
	@Override
	public List<Endereco> findTransportadoraByUF(String uf) {
		// TODO Auto-generated method stub
		return dao.findEnderecoByUf(uf);
	}

}
