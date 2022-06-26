package hello.core2.web;


import hello.core2.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    // private final ObjectProvider<MyLogger> myLoggerProvider; proxiMode를 지정해서 빈에 등록될 때 가짜 객체가 등록되게 하여 오류를 방지했음.
    private final MyLogger myLogger;
    @RequestMapping("log-demo") // log-demo라는 요청이 오면 매핑해줌
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
        //MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL); // 실제 이용될 때 진짜 빈을 요청하여 이용

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
