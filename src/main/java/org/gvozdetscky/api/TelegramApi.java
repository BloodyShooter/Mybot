package org.gvozdetscky.api;

import org.gvozdetscky.util.InetIP;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class TelegramApi extends TelegramLongPollingBot {

    private String botUsername = "MyIpTestBot";

    private String botToken = "657140986:AAF1vXWfCuyi0qXIhGEHdkfCM9u8mu4t7Bw";

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();

        if (message.equals("ip")) {
            String ip = InetIP.getInetIP();

            sendMsg(update.getMessage().getChatId().toString(), ip);
        }

        System.out.println();
    }

    public synchronized void sendMsg(String chatId, String msg) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(msg);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void setBotUsername(String botUsername) {
        this.botUsername = botUsername;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }
}
