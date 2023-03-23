package com.intelligent.rest;

import com.intelligent.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    final DemoService demoService;

}
