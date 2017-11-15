package main.service.impl;

import main.entity.Apple;
import main.service.ApplePredicate;

/**
 * Created by shawn on 17-4-19.
 */
public class AppleGreenColorWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
