package com.ibm.academia.restapi.tarjeta.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tarjetas", schema = "preferenciast")
public class Tarjeta implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Positive(message = "El valor debe de ser mayor a 0")
	@Column(name = "salario_maximo")
	private BigDecimal salarioMaximo;
	
	@Positive(message = "El valor debe de ser mayor a 0")
	@Column(name = "salario_minimo", nullable = false)
	private BigDecimal salarioMinimo;
	
	@Positive(message = "El valor debe de ser mayor a 0")	
	@Max(value= 75, message = "No puede ser mayor a 75")
	@Column(name = "edad_maxima", nullable = false)
	private Integer edadMaxima;
	
	@Positive(message = "El valor debe de ser mayor a 0")
	@Min(value= 18, message = "No puede ser menor a 18")
	@Column(name = "edad_minima", nullable = false)
	private Integer edadMinima;
	
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name= "tarjeta_pasion", schema = "preferenciast",
			joinColumns = @JoinColumn (name = "tarjeta_id"), 
			inverseJoinColumns = @JoinColumn (name = "pasion_id")
			)
	@JsonIgnoreProperties({"tarjetas"})
	private Set<Pasion> pasiones;
	
	public Tarjeta(Long id, String nombre, BigDecimal salarioMaximo, BigDecimal salarioMinimo, Integer edadMaxima,
			Integer edadMinima, String usuarioCreacion) {
		this.id = id;
		this.nombre = nombre;
		this.salarioMaximo = salarioMaximo;
		this.salarioMinimo = salarioMinimo;
		this.edadMaxima = edadMaxima;
		this.edadMinima = edadMinima;
		this.usuarioCreacion = usuarioCreacion;
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

