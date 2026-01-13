package br.com.posterius.acolyteapp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.posterius.acolyteapp.dto.AccountAcolyteResponseDTO;
import br.com.posterius.acolyteapp.dto.AccountDTO;
import br.com.posterius.acolyteapp.services.AccountService;

@RestController	
@RequestMapping(value = "/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping
	public List<AccountDTO> finAll() {
		return accountService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> findById(@PathVariable UUID id) {
		AccountDTO dto = accountService.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/{idAccount}/acolytes")
	public ResponseEntity<List<AccountAcolyteResponseDTO>> findAllAccountAcolyte(@PathVariable UUID idAccount){
		var acolytes = accountService.findAllAccountAcolyte(idAccount);
		return ResponseEntity.ok(acolytes);
	}
}
