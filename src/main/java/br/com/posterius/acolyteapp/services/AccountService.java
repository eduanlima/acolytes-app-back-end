package br.com.posterius.acolyteapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.posterius.acolyteapp.dto.AccountDTO;
import br.com.posterius.acolyteapp.repositories.AccountRepository;

@Service 
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(readOnly = true)
	public List<AccountDTO> findAll() {
		return accountRepository.findAll().stream().map(e -> new AccountDTO(e)).toList();
	}
}
