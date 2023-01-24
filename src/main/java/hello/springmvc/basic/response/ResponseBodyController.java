package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
//@RestController
public class ResponseBodyController {

    /**
     * HttpEntity, ResponseEntity(Http Status 추가)
     * @return
     */
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public List<HelloData> responseBodyJsonV2() {
        List<HelloData> list = new ArrayList<>();
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        list.add(helloData);
        HelloData helloData2 = new HelloData();
        helloData2.setUsername("userB");
        helloData2.setAge(30);
        list.add(helloData2);
        HelloData helloData3 = new HelloData();
        helloData3.setUsername("userC");
        helloData3.setAge(40);
        list.add(helloData3);
        for (HelloData data : list) {
            log.info("data={}", data);
        }
        return list;
    }

}
