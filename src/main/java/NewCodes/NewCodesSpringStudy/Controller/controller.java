package NewCodes.NewCodesSpringStudy.Controller;

import io.micrometer.observation.transport.Propagator.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {
    @GetMapping("hello")
    public static String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // HTTP GET 요청을 처리함. 웹에서는 저 주소를 가리키면 됨.
    public static String helloMvc(@RequestParam("name") String name,
                                  Model model) { // HTTP GET 요청을 할 떄 꼭 name 파라미터를 입력해야 함.
        model.addAttribute("name", name);
        return "hello-template"; // templates에 있는 해당 html 파일을 웹에 넘겨줌.
    }

    @GetMapping("hello-api")
    @ResponseBody //HTTP 응답의 본문(body)로 데이터를 직접 반. JSON방식.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
