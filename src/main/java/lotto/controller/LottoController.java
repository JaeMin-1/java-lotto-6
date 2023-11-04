package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.Constants;
import lotto.model.Caculation;
import lotto.model.LottoModel;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void start() {
        int purchaseAmount = InputView.getUserPurchaseAmount();
        int lottoTicketCount = purchaseAmount / Constants.LOTTO_PRICE.getConstants();
        OutputView.printLottoTicketCount(lottoTicketCount);

        List<List<Integer>> lottoTickets = generateLottoTickets(lottoTicketCount);
        System.out.println();
        List<Integer> lottoNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(lottoNumbers);

        LottoModel model = new LottoModel(lottoTickets, lottoNumbers, bonusNumber);
        model.lottoPlaying();

        System.out.println();
        Caculation caculation = new Caculation(model.getLucky(), purchaseAmount);
        caculation.displayStatistics();
    }

    private static List<List<Integer>> generateLottoTickets(int ticketCount) {
        List<List<Integer>> allLotto = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> oneLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                    Constants.MIN_NUMBER.getConstants(),
                    Constants.MAX_NUMBER.getConstants(),
                    Constants.NUMBER_COUNT.getConstants()));
            Collections.sort(oneLotto);
            OutputView.printLottoTickets(oneLotto);
            allLotto.add(oneLotto);
        }
        return allLotto;
    }
}

