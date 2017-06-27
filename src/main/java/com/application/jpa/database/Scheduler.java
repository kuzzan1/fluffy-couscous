package com.application.jpa.database;

import com.application.jpa.api.interfaces.DataInterface;
import com.application.jpa.domain.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by jonas on 2017-06-24.
 */
@Component
public class Scheduler {

    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private DataInterface dataInterface;

//    @Scheduled(fixedRate = 10000 )
    public void getTodaysFixtures() {
        System.out.println("running");
        String date = LocalDate.now().format( DateTimeFormatter.ofPattern( "yyyy-MM-dd"));
        List<League> fixtures = dataInterface.getMatchesForDay( date );
        this.template.convertAndSend("/topic/greetings", fixtures);
    }

}
