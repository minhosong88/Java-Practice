package designPattern.singleton;

public class AClazz {

    private static SocketClient socketClient;

    public AClazz(){
        this.socketClient = SocketClient.getInstance();
        // this.socketClient= new SocketClient();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }

}
