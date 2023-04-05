package designPattern.singleton;

public class SocketClient {

    private static SocketClient socketClient = null; //객체도 static이어야함.

    private SocketClient(){
        //default 생성자를 private으로 막고
    };

    public static  SocketClient getInstance() { //getInstance로 가져올 때, 없으면 새로 만들고 있으면 socketClient를 가져온다.
        if(socketClient ==null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }       //static method로 getInstance 만든다.

    public void connect(){
        System.out.println("connect");
    }


}
