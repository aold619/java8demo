package service.impl;

import entity.Apple;
import service.ApplePredicate;

/**
 * Created by shawn on 17-4-19.
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
