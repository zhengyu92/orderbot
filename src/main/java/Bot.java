import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.send.SendVoice;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * @author SzeYing
 * @since 2017-05-13
 */
public class Bot extends TelegramLongPollingBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(Bot.class);

    private static RequestHandler handler;

    public Bot() {
        handler = new RequestHandler();
    }

    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasEntities() && update.getMessage().hasText()) {
                    respond(update);
            }
        } catch (TelegramApiException e) {
            LOGGER.error("Could not send message", e);
        }
    }

    public String getBotUsername() {
        return "DinoV2Bot";
    }

    public String getBotToken() {
        return "715028350:AAGEVA8N7MBudMdW6FlapCKSLUhsb7UZIsY";
    }

    // Deciphers commands
    public void respond(Update update) throws TelegramApiException {
        Message message = update.getMessage();

        handler.execute(message);
        String textResponse = handler.getResponse();
        SendVoice voiceResponse = handler.getAudioOrder();
        SendPhoto photoResponse = handler.getPhotoMessage();

        if (textResponse != null) {
            SendMessage result = new SendMessage();
            result.setText(textResponse);
            result.setChatId(message.getChatId());
            result.setParseMode("Markdown");
            sendMessage(result);
        } else if (voiceResponse != null) {
            sendVoice(handler.getAudioOrder());
        } else {
            sendPhoto(handler.getPhotoMessage());
        }
    }
}
