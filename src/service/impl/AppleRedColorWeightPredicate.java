package service.impl;

import entity.Apple;
import service.ApplePredicate;

/**
 * Created by shawn on 17-4-19.
 */
public class AppleRedColorWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor());
    }
}
