package baseball.constants;

public enum Message {
 READ_USER_NUMBER("숫자를 입력해주세요 : "),
 CLEAR_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
 RESTART_OR_END_GAME("게임을 새로 시작하려면 1을 입력하세요. 1을 제외한 문자 입력 시, 게임은 종료됩니다."),
 EXIT_GAME("게임을 완전히 종료합니다.");

 private String message;

 Message(String message) {
  this.message = message;
 }

 public String getMessage() {
  return message;
 }
}
