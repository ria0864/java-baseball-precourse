package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.constants.ErrorMessage.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

 private Player player;

 @BeforeEach
 void setUp() {
  player = new Player();
 }

 @DisplayName("입력값이 모두 1~9 사이의 숫자인지 확인")
 @ParameterizedTest
 @ValueSource(strings = {"#23","1@3","12&","abc","023"})
 void ValidateRangeInputDataTest(String input) {
  String gameResult = player.play(input, Arrays.asList(1,2,3));
  assertEquals(ONLY_NUMBER_RANGE_OUTOFEXCEPTION.getMessage(), gameResult);
 }

 @DisplayName("숫자 3개 입력받았는지 확인")
 @ParameterizedTest
 @ValueSource(strings = {"1","12","1234"})
 void ValidateSizeInputDataTest(String input) {
  String gameResult = player.play(input, Arrays.asList(1,2,3));
  assertEquals(ONLY_THREE_NUMBER_EXCEPTION.getMessage(), gameResult);
 }

 @DisplayName("중복된 숫자를 입력 받았는지 확인")
 @ParameterizedTest
 @ValueSource(strings = {"112","122","121"})
 void ValidateDuplicationInputDataTest(String input) {
  String gameResult = player.play(input, Arrays.asList(1,2,3));
  assertEquals(DUPLICATION_NUMBER_EXCEPTION.getMessage(), gameResult);
 }

 @DisplayName("3스트라이크")
 @CsvSource(value = {"123,123", "456,456","789,789"})
 @ParameterizedTest
 void threeStrikeTest(String input, String computerNumber) {
  List<Integer> numbers = new ArrayList<>();
  for (String s : computerNumber.split("")) {
   numbers.add(Integer.parseInt(s));
  }
  String result = player.play(input, numbers);
  assertEquals("3스트라이크 ", result);
 }

 @DisplayName("2스트라이크")
 @CsvSource(value = {"123,124", "456,436","789,189"})
 @ParameterizedTest
 void twoStrikeTest(String input, String computerNumber) {
  List<Integer> numbers = new ArrayList<>();
  for (String s : computerNumber.split("")) {
   numbers.add(Integer.parseInt(s));
  }
  String result = player.play(input, numbers);
  assertEquals("2스트라이크 ", result);
 }

 @DisplayName("1스트라이크")
 @CsvSource(value = {"123,145", "456,152","789,129"})
 @ParameterizedTest
 void oneStrikeTest(String input, String computerNumber) {
  List<Integer> numbers = new ArrayList<>();
  for (String s : computerNumber.split("")) {
   numbers.add(Integer.parseInt(s));
  }
  String result = player.play(input, numbers);
  assertEquals("1스트라이크 ", result);
 }

 @DisplayName("1스트라이크 1볼")
 @CsvSource(value = {"123,134", "234,435","345,425"})
 @ParameterizedTest
 void oneStrikeOneBallTest(String input, String computerNumber) {
  List<Integer> numbers = new ArrayList<>();
  for (String s : computerNumber.split("")) {
   numbers.add(Integer.parseInt(s));
  }
  String result = player.play(input, numbers);
  assertEquals("1스트라이크 1볼 ", result);
 }

 @DisplayName("1볼")
 @CsvSource(value = {"123,345", "234,125","345,567"})
 @ParameterizedTest
 void oneBallTest(String input, String computerNumber) {
  List<Integer> numbers = new ArrayList<>();
  for (String s : computerNumber.split("")) {
   numbers.add(Integer.parseInt(s));
  }
  String result = player.play(input, numbers);
  assertEquals("1볼 ", result);
 }

 @DisplayName("2볼")
 @CsvSource(value = {"123,234", "234,123","345,573"})
 @ParameterizedTest
 void twoBallTest(String input, String computerNumber) {
  List<Integer> numbers = new ArrayList<>();
  for (String s : computerNumber.split("")) {
   numbers.add(Integer.parseInt(s));
  }
  String result = player.play(input, numbers);
  assertEquals("2볼 ", result);
 }

 @DisplayName("3볼")
 @CsvSource(value = {"123,312", "234,423","345,534"})
 @ParameterizedTest
 void threeBallTest(String input, String computerNumber) {
  List<Integer> numbers = new ArrayList<>();
  for (String s : computerNumber.split("")) {
   numbers.add(Integer.parseInt(s));
  }
  String result = player.play(input, numbers);
  assertEquals("3볼 ", result);
 }

 @DisplayName("낫싱")
 @CsvSource(value = {"123,456", "234,567","345,678"})
 @ParameterizedTest
 void nothingTest(String input, String computerNumber) {
  List<Integer> numbers = new ArrayList<>();
  for (String s : computerNumber.split("")) {
   numbers.add(Integer.parseInt(s));
  }
  String result = player.play(input, numbers);
  assertEquals("낫싱", result);
 }

}