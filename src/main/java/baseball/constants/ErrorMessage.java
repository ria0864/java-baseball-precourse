package baseball.constants;

public enum ErrorMessage {
 ONLY_THREE_NUMBER_EXCEPTION("[ERROR] 숫자 3개만 입력 할 수 있습니다."),
 ONLY_NUMBER_RANGE_OUTOFEXCEPTION("[ERROR] 1부터 9까지의 숫자만 사용할 수 있습니다."),
 DUPLICATION_NUMBER_EXCEPTION("[ERROR] 중복되지 않은 숫자만 입력 할 수 있습니다.");

 private String message;
 ErrorMessage(String message) {
  this.message = message;
 }

 public String getMessage() {
  return message;
 }
}
