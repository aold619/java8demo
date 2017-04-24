package service.impl;

import entity.Apple;
import service.ApplePredicate;

/**
 * Created by shawn on 17-4-19.
 */
public class AppleGreenColorWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
