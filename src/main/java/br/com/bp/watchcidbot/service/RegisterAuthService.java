package br.com.bp.watchcidbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.bp.watchcidbot.client.AuthClient;
import br.com.bp.watchcidbot.client.CharacterClient;
import br.com.bp.watchcidbot.client.dto.CharacterDto;
import br.com.bp.watchcidbot.client.dto.TokenDto;
import br.com.bp.watchcidbot.client.dto.VerifyDto;
import br.com.bp.watchcidbot.client.form.TokenForm;
import br.com.bp.watchcidbot.client.form.TokenRefreshForm;
import br.com.bp.watchcidbot.model.Account;
import br.com.bp.watchcidbot.repository.AccountRepository;

@Service
public class RegisterAuthService {
	
	@Autowired
	AuthClient authClient;
	@Autowired
	CharacterClient charClient;
	@Autowired
	AccountRepository accountRepo;
	
	@Value("${api-eveonline-token}")
	private String basicToken;
	
	public void register(String code) {
		TokenForm tokenForm = new TokenForm();
		tokenForm.setCode(code);
		tokenForm.setGrant_type("authorization_code");
		TokenDto tokenDto = authClient.token(tokenForm, basicToken);
		VerifyDto verifyDto = authClient.verify("Bearer "+tokenDto.getAccess_token());
		CharacterDto characterDto = charClient.characters(verifyDto.getCharacterID()); 
		
		Account diretor = new Account();
		diretor.setCharacterId(verifyDto.getCharacterID());
		diretor.setCharacterName(characterDto.getName());
		diretor.setRefreshToken(tokenDto.getRefresh_token());
		diretor.setCorporateId(characterDto.getCorporation_id());

		accountRepo.deleteAll();
		accountRepo.save(diretor);
	}
	
	public String refreshToken() {
		Account diretor = accountRepo.getDirector().get(0);
		TokenRefreshForm tokenRefreshForm = new TokenRefreshForm();
		tokenRefreshForm.setGrant_type("refresh_token");
		tokenRefreshForm.setRefresh_token(diretor.getRefreshToken());
		TokenDto tokenDto = authClient.tokenRefresh(tokenRefreshForm, basicToken);
		return "Bearer "+tokenDto.getAccess_token();
	}
}
