package br.com.bp.watchcidbot.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CharacterDto {
	private Long alliance_id;
	private String birthday;
	private String name;
	private Long corporation_id;
}
