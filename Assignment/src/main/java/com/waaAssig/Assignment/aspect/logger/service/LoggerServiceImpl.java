package com.waaAssig.Assignment.aspect.logger.service;

import com.waaAssig.Assignment.aspect.logger.domain.Logger;
import com.waaAssig.Assignment.aspect.logger.repo.LoggerRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService{

    @Autowired
    LoggerRepo loggerRepo;

    @Override
    public void add(ProceedingJoinPoint pjp) {
        loggerRepo.save(  // replace with builders
                new Logger(
                        LocalDate.now(),
                        LocalTime.now(),
                        "bogus principle",
                        pjp.getSignature().getName()));
    }

    @Override
    public List<Logger> findAll() {
        return loggerRepo.findAll();
    }

}
