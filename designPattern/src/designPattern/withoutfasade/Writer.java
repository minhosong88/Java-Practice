
package designPattern.withoutfasade;

public class Writer {
    private String filename;

    public Writer(String filename) {
        this.filename = filename;

    }

    public void write() {
        String msg = String.format("Reader %s를 파일쓰기를 합니다.", filename);
        System.out.println(msg);
    }

    public void fileConnect() {
        String msg = String.format("Reader %s를 연결합니다.", filename);
        System.out.println(msg);
    }

    public void fileDisconnect() {
        String msg = String.format("Writer %s를 연결종료합니다.", filename);
        System.out.println(msg);
    }
}

