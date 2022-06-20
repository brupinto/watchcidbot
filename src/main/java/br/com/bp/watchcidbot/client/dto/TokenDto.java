package br.com.bp.watchcidbot.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDto {
	private String access_token;
	private String token_type;
	private String refresh_token;
}
