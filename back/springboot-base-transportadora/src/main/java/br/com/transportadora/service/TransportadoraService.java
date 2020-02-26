package br.com.transportadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.transportadora.crud.ipml.TransportadoraServiceInterface;
import br.com.transportadora.model.Endereco;
import br.com.transportadora.model.Transportadora;
import br.com.transportadora.repository.TransportadoraRepository;

@Service
public class TransportadoraService implements TransportadoraServiceInterface {
	
	@Autowired
	TransportadoraRepository dao;

	@Override
	public Transportadora save(Transportadora entrada) {
		// TODO Auto-generated method stub
		return dao.save(entrada);
	}

	@Override
	public boolean update(Transportadora transportadora) {
		// TODO Auto-generated method stub
		
		return dao.save(transportadora) != null;
	}

	@Override
	public boolean deleta(Transportadora transportadora) {
		// TODO Auto-generated method stub
		try {
			dao.delete(transportadora);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Transportadora> buscarTodas() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Transportadora buscar(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Transportadora> findTransportadoraByNome(String nome) {
		// TODO Auto-generated method stub
		return dao.findTransportadoraByNome(nome);
	}

	@Override
	public List<Transportadora> findTransportadoraByTipoModal(String tipoModal) {
		// TODO Auto-generated method stub
		return dao.findTransportadoraByModal(tipoModal);
	}

}
