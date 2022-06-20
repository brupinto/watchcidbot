package br.com.bp.watchcidbot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private Long characterId;
	@Column
	private String characterName;
	@Column
	private Long corporateId;
	@Column
	private String refreshToken;
	
}
