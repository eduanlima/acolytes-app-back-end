package br.com.posterius.acolyteapp.controller.acolyte;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<List<AcolyteDTO>> findAll() {
		var acolytes = acolyteService.findAll();
		return ResponseEntity.ok(acolytes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AcolyteDTO> findById(@PathVariable UUID id) {
		AcolyteDTO acolyteDTO = acolyteService.findById(id);
		return ResponseEntity.ok(acolyteDTO);
	}
	
	@PostMapping
	public ResponseEntity<AcolyteDTO> saveAcolyte(@RequestBody AcolyteDTO acolyteDto){
		acolyteDto = acolyteService.create(acolyteDto);
		return ResponseEntity.ok(acolyteDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AcolyteDTO> update(@PathVariable UUID id,@RequestBody AcolyteDTO acolyteDto) {
		acolyteDto = acolyteService.update(id, acolyteDto);
		return ResponseEntity.ok(acolyteDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		acolyteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
