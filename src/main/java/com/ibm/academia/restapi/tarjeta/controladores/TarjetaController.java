package com.ibm.academia.restapi.tarjeta.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.restapi.tarjeta.modelo.entidades.Tarjeta;
import com.ibm.academia.restapi.tarjeta.servicios.TarjetaDAO;


@RestController
@RequestMapping("/restapi")
public class TarjetaController {

	@Autowired
	TarjetaDAO tarjetaDAO;
	
	@GetMapping("/tarjeta/lista")
	public ResponseEntity<?> obtenerTodos(){
		List<Tarjeta> tarjetas = (List<Tarjeta>) tarjetaDAO.buscarTodos();
		return new ResponseEntity<List<Tarjeta>>(tarjetas, HttpStatus.OK);
	}
	
	@GetMapping("/tarjeta/tarjetaId/{tarjetaId}")
	public ResponseEntity<?> obtenerTarjetaPorId(@PathVariable Long tarjetaId){
		Optional<Tarjeta> oTarjeta= tarjetaDAO.buscarPorId(tarjetaId);
			
		return new ResponseEntity<Tarjeta>(oTarjeta.get(), HttpStatus.OK);
	}
	
	@PutMapping("/tarjeta/asociar-pasion")
	public ResponseEntity<?> asignarPasionTarjeta(@RequestParam List<Long> pasionId, @RequestParam(name = "tarjeta_id") Long tarjetaId){
		Tarjeta tarjeta = ((TarjetaDAO)tarjetaDAO).asociarPasionTarjeta(pasionId, tarjetaId);
		return new ResponseEntity<Tarjeta>(tarjeta, HttpStatus.OK);
	}
}
