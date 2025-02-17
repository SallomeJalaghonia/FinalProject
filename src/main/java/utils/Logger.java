package utils;


public class Logger {
    private static final Logger logger = new Logger();
    public Logger() {
}
    public static Logger getInstance() {

        return Logger.logger;
    }

    public void log(String s) {
    }
}
