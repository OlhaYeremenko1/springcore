package ua.epam.spring.hometask.yeremenko.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import ua.epam.spring.hometask.yeremenko.domain.User;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Olha_Yeremenko on 4/25/2016.
 */
@Aspect
public class DiscountAspect {

    @Pointcut("execution(private double getDiscount(..))")
    private void allDiscountCalls() {}


    @AfterReturning(pointcut = "allDiscountCalls()", returning = "discount")
    private void countAllDiscountCalls(Double discount) {
        if (!totalDiscountCounter.containsKey(discount))
            totalDiscountCounter.put(discount, 0);
        totalDiscountCounter.put(discount, totalDiscountCounter.get(discount) + 1);
    }

    @AfterReturning(pointcut = "execution(public double getDiscount(...) {) && args(user,..)", returning = "discount")
    private void discountForEveryUserCalls(User user, Double discount) {
        String userName = user.getFirstName();
        if (!userDiscountCounter.containsKey(discount)) {
            userDiscountCounter.put(discount, new HashMap<String, Integer>());
            userDiscountCounter.get(discount).put(userName, 0);
        }
        if (!userDiscountCounter.get(discount).containsKey(userName)) {
            userDiscountCounter.get(discount).put(userName, 0);
        }
        userDiscountCounter.get(discount).put(userName, userDiscountCounter.get(discount).get(userName) + 1);
    }

    private Map<Double, Integer> totalDiscountCounter;

    private Map<Double, Map<String , Integer>> userDiscountCounter;

    public Map<Double, Integer> getTotalDiscountCounter() {
        return totalDiscountCounter;
    }

    public Map<Double, Map<String, Integer>> getUserDiscountCounter() {
        return userDiscountCounter;
    }


}