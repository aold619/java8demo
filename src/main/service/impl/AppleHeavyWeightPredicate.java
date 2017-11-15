package main.service.impl;

import main.entity.Apple;
import main.service.ApplePredicate;

/**
 * Created by shawn on 17-4-19.
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
