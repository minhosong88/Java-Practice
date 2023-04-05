package designPattern.singleton;

public class BClazz {

    private static SocketClient socketClient;

    public BClazz (){
        this.socketClient = SocketClient.getInstance();
        // this.socketClient= new SocketClient();
    }

    public static SocketClient getSocketClient() {
        return socketClient;
    }
}
