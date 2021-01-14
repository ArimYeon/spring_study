package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // GetMapping의 get은 get,post할 때 get임
    // http://localhost:8080/hello 일 때 매칭
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
       // "hello"를 뷰 리졸버 라고 한다.
        // resources/templates/뷰 리졸버.html를 찾아가서 렌더링 시 (Thymeleaf 템플릿 엔진 처리)
        return "hello";
    }

    @GetMapping("hello-mvc")
    // @RequestParam에 required 속성이 있음 default가 true고 false로 주면 파라미터 값을 입력하지 않아도
    public String helloMvc(@RequestParam(value = "name",required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    // http의 응답 body부에 return 값을 직접 넣어주겠다는 의미
    // html 코드 없이 data 그대로 내려줌
    // ResponseBody가 없으면 위에 처럼 viewResolver가 동작해서 맞는 template을 찾게 함.
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        // HttpMessageConverter가 동작함.
        // String이면 StringConverter, 객체면 JsonConverter 동작
        // 객체면 {"키":"값"} 이런 형태로 출력됨. json 형태
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
