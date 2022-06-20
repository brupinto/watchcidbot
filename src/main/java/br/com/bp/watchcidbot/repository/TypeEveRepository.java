package br.com.bp.watchcidbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bp.watchcidbot.model.TypeEve;

public interface TypeEveRepository  extends JpaRepository<TypeEve, Long> {
	
}
