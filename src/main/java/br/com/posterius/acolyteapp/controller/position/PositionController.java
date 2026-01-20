package br.com.posterius.acolyteapp.controller.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.posterius.acolyteapp.services.PositionService;

@RestController
@RequestMapping("/position")
public class PositionController {
	@Autowired
	private PositionService positionService;
	
	@GetMapping
	public ResponseEntity<List<PositionDTO>> findAll(){
		List<PositionDTO> positions = positionService.findAll();
		return ResponseEntity.ok(positions);
	}
}
