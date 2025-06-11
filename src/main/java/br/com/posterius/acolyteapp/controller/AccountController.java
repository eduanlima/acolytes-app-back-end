package br.com.posterius.acolyteapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
