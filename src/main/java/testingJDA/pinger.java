package testingJDA;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

public class pinger {
    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault("token")
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        jda.addEventListener(new ListenerAdapter() {
            @Override
            public void onMessageReceived(@NotNull MessageReceivedEvent event) {
                if (event.getMessage().getAuthor().isBot()) return;
                if (event.getMessage().getContentRaw().toLowerCase().contains("azy")) {
                    event.getChannel().sendMessage("<@217643297559019520> WAKE UP").queue();
                }

            }
        });
    }
}

