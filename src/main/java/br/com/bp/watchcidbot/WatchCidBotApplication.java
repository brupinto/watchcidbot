package br.com.bp.watchcidbot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class WatchCidBotApplication {
	
	@Autowired
	Bot bot;
	
	@PostConstruct
	public void postConstruct() {
		bot.create();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WatchCidBotApplication.class, args);
	}
}
