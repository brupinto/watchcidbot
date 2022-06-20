package br.com.bp.watchcidbot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.bp.watchcidbot.client.dto.CharacterDto;
import br.com.bp.watchcidbot.client.dto.PortraitDto;

@FeignClient(url="${api-eveonline}characters/", name = "character")
public interface CharacterClient {
	
	@GetMapping(value = "{character_id}/")
	public CharacterDto characters(@PathVariable Long character_id);
	
	@GetMapping(value = "{character_id}/portrait/")
	public PortraitDto portrait(@PathVariable Long character_id);
}
