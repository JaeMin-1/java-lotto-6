package lotto.model;

import java.util.List;
import lotto.constants.Constants;
import lotto.view.OutputView;

public class Caculation {
    private List<Integer> lucky;
    private int purchaseAmount;

    public Caculation(List<Integer> lucky, int purchaseAmount) {
        this.lucky = lucky;
        this.purchaseAmount = purchaseAmount;
    }

    public void displayStatistics() {
        double sumPrize = calculateSumPrize();
        double beforeRate = sumPrize / purchaseAmount * Constants.PERCENTAGE.getConstants();
        double rate = Math.round(beforeRate * 10.0) / 10.0;
        OutputView.printResult(lucky, rate);
    }

    private double calculateSumPrize() {
        double sumPrize = 0;
        sumPrize += Constants.SAME_3.getConstants() * lucky.get(0);
        sumPrize += Constants.SAME_4.getConstants() * lucky.get(1);
        sumPrize += Constants.SAME_5.getConstants() * lucky.get(2);
        sumPrize += Constants.SAME_5_BONUS.getConstants() * lucky.get(4);
        sumPrize += Constants.SAME_6.getConstants() * lucky.get(3);
        return sumPrize;
    }
}
