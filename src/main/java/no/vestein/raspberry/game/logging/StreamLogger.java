package no.vestein.raspberry.game.logging;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Vestein Dahl on 18.05.2015.
 */
public class StreamLogger implements ILogger {

    private OutputStream stream;
    private String formatString = "%s: %s (%s)";

    public StreamLogger(OutputStream stream) {
        this.stream = stream;
    }

    @Override
    public void log(Level level, String message, Exception exception) {
        String logMessage = String.format(formatString, level, message, exception);
        try {
            stream.write(logMessage.getBytes());
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
