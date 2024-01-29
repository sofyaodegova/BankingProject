package ru.testTask;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FibonacciCalculation {

    public Integer calculateFibonacciNumberByCurrentDay() {
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i <= LocalDate.now().getDayOfMonth() + 1; i++) {
            if (i <= 1) {
                listOfNumbers.add(i);
            } else {
                int sum = listOfNumbers.get(i - 2) + listOfNumbers.get(i - 1);
                listOfNumbers.add(sum);
            }
        }
        return listOfNumbers.get(listOfNumbers.size() - 1);
    }
}