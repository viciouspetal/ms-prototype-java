package hello.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ProductController {

    @RequestMapping("/")
    public String index() {
        return "Hello hell";
    }

}