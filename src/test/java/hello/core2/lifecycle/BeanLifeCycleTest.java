package hello.core2.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); // close를 쓰기 위해선 ApplicationContext보다 하위 클래스를 사용해야 한다. close를 하면 빈이 종료됨 destroy
        //
    }

    @Configuration
    static class LifeCycleConfig{
        @Bean/*(initMethod = "init", destroyMethod = "close")*/ // 코드를 고칠 수 없는 외부라이브러리 같은 것에 사용하면 됨
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring");

            return networkClient;
        }
    }
}
