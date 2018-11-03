package io.fdlessard.codebites.magiceightball.basic.controllers;

import io.fdlessard.codebites.magiceightball.basic.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.basic.services.MagicEightBallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/MagicEightBall")
@Slf4j
public class MagicEightBallController {

    @Autowired
    private MagicEightBallService magicEightBallService;

    @GetMapping(value = "/isAlive", produces = "application/json")
    public String isAlive() {
        log.debug("MagicEightBallController.isAlive()");
        return "MagicEightBallController is alive(";
    }

    @GetMapping(value = "/shake", produces = "application/json")
    @ResponseBody
    public MagicEightBallAnswer shake() {
        log.debug("MagicEightBallController.shake()");
        return magicEightBallService.shake();
    }

    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody
    public List<MagicEightBallAnswer> getAll() {
        log.debug("MagicEightBallController.getAll()");
        return magicEightBallService.getAll();
    }
}
