package designPattern;

import designPattern.strategy.*;
import designPattern.withfacade.SftpClient;
import designPattern.withoutfasade.Ftp;
import designPattern.withoutfasade.Reader;
import designPattern.withoutfasade.Writer;


public class Main {
    public static void main(String[] args){

        Encoder encoder = new Encoder();
        EncodingStrategy base64Strategy = new Base64Strategy();
        EncodingStrategy normalStrategy = new NormalStrategy();
        EncodingStrategy appendStrategy = new AppendStrategy();

        String message = "hello, java";

        encoder.setEncodingStrategy(base64Strategy);
        String base64Result = encoder.getMessage(message);

        System.out.println(base64Result);

        encoder.setEncodingStrategy(normalStrategy);
        String normalResult = encoder.getMessage(message);

        System.out.println(normalResult);

        encoder.setEncodingStrategy(appendStrategy);
        String appendResult = encoder.getMessage(message);

        System.out.println(appendResult);
    }
    /*{

        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");

        sftpClient.conenct();

        sftpClient.write();

        sftpClient.read();

        sftpClient.disconnect();
        //각각의 객체에 의존한 메서드 사용하는 것보다 파사드 이용 시 훨씬 코드가 간편해진다.

        //facade 없이 진행한 경우
        *//*Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();


        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.disconnect();
        writer.fileDisconnect();
        ftpClient.disconnect();

    }*/
    /*{
        Button button = new Button("button");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메세지 전달: click 1");
        button.click("메세지 전달: click 2");
        button.click("메세지 전달: click 3");
        button.click("메세지 전달: click 4");
    }*/
    /*{

        ICar audi = new Audi(1000);
        audi.showPrice();

        //a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();

        //a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();

        //a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();


    }*/
/*    {

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{ //Runnable before를 람다식으로 표현
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {//Runnable after를 람다식으로 표현
                    long now = System.currentTimeMillis();
                    System.out.println("after");
                    end.set(now - start.get());
                }

                );

             aopBrowser.show(); //show를 출력하면
            // before.run --> if 문(url 문구 출력) --> Thread.sleep --> after.run 순서로 실행된다.
             System.out.println("loading time: "+end.get());

             aopBrowser.show();
             //두 번째 실행시에는 if문 부분이 없어지므로, 즉시 after.run이 출력되고, cache에서 url을 불러온다.
             System.out.println("loading time: "+end.get());


        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        Browser browser = new Browser("www.naver.com");
        browser.show();

    }*/
    /*{
        //SINGLETON
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = BClazz.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));

        //각 클래스에서 new SocketClient()를 사용해서 객체를 생성하는 equals()가 false로 나오게 된다.

        //ADAPTER
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        VacuumCleaner cleaner = new VacuumCleaner();
        Electronic110V adapter = new SocketAdapter(cleaner); // 110V에 꽂아서 사용하는 소켓어댑터를 하나 사와서 220V가전을 연결함.
        //adapter는 220V 타입의 변수를 110V 인터페이스를 구현한 SocketAdapter를 사용해서 이용하는 것.
        connect(adapter); //일단 110V타입인 adapter를 사용하지만, 실제 구현되는 메서드는 220V의 connect() 메소드임.

        AirConditioner airCon = new AirConditioner();
        Electronic110V airConAdapter = new SocketAdapter(airCon);
        connect(airConAdapter);
        //connect(cleaner); // VacuumCleaner implements 220V, but connect method here uses a 110V type variable.

    }

    //Outlet
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }*/

}