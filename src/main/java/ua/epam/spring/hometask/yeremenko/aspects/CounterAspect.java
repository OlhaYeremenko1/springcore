package ua.epam.spring.hometask.yeremenko.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Olha_Yeremenko on 4/26/2016.
 */
@Aspect
@Component
public class CounterAspect {


    private Map<String, Integer> counterName;

    private Map<Integer, Integer> counterPrice;

    @Pointcut("execution(public String getEventName(..))")
    private void eventGetName() {
    }

    @Pointcut("execution(public int getTicketBasePrice(..))")
    private void eventGetPrice() {
    }

    @AfterReturning(pointcut = "eventGetName()", returning = "eventName")
    public void getNamesCount(String eventName) {
        if (!counterName.containsKey(eventName))
            counterName.put(eventName, 0);
        counterName.put(eventName, counterName.get(eventName) + 1);
    }

    @AfterReturning(pointcut = "eventGetPrice()", returning = "ticketPrice")
    public void getPriceCount(Integer ticketPrice) {
        if (!counterPrice.containsKey(ticketPrice))
            counterPrice.put(ticketPrice, 0);
        counterPrice.put(ticketPrice, counterPrice.get(ticketPrice) + 1);
    }

    public Map<String, Integer> getNameCounter() {
        return counterName;
    }

    public Map<Integer, Integer> getCounterPrice() {
        return counterPrice;
    }
}
