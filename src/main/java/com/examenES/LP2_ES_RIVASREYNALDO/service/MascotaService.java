package com.examenES.LP2_ES_RIVASREYNALDO.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenES.LP2_ES_RIVASREYNALDO.dto.MascotaFilter;
import com.examenES.LP2_ES_RIVASREYNALDO.dto.ResultadoResponse;
import com.examenES.LP2_ES_RIVASREYNALDO.model.mascotaRivasReynaldo;
import com.examenES.LP2_ES_RIVASREYNALDO.repository.DuenoRepository;
import com.examenES.LP2_ES_RIVASREYNALDO.repository.MascotaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MascotaService {
	private final MascotaRepository mascotaRepository;
	
	public List<mascotaRivasReynaldo> getAll() {
		
		return mascotaRepository.findAllByOrderByIdMascotaDesc();
	}
	
	@Transactional
	public ResultadoResponse create(mascotaRivasReynaldo i) {
		try {
			var registrado = mascotaRepository.save(i);
			var mensaje = String.format("Mascota con Nro. %d registrada", registrado.getIdMascota());
			return new ResultadoResponse(true,mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en el registro");
		}
	}
	public List<mascotaRivasReynaldo> getAll(MascotaFilter filter) {
	    if (filter.especie() == null || filter.especie().isBlank()) {
	        return mascotaRepository.findAllByOrderByIdMascotaDesc();
	    }
	    return mascotaRepository.findByEspecieOrderByIdMascotaDesc(filter.especie());
	}
}
