package com.ibm.academia.restapi.tarjeta.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter 
@Getter
@Entity
@Table(name = "tarjetas", schema = "preferenciast")
public class Tarjeta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "salario_maximo")
	private BigDecimal salarioMaximo;
	
	@Column(name = "salario_minimo", nullable = false)
	private BigDecimal salarioMinimo;
	
	@Column(name = "edad_maxima", nullable = false)
	private Integer edadMaxima;
	
	@Column(name = "edad_minima", nullable = false)
	private Integer edadMinima;
	
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}  )
	@JoinColumn(name = "pasion_id", foreignKey = @ForeignKey(name = "FK_PASION_TARJETA_ID"))
	private Pasion pasion;
	
	public Tarjeta(Long id, String nombre, BigDecimal salarioMaximo, BigDecimal salarioMinimo, Integer edadMaxima,
			Integer edadMinima, String usuarioCreacion, Pasion pasion) {
		this.id = id;
		this.nombre = nombre;
		this.salarioMaximo = salarioMaximo;
		this.salarioMinimo = salarioMinimo;
		this.edadMaxima = edadMaxima;
		this.edadMinima = edadMinima;
		this.usuarioCreacion = usuarioCreacion;
		this.pasion = pasion;
	}	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}
	
	
	@PrePersist
	private void antesPersistir()
	{
		this.fechaCreacion = new Date();
	}
	
	@PreUpdate
	private void antesActualizar()
	{
		this.fechaModificacion = new Date();
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}
	private static final long serialVersionUID = -5711728042674522149L;

}

