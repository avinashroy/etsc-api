package com.codegrind.etsc;

import com.codegrind.model.EmpInfo;
import com.codegrind.repository.EmpInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String sayHello() {

        return "Hello World!";
    }
}
