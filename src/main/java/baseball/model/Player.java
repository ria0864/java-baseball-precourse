package baseball.model;

import java.util.*;
import java.util.regex.Pattern;
import baseball.constants.ErrorMessage;
import static baseball.constants.BaseballConstants.*;

public class Player {
 private final Pattern regExp = Pattern.compile("^[1-9]*$");

 public Player() {

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
