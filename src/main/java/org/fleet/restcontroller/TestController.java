package org.fleet.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping
    public String correct() {
        return "ALL IS CORRECT!!!";
    }
}
