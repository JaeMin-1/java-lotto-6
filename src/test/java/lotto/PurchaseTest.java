package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest {
    @DisplayName("보너스 번호가 1~45 사이가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseByNotDivisible() {
        assertThatThrownBy(() -> new Purchase(14500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
