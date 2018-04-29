package com.spring.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.access.prepost.PreAuthorize;
import com.spring.service.domain.WordLadder;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class Controller {
    protected final Logger log =LoggerFactory.getLogger(this.getClass());
    @RequestMapping
    public String index(){
        return "Hello World!";
    }

    @RequestMapping(value="/wordladder")
    @PreAuthorize("hasRole('USER')")
    public Stack<String> Res(@RequestParam(required=true)String w1,
                      @RequestParam(required=true)String w2){
        log.debug("Generating ladder between "+w1+" and "+w2+"\n");
        WordLadder wl = new WordLadder();
        log.debug(("Finish\n"));
        return wl.findLadder(w1,w2);

    }

}
