package com.application.jpa.websocket;

import com.application.jpa.api.MonksService;
import com.application.jpa.domain.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by jonas on 2017-06-24.
 */
@Controller
public class SocketController {


    @MessageMapping("/greetings")
    @SendTo("topic/greetings")
    private League getTodaysMatches(@PathVariable String message) {
        League league = new League();
        league.setName("Hej");
        return league;
    }

}
