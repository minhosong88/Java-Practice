package logging;

public class LoggerTest {
    public static void main(String[] args) {
        MyLogger mylogger = MyLogger.getLogger();
        mylogger.log("test");
        mylogger.fine("fine test");
        mylogger.warning("warning test");

    }
}
