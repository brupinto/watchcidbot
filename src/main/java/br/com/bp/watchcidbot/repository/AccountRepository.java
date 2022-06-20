package br.com.bp.watchcidbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bp.watchcidbot.model.Account;


public interface AccountRepository  extends JpaRepository<Account, Long> {
	
	@Query("select d from Account d")
	public List<Account> getDirector();
	
}
