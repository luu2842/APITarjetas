package com.ibm.academia.restapi.tarjeta.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.restapi.tarjeta.excepciones.NotFoundException;
import com.ibm.academia.restapi.tarjeta.modelo.entidades.Pasion;
import com.ibm.academia.restapi.tarjeta.modelo.entidades.Tarjeta;
import com.ibm.academia.restapi.tarjeta.repositorios.TarjetaRepository;


@Service
public class TarjetaDAOImpl implements TarjetaDAO{
	
	@Autowired
	TarjetaRepository tarjetaRepository;
	
	@Autowired
	PasionDAO pasionDAO;

	@Override
	public Iterable<Tarjeta> buscarTodos() {
		return tarjetaRepository.findAll();
	}

	@Override
	public Tarjeta guardar(Tarjeta tarjeta) {
		return tarjetaRepository.save(tarjeta);
	}

	@Override
	public Optional<Tarjeta> buscarPorId(Long id) {
		return tarjetaRepository.findById(id);
	}

	@Override
	public void eliminarPorId(Long id) {
		tarjetaRepository.deleteById(id);
	}

	@Override
	public Tarjeta asociarPasionTarjeta(List<Long> pasionesId, Long tarjetaId) {
		   Optional<Tarjeta> oTarjeta = tarjetaRepository.findById(tarjetaId);
           if(!oTarjeta.isPresent())
                   throw new NotFoundException(String.format("La tarjeta con ID %d no existe", tarjetaId));

           Set<Pasion> pasiones = new HashSet<>();
           pasionesId.forEach( pasionId -> {
               Optional<Pasion> oPasion= pasionDAO.buscarPorId(pasionId);
               if(!oPasion.isPresent())
                   throw new NotFoundException(String.format("La carrera con ID %d no existe", pasionId));
               else
                   pasiones.add(oPasion.get());
           });
           
           ((Tarjeta)oTarjeta.get()).setPasiones(pasiones);
           return tarjetaRepository.save(oTarjeta.get());
	}

}
