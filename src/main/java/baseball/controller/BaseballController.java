package baseball.controller;

import baseball.model.Player;
import baseball.service.BaseballService;
import baseball.util.ComputerNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;

    public BaseballController(InputView inputView, OutputView outputView, BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
    }

    public void playEntireGame() {
        outputView.printGameStartMessage();
        boolean isContinue = true;
        while (isContinue) {
            playSingleGame();
            outputView.printGameEndMessage();
            isContinue = shouldGameContinue();
        }
    }

    private void playSingleGame() {
        boolean isContinue = true;
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        List<Integer> computer = computerNumberGenerator.generateComputer();
        while (isContinue) {
            baseballService.scoreInitialize();
            Player player = new Player(inputView.readPlayerNumber());
            baseballService.compareNumber(computer, player.getPlayer());
            outputView.printGameResult(baseballService.getResult());
            isContinue = IsWinningGame();
        }
    }

    private boolean IsWinningGame() {
        if (baseballService.isWin()) {
            return false;
        }
        return true;
    }

    private boolean shouldGameContinue() {
        int gameDecision = inputView.readGameDecision();
        if (baseballService.shouldGameContinue(gameDecision)) {
            return true;
        }
        return false;
    }
}
