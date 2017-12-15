package main.chapter1.service.impl;

import main.chapter1.entity.Apple;
import main.chapter1.service.ApplePredicate;

/**
 * Created by shawn on 17-4-19.
 */
public class AppleRedColorWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor());
    }
}
