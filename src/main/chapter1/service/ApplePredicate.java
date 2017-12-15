package main.chapter1.service;

import main.chapter1.entity.Apple;

/**
 * Created by shawn on 17-4-19.
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
