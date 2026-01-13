package br.com.posterius.acolyteapp.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.posterius.acolyteapp.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
	
}
