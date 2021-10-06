package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

 private Computer computer;

 @BeforeEach
 void setUp() {
  computer = new Computer();
 }

 @DisplayName("랜덤으로 숫자 3개 생성되었는지 확인")
 @Test
 void generateNumberLengthTest() {
  computer.generateNumbers();
  assertThat(computer.getNumbers().size()).isEqualTo(3);
 }

 @DisplayName("컴퓨터에서 생성한 숫자가 중복 없는 값인지 확인")
 @Test
 void generateNumberValidationTest() {
  computer.generateNumbers();
  Set<Integer> set = new HashSet<>(computer.getNumbers());
  assertThat(set.size()).isEqualTo(3);
 }
}