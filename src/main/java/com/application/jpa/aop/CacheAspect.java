package com.application.jpa.aop;

import com.application.jpa.cache.CacheService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jonas on 2017-06-26.
 */
@Aspect
@Component
public class CacheAspect {

    @Autowired
    private CacheService cacheService;

    @Before( "execution(* com.application.jpa.api.interfaces.DataInterface.*(..))" )
    public void test( JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
    }

}
