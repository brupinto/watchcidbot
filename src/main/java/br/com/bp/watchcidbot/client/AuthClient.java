package br.com.bp.watchcidbot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.bp.watchcidbot.client.dto.TokenDto;
import br.com.bp.watchcidbot.client.dto.VerifyDto;
import br.com.bp.watchcidbot.client.form.TokenForm;
import br.com.bp.watchcidbot.client.form.TokenRefreshForm;

@FeignClient(url="${api-eveonline-auth}", name = "autenticacao")
public interface AuthClient {
	
	@GetMapping(value = "oauth/verify", produces = MediaType.APPLICATION_JSON_VALUE)
	public VerifyDto verify(@RequestHeader("Authorization") String authorizationToken);
	
	@PostMapping("oauth/token")
	public TokenDto token(@RequestBody TokenForm tokenForm, @RequestHeader("Authorization") String authorizationToken);
	
	@PostMapping("oauth/token")
	public TokenDto tokenRefresh(@RequestBody TokenRefreshForm tokenRefreshForm, @RequestHeader("Authorization") String authorizationToken);
}
