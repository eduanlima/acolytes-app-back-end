package br.com.posterius.acolyteapp.controller.acolyte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.posterius.acolyteapp.services.AcolyteService;

@RestController
@RequestMapping(value = "/acolyte")
public class AcolyteController {
	@Autowired
	private AcolyteService acolyteService;
	
	@GetMapping
	public ResponseEntity<List<AcolyteResponseDTO>> findAll() {
		var acolytes = acolyteService.findAll();
		return ResponseEntity.ok(acolytes);
	}
}
