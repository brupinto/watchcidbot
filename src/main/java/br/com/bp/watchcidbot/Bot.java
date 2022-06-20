package br.com.bp.watchcidbot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

@Service
public class Bot extends ListenerAdapter{
	
	@Value("${botid}")
	private String botID;
	
	public void create() {
		try {
			JDABuilder builder = JDABuilder.createLight(botID, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES);
		    builder.setActivity(Activity.playing("I am looking your pods"));
		    builder.addEventListeners(this);
		    builder.build();	
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
    	Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();
/*        
        if (!event.getGuild().getName().equalsIgnoreCase("whelps")) {
	        if (!channel.getName().equalsIgnoreCase("🍪𝐌𝐈𝐍𝐈𝐍𝐆🍪") && !channel.getName().equalsIgnoreCase("👿𝐊𝐈𝐋𝐋𝐁𝐎𝐀𝐑𝐃😈"))
	        	return;
	        List<Role> roles = event.getMember().getRoles();
	        Boolean hasRole = false;
	        
	        for (Role r : roles) {
	        	if (r.getName().equalsIgnoreCase("diretor")) {
	        		hasRole = true;
	        	}
	        }
	        
        	if(!hasRole) {
	        	return;
	        }
        }
*/        
        if (msg.getContentRaw().equals("!help")) {
        	channel.sendMessage("**[WATCHCIDBOT] command List!**\n"
        					+ "!wcb-register\n").queue();
        }
        else if (msg.getContentRaw().equals("!wcb-register")) {
        	channel.sendMessage("We need grant permission first. Use the ESI link to do that .: https://tinyurl.com/2p86mt5x").queue();
        }
        
    }
}
