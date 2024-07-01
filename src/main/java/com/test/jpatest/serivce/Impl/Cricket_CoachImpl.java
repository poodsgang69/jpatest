package com.test.jpatest.serivce.Impl;

import com.test.jpatest.serivce.Coach;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Cricket_CoachImpl implements Coach {

    @Override
    public String getTrainingSchedule() {
        return "Practice bowling for 30 minutes.";
    }
}
