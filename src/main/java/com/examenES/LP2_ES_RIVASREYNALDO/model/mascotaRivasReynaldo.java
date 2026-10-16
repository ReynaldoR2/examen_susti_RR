package com.examenES.LP2_ES_RIVASREYNALDO.model;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_mascota")
@Getter @Setter
@DynamicInsert
@AllArgsConstructor @NoArgsConstructor
public class mascotaRivasReynaldo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_mascota")
	private Integer idMascota;
	
	@Column(name="nom_mascota")
	private String nomMascota;
	
	@Column(name="especie")
	private String especie;
	
	@Column(name="raza")
	private String raza;
	
	@Column(name="fecha_nac")
	private LocalDate fechaNac;
	
	@ManyToOne
	@JoinColumn(name="id_dueno")
	private dueñoRivasReynaldo dueno;
}
