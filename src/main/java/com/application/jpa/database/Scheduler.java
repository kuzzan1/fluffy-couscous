package com.application.jpa.database;

import com.application.jpa.api.interfaces.DataInterface;
import com.application.jpa.domain.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
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
    @Autowired
    private CacheManager cacheManager;


    @Scheduled(fixedRate = 10000 )
    public void getTodaysFixtures() {
        String date = LocalDate.now().format( DateTimeFormatter.ofPattern( "yyyy-MM-dd"));
        List<League> fixtures = dataInterface.getMatchesForToday( date );
        updateCache(fixtures, date);
        this.template.convertAndSend("/topic/greetings", fixtures);
    }

    private void updateCache(List<League> fixtures, String date) {
        Cache cacheName = cacheManager.getCache("matchesForDay");
        if(cacheName != null) {
           cacheName.put("com.application.jpa.api.interfaces.DataInterfaceImplgetMatchesForDay"+date, fixtures);
        }
    }

}
