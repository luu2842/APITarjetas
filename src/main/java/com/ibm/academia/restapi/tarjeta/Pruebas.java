package com.ibm.academia.restapi.tarjeta;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibm.academia.restapi.tarjeta.modelo.entidades.Pasion;
import com.ibm.academia.restapi.tarjeta.servicios.PasionDAO;

@Component
public class Pruebas implements CommandLineRunner{

	@Autowired
	PasionDAO pasionDAO;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		Pasion pasion1 = new Pasion(null, "Shopping", new BigDecimal("1000000.00"), new BigDecimal("7000.00"), 75, 18, "eneri");
		Pasion registroPasion1 = pasionDAO.guardar(pasion1);
		System.out.println(registroPasion1.toString());
		
		Pasion pasion2 = new Pasion(null, "Travels", new BigDecimal("1000000.00"), new BigDecimal("12000.00"), 75, 18, "eneri");
		Pasion registroPasion2 = pasionDAO.guardar(pasion2);
		System.out.println(registroPasion2.toString());
		
		Pasion pasion3 = new Pasion(null, "Help", new BigDecimal("1000000.00"), new BigDecimal("12000.00"), 75, 18, "eneri");
		Pasion registroPasion3 = pasionDAO.guardar(pasion3);
		System.out.println(registroPasion3.toString());
		
		Pasion pasion4 = new Pasion(null, "My business", new BigDecimal("1000000.00"), new BigDecimal("7000.00"), 75, 18, "eneri");
		Pasion registroPasion4 = pasionDAO.guardar(pasion4);
		System.out.println(registroPasion4.toString());
		
		Pasion pasion5 = new Pasion(null, "Sports", new BigDecimal("1000000.00"), new BigDecimal("7000.00"), 75, 18, "eneri");
		Pasion registroPasion5 = pasionDAO.guardar(pasion5);
		System.out.println(registroPasion5.toString());
		
		Pasion pasion6 = new Pasion(null, "My style", new BigDecimal("1000000.00"), new BigDecimal("7000.00"), 75, 18, "eneri");
		Pasion registroPasion6 = pasionDAO.guardar(pasion6);
		System.out.println(registroPasion6.toString());*/
		
	}

}
