package hello.core2.common;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // 프록시를 만들어 주입되게 함
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();// 유니크한 id가 하나 생성  다른 request와 구분해 주기 위한 것
        // 현실에서는 여러 사용자가 동시에 요청을 하기 때문에 이를 구분해줄 필요가있다.
        System.out.println("[" + uuid + "] reaquest scope bean create:" + this);

    }
    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] reaquest scope bean close:" + this);
    }

}
