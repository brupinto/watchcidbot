package br.com.bp.watchcidbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bp.watchcidbot.model.Parametro;

public interface ParametroRepository  extends JpaRepository<Parametro, Long> {
	
}
