import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 決済定数クラス
 */
@AllArgsConstructor
@Getter
public enum PaymentType {

  /**
   *　決済種別
   */
  paypal(1),
  creditCard(2),
  cash(3);
  private final int type;
}
