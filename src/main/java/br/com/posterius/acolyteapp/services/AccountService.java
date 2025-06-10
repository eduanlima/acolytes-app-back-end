package br.com.posterius.acolyteapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.posterius.acolyteapp.entities.Account;
import br.com.posterius.acolyteapp.repositories.AccountRepository;

@Service 
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(readOnly = true)
	public List<Account> findAll() {
		return accountRepository.findAll();
	}
}
