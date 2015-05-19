package no.vestein.raspberry.game.logging;

/**
 * Created by Vestein Dahl on 18.05.2015.
 */
public interface ILogger {

    public void log(Level level, String message, Exception exception);

}
