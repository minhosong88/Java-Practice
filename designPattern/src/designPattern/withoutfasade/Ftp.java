package designPattern.withoutfasade;

public class Ftp {
    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect() {
        System.out.println("FTP host: "+host+" Port : "+port+"로 연결합니다.");
    }
    public void moveDirectory() {
        System.out.println("Path: "+ path+"로 이동합니다.");
    }

    public void disconnect() {
        System.out.println("FTP 연결을 종료합니다.");

    }
}
