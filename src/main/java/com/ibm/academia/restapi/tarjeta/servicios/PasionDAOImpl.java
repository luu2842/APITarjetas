package com.ibm.academia.restapi.tarjeta.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.restapi.tarjeta.modelo.entidades.Pasion;
import com.ibm.academia.restapi.tarjeta.repositorios.PasionRepository;

@Service
public class PasionDAOImpl implements PasionDAO{
	
	@Autowired
	PasionRepository pasionRepository;

	@Override
	public Iterable<Pasion> buscarTodos() {
		return pasionRepository.findAll();
	}

	@Override
	public Pasion guardar(Pasion pasion) {
		return pasionRepository.save(pasion);
	}

	@Override
	public Optional<Pasion> buscarPorId(Long id) {
		return pasionRepository.findById(id);
	}

	@Override
	public void eliminarPorId(Long id) {
		pasionRepository.deleteById(id);
	}
	

}
