package br.com.posterius.acolyteapp.controller.acolyte;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<AcolyteResponseDTO> saveAcolyte(@RequestBody AcolyteRequestDTO acolyteDto){
		AcolyteResponseDTO acolyteResponseDTO = acolyteService.createAcolyte(acolyteDto);
		return ResponseEntity.ok(acolyteResponseDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AcolyteResponseDTO> update(@PathVariable UUID id,@RequestBody AcolyteRequestDTO acolyteDto) {
		AcolyteResponseDTO acolyteResponseDTO = acolyteService.updateAcolyte(id, acolyteDto);
		return ResponseEntity.ok(acolyteResponseDTO);
	}
}
