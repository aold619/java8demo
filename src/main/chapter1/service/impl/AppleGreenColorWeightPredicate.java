package main.chapter1.service.impl;

import main.chapter1.entity.Apple;
import main.chapter1.service.ApplePredicate;

/**
 * Created by shawn on 17-4-19.
 */
public class AppleGreenColorWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
