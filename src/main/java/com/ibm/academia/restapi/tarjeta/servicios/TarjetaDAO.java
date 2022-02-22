package com.ibm.academia.restapi.tarjeta.servicios;

import java.util.List;
import java.util.Optional;

import com.ibm.academia.restapi.tarjeta.modelo.entidades.Tarjeta;


public interface TarjetaDAO {
	public Iterable<Tarjeta> buscarTodos ();
	public Tarjeta guardar (Tarjeta tarjeta );
	public Optional<Tarjeta> buscarPorId(Long id);
	public void eliminarPorId (Long id);
	
	public Tarjeta asociarPasionTarjeta(List<Long> pasionesId , Long tarjetaId);

}
