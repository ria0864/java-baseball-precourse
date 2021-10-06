package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringClassTest {

 @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되어야한다.")
 @Test
 void splitStringTest() {
  String inputString = "1,2";

  assertThat(inputString.split(",")).contains("1", "2");
 }

 @DisplayName("1을 ,로 spilit 했을 때 1만을 포함하는 배열이 반환되어야한다.")
 @Test
 void splitStringReturnValueTest() {
  String inputString = "1";

  assertThat(inputString.split(",")).containsExactly("1");
 }

 @DisplayName("'(1,2)' 주어졌을 때 () 제거 후 '1,2'가 반환되어야한다.")
 @Test
 void substringTest() {
  String inputString = "(1,2)";

  assertThat(inputString.substring(1, inputString.length() - 1)).isEqualTo("1,2");
 }

 @DisplayName("abc 값이 주어졌을 때 특정 위치의 문자를 가져와야한다.")
 @ParameterizedTest
 @CsvSource({"0,a","1,b","2,c"})
 void charAtTest(int index, char expected) {
  String inputString = "abc";

  assertThat(inputString.charAt(index)).isEqualTo(expected);
 }

 @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
 @ParameterizedTest
 @ValueSource(ints = {3})
 @CsvSource({"3,d","0,a"})
 void charAtExceptionHandlingTest(int index, char expected) {
  String inputString = "abc";

  assertThatThrownBy(() -> inputString.charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
 }

 @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
 @ParameterizedTest
 @ValueSource(ints = {3})
 void charAtExceptionHandling2Test(int index) {
  String inputString = "abc";
  ThrowableAssert.ThrowingCallable throwingCallable = () -> inputString.charAt(index);

  assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
    .isThrownBy(throwingCallable)
    .withMessageMatching("String index out of range: 3");
 }
}
