package designPattern.proxy.aop;

import designPattern.proxy.Html;
import designPattern.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html html;
    private Runnable before; // AOP를 만드는 데 before/after/after retunring/ throwing/ around 같은 것들이 쓰인다.
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
         this.url = url;
         this.before = before;
         this.after = after;
    }


    @Override
    public Html show() {
        before.run();
        if (html == null) {
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from: " + url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        after.run();
        System.out.println("AopBrowser using cache html: " + url);

        return html;
    }
}
