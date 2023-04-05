package designPattern.withoutfasade;

public class Reader {
    private String filename;

    public Reader(String filename) {
        this.filename = filename;
    }

    public void fileConnect() {
        String msg = String.format("Reader %s를 연결합니다.", filename);
        System.out.println(msg);

    }

    public void fileRead() {
        String msg = String.format("Reader %s의 내용을 읽어옵니다.", filename);
        System.out.println(msg);
    }

    public void disconnect() {
        String msg = String.format("Reader %s를 연결 종료합니다..", filename);
        System.out.println(msg);
    }
}
