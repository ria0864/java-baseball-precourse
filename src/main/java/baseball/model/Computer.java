package baseball.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constants.BaseballConstants.*;

public class Computer {

 private final List<Integer> numbers = new ArrayList<>();

 public Computer() {
 }

 public void initComputer() {
  numbers.clear();
  generateNumbers();
 }

 public void generateNumbers() {
  while(numbers.size() < NUMBER_SIZE) {
   addNumber(Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX));
  }
 }

 private void addNumber(int pickNumberInRange) {
  if (!isContainsNumber(pickNumberInRange)) {
   numbers.add(pickNumberInRange);
  }
 }

 private boolean isContainsNumber(int pickNumberInRange) {
  return numbers.contains(pickNumberInRange);
 }

 public List<Integer> getNumbers() {
  return numbers;
 }
}
