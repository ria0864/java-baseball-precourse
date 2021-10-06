package baseball.controller;

import baseball.constants.Message;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputConsole;
import baseball.view.OutPutConsole;

public class BaseballGameController {
 private InputConsole inputConsole = new InputConsole();
 private OutPutConsole outPutConsole = new OutPutConsole();
 private Computer computer;
 private Player player;

 public BaseballGameController() {

 }

 public void startGame() {
  computer = new Computer();
  player = new Player();
  computer.generateNumbers();

  while(!player.isCompleteGame()) {
   outPutConsole.printMessage(Message.READ_USER_NUMBER.getMessage());
   player.initPlayer();
   String gameResult = player.play(inputConsole.readUserInput(), computer.getNumbers());
   outPutConsole.printMessage(gameResult);
  }
  askRestartOrEndGame();
 }

 public void askRestartOrEndGame() {
  outPutConsole.printMessage(Message.CLEAR_GAME.getMessage());
  outPutConsole.printMessage(Message.RESTART_OR_END_GAME.getMessage());
  if (inputConsole.readUserInput().equals("1")) {
   startGame();
  }
 }
}
