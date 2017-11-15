package main.service;

import main.entity.Apple;

/**
 * Created by shawn on 17-4-19.
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
