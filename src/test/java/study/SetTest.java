package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
 private Set<Integer> numbers;

 @BeforeEach
 void setUp() {
  numbers = new HashSet<>();
  numbers.add(1);
  numbers.add(1);
  numbers.add(2);
  numbers.add(3);
 }

 @DisplayName("Set의 크기 확인하는 테스트")
 @Test
 void sizeTest() {
  assertThat(numbers.size()).isEqualTo(3);
 }

 @DisplayName("1,2,3 값이 존재하는지 확인하는 테스트")
 @ParameterizedTest
 @ValueSource(ints = {1,2,3})
 void containsTest(int value) {
  assertThat(numbers.contains(value)).isTrue();
 }

 @DisplayName("Set에 존재하는지 확인하는 입력값과 그에 따른 결과값을 parameter로 받아서 테스트")
 @ParameterizedTest
 @CsvSource({"1,true","2,true","3,true","4,false","5,false"})
 void contains2Test(int value, boolean expected) {
  assertThat(numbers.contains(value)).isEqualTo(expected);
 }

}
