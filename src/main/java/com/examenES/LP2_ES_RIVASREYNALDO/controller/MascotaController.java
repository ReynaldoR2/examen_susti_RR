package com.examenES.LP2_ES_RIVASREYNALDO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenES.LP2_ES_RIVASREYNALDO.dto.MascotaFilter;
import com.examenES.LP2_ES_RIVASREYNALDO.model.dueñoRivasReynaldo;
import com.examenES.LP2_ES_RIVASREYNALDO.model.mascotaRivasReynaldo;
import com.examenES.LP2_ES_RIVASREYNALDO.service.DuenoService;
import com.examenES.LP2_ES_RIVASREYNALDO.service.MascotaService;
import com.examenES.LP2_ES_RIVASREYNALDO.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("mascota")
@RequiredArgsConstructor
public class MascotaController {
	
	private final MascotaService mascotaService;
	private final DuenoService duenoService;
	
	@GetMapping("/")
    public String inicio() {
        return "redirect:/mascota/listado";
    }
	@GetMapping("listado")
	public String listado(Model model, MascotaFilter filter ) {
		model.addAttribute("lstMascota", mascotaService.getAll(filter));
	    model.addAttribute("filter", filter);
	    return "mascota/listado";
	}
	@GetMapping("nuevo")
    public String nuevo(Model model) {
        mascotaRivasReynaldo mascota = new mascotaRivasReynaldo();
        mascota.setDueno(new dueñoRivasReynaldo());   
        model.addAttribute("lstDueno", duenoService.getAll());
        model.addAttribute("mascota", mascota);
        return "mascota/nuevo";
    }
	
	@PostMapping("guardar")
    public String guardar(@ModelAttribute("mascota") mascotaRivasReynaldo m,
                          RedirectAttributes flash) {

        var response = mascotaService.create(m);
        var alert = Alert.sweetToast(response.mensaje(), "success", 5000);

        flash.addFlashAttribute("alert", alert);
        return "redirect:/mascota/listado";
    }
}
