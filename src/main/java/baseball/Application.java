package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BaseballService baseballService = new BaseballService();
        BaseballController baseballController = new BaseballController(inputView, outputView, baseballService);
        baseballController.playEntireGame();
    }
}
