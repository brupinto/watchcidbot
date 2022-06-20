package br.com.bp.watchcidbot.client.form;

import lombok.Data;

@Data
public class TokenRefreshForm {
	private String grant_type;
    private String refresh_token;
}
