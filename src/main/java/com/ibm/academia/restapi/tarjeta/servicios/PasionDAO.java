package com.ibm.academia.restapi.tarjeta.servicios;

import java.util.Optional;

import com.ibm.academia.restapi.tarjeta.modelo.entidades.Pasion;

public interface PasionDAO {

	public Iterable<Pasion> buscarTodos ();
	public Pasion guardar (Pasion pasion);
	public Optional<Pasion> buscarPorId(Long id);
	public void eliminarPorId (Long id);
}
