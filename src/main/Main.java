package main;

import main.entity.Apple;
import main.service.ApplePredicate;
import main.service.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Apple> apples = generateApples();
        List<Apple> result = filterApples(apples, (Apple apple) -> "red".equals(apple.getColor()));
//        ApplePredicate predicate = new AppleGreenColorWeightPredicate();
//        List<Apple> redApples = filterApples(apples, predicate);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> generateApples() {
        List<Apple> result = new ArrayList<>();
        Apple apple = null;
        String[] colors = {"red", "green"};
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            apple = new Apple(i,
                    colors[random.nextInt(colors.length)],
                    random.nextDouble() * (200 - 100) + 100);
            result.add(apple);
        }

        return result;
    }
}
