package com.examenES.LP2_ES_RIVASREYNALDO.model;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_dueno")
@Getter @Setter
@DynamicInsert
@AllArgsConstructor @NoArgsConstructor
public class dueñoRivasReynaldo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_dueno")
	private Integer idDueno;
	
	@Column(name="ape_dueno")
	private String apeDueno;
	
	@Column(name="nom_dueno")
	private String nomDueno;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="correo")
	private String correo;
}
