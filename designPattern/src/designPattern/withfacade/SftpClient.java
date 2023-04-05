package designPattern.withfacade;

import designPattern.withoutfasade.Reader;
import designPattern.withoutfasade.Writer;

public class SftpClient {
    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    public SftpClient(Ftp ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }
    public SftpClient(String host, int port, String path, String filename) {
        this.ftp = new Ftp(host, port, path);
        this.reader = new Reader(filename);
        this.writer = new Writer(filename);
    }//  객체가 없이 변수들의 값만 알아도 생성자 생성 시 필요한 객체들을 생성하게 된다.

    public void conenct() {
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disconnect() {
        reader.disconnect();
        writer.fileDisconnect();
        ftp.disconnect();
    }

    public void read() {
        reader.fileRead();
    }

    public void write() {
        writer.write();
    }
}
