package br.com.posterius.acolyteapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.posterius.acolyteapp.entities.Account;
import br.com.posterius.acolyteapp.services.AccountService;

@RestController	
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private AccountService accountService;
	
	@GetMapping
	public List<Account> finall() {
		return accountService.findAll();
	}
}
