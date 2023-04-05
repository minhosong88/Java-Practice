package designPattern.adapter;

public class SocketAdapter implements Electronic110V {


    private Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V){
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect(); //110V 메소드를 사용하면, 220V 메소드를 호출해서 대신 사용하게 됨.
    }
}
