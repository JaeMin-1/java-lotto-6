package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constants.InputMessage;
import lotto.model.Bonus;
import lotto.model.InputValidation;
import lotto.model.Lotto;
import lotto.model.Purchase;

public class InputView {
    public static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println(InputMessage.PURCHASE_AMOUNT.getMessage());
                String input = Console.readLine();
                int purchaseAmount = InputValidation.validatePurchaseAmount(input);
                Purchase purchase = new Purchase(purchaseAmount);
                return purchase.getPurchase();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println();
        while (true) {
            try {
                System.out.println(InputMessage.LOTTO_NUMBERS.getMessage());
                String[] numbers = Console.readLine().split(",");
                List<Integer> lottoNumbers = InputValidation.validateWinningNumbers(numbers);
                Lotto lotto = new Lotto(lottoNumbers);
                return lotto.getLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println();
        while (true) {
            try {
                System.out.println(InputMessage.BONUS_NUMBER.getMessage());
                String input = Console.readLine();
                int bonusNumber = InputValidation.validateBonusNumber(input);
                Bonus bonus = new Bonus(bonusNumber, winningNumbers);
                return bonus.getBonus();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
