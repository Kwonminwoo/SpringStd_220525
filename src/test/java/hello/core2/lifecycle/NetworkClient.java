package hello.core2.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient /*implements InitializingBean, DisposableBean*/ {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url: " + url);
    }
    public void setUrl(String url){
        this.url = url;
    }
    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }
    public void call(String message){
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

    /**
     *  의존관계 주입이 끝나면 호출, 스프링 초창기에 나온 빈 시작 호출 함수 지금은 잘 사용 x
     */
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    /**
//     *  빈이 종료될 때 호출, 스프링 초창기에 나온 빈 종료 호출 함수 지금은 잘 사용 x
//     */
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }
    @PostConstruct // 빈 생성자 호출(의존관계 주입) 이후
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy // 빈이 종료된 이후
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }

}
