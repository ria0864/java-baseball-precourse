package baseball.model;

import java.util.*;
import java.util.regex.Pattern;
import baseball.constants.ErrorMessage;
import static baseball.constants.BaseballConstants.*;

public class Player {
 private final ArrayList<Integer> numbers = new ArrayList<>();
 private int strike;
 private int ball;
 private final Pattern regExp = Pattern.compile("^[1-9]*$");

 public Player() {

 }

 public void initPlayer() {
  numbers.clear();
  strike = 0;
  ball = 0;
 }

 public String play(String userInput, List<Integer> computerNumbers) {
  String validationResult = CheckValidationInputData(userInput);
  if (validationResult != null) {
   return validationResult;
  }

  addNumbers(userInput);

  for (int index = 0; index < NUMBER_SIZE; index++) {
   int number = computerNumbers.get(index);
   countStrike(index, number);
   countBall(index, number);
  }
  return mergeResult();
 }

 private void countStrike(int index, int number) {
  if (numbers.get(index).equals(number)) {
   strike++;
  }
 }

 private void countBall(int index, int number) {
  if (numbers.contains(number)) {
   if (!numbers.get(index).equals(number)) {
    ball++;
   }
  }
 }

 private String mergeResult() {
  StringBuilder stringBuilder = new StringBuilder(100);
  if (strike > 0) {
   stringBuilder.append(strike).append(STRIKE);
  }
  if (ball > 0) {
   stringBuilder.append(ball).append(BALL);
  }
  if (strike == 0 && ball == 0) {
   stringBuilder.append(NOTHING);
  }
  return stringBuilder.toString();
 }

 public boolean isCompleteGame() {
  return strike == NUMBER_SIZE;
 }

 private void addNumbers(String userInput) {
  for (String s : userInput.split("")) {
   numbers.add(Integer.parseInt(s));
  }
 }

 private String CheckValidationInputData(String userInput) {
  if (!checkRangeNumber(userInput)) {
   return ErrorMessage.ONLY_NUMBER_RANGE_OUTOFEXCEPTION.getMessage();
  }
  if (!checkNumberSize(userInput)) {
   return ErrorMessage.ONLY_THREE_NUMBER_EXCEPTION.getMessage();
  }
  if (!checkDuplicateNumber(userInput) ) {
   return ErrorMessage.DUPLICATION_NUMBER_EXCEPTION.getMessage();
  }
  return null;
 }

 private boolean checkRangeNumber(String userInput) {
  return regExp.matcher(userInput).find();
 }

 private boolean checkNumberSize(String userInput) {
  Set<String> set = new HashSet<>(Arrays.asList(userInput.split("")));
  return userInput.length() == set.size();
 }

 private boolean checkDuplicateNumber(String userInput) {
  Set<String> set = new HashSet<>(Arrays.asList(userInput.split("")));
  return set.size() == NUMBER_SIZE;
 }
}
