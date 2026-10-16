package com.examenES.LP2_ES_RIVASREYNALDO.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenES.LP2_ES_RIVASREYNALDO.model.dueñoRivasReynaldo;
import com.examenES.LP2_ES_RIVASREYNALDO.repository.DuenoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DuenoService {
	private final DuenoRepository duenoRepository;
	
	public List<dueñoRivasReynaldo> getAll() {
		return duenoRepository.findAll();
	}
}
