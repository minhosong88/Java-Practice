package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

    Logger logger = Logger.getLogger("mylogger");
    private static MyLogger instanace = new MyLogger();

    public static final String errLog = "log.txt";
    public static final String warningLog = "warning.txt";
    public static final String fineLog = "fine.txt";

    private FileHandler logFile = null;
    private FileHandler fineFile = null;
    private FileHandler warningFile = null;

    private MyLogger() { //생성자를 생성하면,
        try { //logfile, warningfile, finefile이 새로 생성 된다.
            logFile = new FileHandler(errLog, true); //append에 true를 넣으면 이어쓰기. false: 덮어쓰기.
            warningFile = new FileHandler(warningLog, true);
            fineFile = new FileHandler(fineLog, true);

        } catch(SecurityException e){ //예를 들면, 자바에 이미 정의된 이름을 파일명으로 사용하면 발생할 수 있음.
            e.printStackTrace();
        }
        catch (IOException e) { //읽거나 쓸 파일이 없거나 인코딩 안되는 타입으로 쓸 때 발생.
            e.printStackTrace();
        }
        //파일을 생성한 후에
        logFile.setFormatter(new SimpleFormatter()); // 사람이 읽을 수 있는 언어로 log를 써주도록 포맷 설정
        warningFile.setFormatter(new SimpleFormatter());
        fineFile.setFormatter(new SimpleFormatter());

        logger.setLevel(Level.ALL); //각 파일에 어떤 수준의 에러를 입력할 지 설정
        warningFile.setLevel(Level.WARNING);
        fineFile.setLevel(Level.FINE);

        logger.addHandler(logFile); //logger 객체가 모든 log 파일들의 root 로그라고 할 수 있다.
        logger.addHandler(warningFile); // logger 객체에 파생된 log들을 add 한다.
        logger.addHandler(fineFile); //이까지가 생성자를 생성하면 설정되는 값.

    }

    public static MyLogger getLogger() {
        return instanace;  //이 인스턴스는 새로운 생성자를 생성해서 만든 것. //singleton pattern
    }

    public void log(String msg) {
        logger.finest(msg);
        logger.finer(msg);
        logger.fine(msg);
        logger.config(msg);
        logger.info(msg);
        logger.warning(msg);
        logger.severe(msg);
    }

    public void fine(String msg) {
        logger.fine(msg);
    }

    public void warning(String msg) {
        logger.warning(msg);
    }

}
