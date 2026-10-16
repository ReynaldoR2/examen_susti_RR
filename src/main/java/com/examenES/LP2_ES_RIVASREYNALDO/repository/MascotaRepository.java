package com.examenES.LP2_ES_RIVASREYNALDO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenES.LP2_ES_RIVASREYNALDO.model.mascotaRivasReynaldo;

public interface MascotaRepository extends JpaRepository<mascotaRivasReynaldo, Integer>{
	
	List<mascotaRivasReynaldo> findAllByOrderByIdMascotaDesc();
	List<mascotaRivasReynaldo> findByEspecieOrderByIdMascotaDesc(String especie);
}
