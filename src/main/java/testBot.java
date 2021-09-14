import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class testBot extends TelegramLongPollingBot {

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update)
    {
        if(update.hasMessage()){
            Message message = update.getMessage();
            if (message.hasText()){
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("You sent: " + "\n\n" + message.getText())
                        .build());
            }
        }
    }

    @Override
    public String getBotUsername()
    {
        return "@Ryiz test BOT"; // получаем имя бота
    }



    @Override
    public String getBotToken() { return "1964724587:AAGw6rarFoiAq0rjrMhp6crNLIEnUXjdquk"; } //получаем токен
    

    @SneakyThrows
    public static void main(String[] args)
    {
        testBot bot = new testBot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot); //регистрируем бота
    }


}
