/**
 * 決済クラス
 */
public class PaymentService {

  private String id; // id
  private String pass; // パスワード
  private long amount; // 金額

  public PaymentService(String id, String pass, long amount) {
    this.id = id;
    this.pass = pass;
    this.amount = amount;
  }

  // Paymal
  private final int PAYPAL = 1;

  // カード決済
  private final int CREDIT = 2;

  // 現金
  private final int PAYPAY = 3;

  /**
   * 決済処理サービス
   * どれかの決済処理を直した → 全部の決済方法で再テストしなくちゃいけない・・・
   * 
   * @param paymentType 決済タイプ（1.Paymal, 2.カード決済, 3.Paypay）
   * 
   * @return 処理結果 -1: 失敗, 0: 成功
   */
  public int payment(int paymentType) {
    switch (paymentType) {
      case PAYPAL:
        // Paypalに問い合わせて決済
        // 独自処理あるよ～
        break;

      case CREDIT:
        // クレカ会社に問い合わせて決済
        // 独自処理あるよ～
        break;

      case PAYPAY:
        // ペイペイに問い合わせて決済
        // 独自処理あるよ～
        break;
      default:
        break;
    }
    return 1;
  }
}
