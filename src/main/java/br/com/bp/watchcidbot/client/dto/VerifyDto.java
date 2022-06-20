package br.com.bp.watchcidbot.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VerifyDto {
	private Long CharacterID;
	private String CharacterName;
    private String ExpiresOn;
    private String Scopes;
    private String TokenType;
    private String CharacterOwnerHash;
    private String IntellectualProperty;
}
