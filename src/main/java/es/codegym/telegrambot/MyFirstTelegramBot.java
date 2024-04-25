package es.codegym.telegrambot;

import java.util.Map;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

// import es.codegym.telegrambot.TelegramBotContent;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    String step1Text = TelegramBotContent.STEP_1_TEXT;
    String step2Text = TelegramBotContent.STEP_2_TEXT;
    String step3Text = TelegramBotContent.STEP_3_TEXT;
    String step4Text = TelegramBotContent.STEP_4_TEXT;
    String step5Text = TelegramBotContent.STEP_5_TEXT;
    String step6Text = TelegramBotContent.STEP_6_TEXT;
    String step7Text = TelegramBotContent.STEP_7_TEXT;
    String step8Text = TelegramBotContent.STEP_8_TEXT;
    String finalText = TelegramBotContent.FINAL_TEXT;

    public static final String NAME = "UniqueExperticiaBot";
    public static final String TOKEN = "7088744134:AAFkARazOMvcnfZjjao4twWYkcJ9EqACevo";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendTextMessageAsync(step1Text, Map.of("Hackear la nevera", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(step2Text, Map.of(
                    "¡Tomar una salchicha! +20 de fama", "step_2_btn",
                    "¡Tomar un pescado! +20 de fama", "step_2_btn",
                    "¡Tirar una lata de pepinillos! +20 de fama", "step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(step3Text, Map.of(
                    "Hackear al robot aspirador", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(step4Text, Map.of(

                    "Enviar al robot aspirador a por comida! +30 de fama", "step_4_btn",
                    "Dar un paseo en el robot aspirador! +30 de fama", "step_4_btn",
                    "¡Huir del robot aspirador! +30 de fama", "step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(step5Text, Map.of(
                    "Encender y ponerse la GoPro!", "step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            setUserGlory(40);
            sendTextMessageAsync(step6Text, Map.of(
                    "¡Correr por los tejados, grabar con la GoPro! +40 de fama", "step_6_btn",
                    "¡Atacar a otros gatos desde tu escondite con la GoPro! +40 de fama", "step_6_btn",
                    "¡Atacar a los perros desde tu escondite con la GoPro! +40 de fama", "step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            setUserGlory(40);
            sendTextMessageAsync(step7Text, Map.of(
                    "Hackear la contraseña de la computadora", "step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            setUserGlory(50);
            sendTextMessageAsync(step8Text, Map.of(
                    "¡Has superado la prueba! Salir al patio", "step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            sendTextMessageAsync(finalText);
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}