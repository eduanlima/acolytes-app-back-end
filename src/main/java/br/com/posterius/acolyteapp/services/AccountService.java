package br.com.posterius.acolyteapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.posterius.acolyteapp.dto.AccountAcolyteResponseDTO;
import br.com.posterius.acolyteapp.dto.AccountDTO;
import br.com.posterius.acolyteapp.entities.Account;
import br.com.posterius.acolyteapp.repositories.AccountRepository;

@Service 
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional(readOnly = true)
	public List<AccountDTO> findAll() {
		return accountRepository.findAll().stream().map(e -> new AccountDTO(e)).toList();
	}
	
	@Transactional(readOnly = true)
	public AccountDTO findById(UUID id) {
		Optional<Account> optional = accountRepository.findById(id);
		Account entity = optional.get();
		return new AccountDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<AccountAcolyteResponseDTO> findAllAccountAcolyte(UUID id) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return account.getAccountAcolyte().stream().map(a -> new AccountAcolyteResponseDTO(a.getAcolyte().getId(), a.getAcolyte().getPerson().getFirstName())).toList();
	}
}
