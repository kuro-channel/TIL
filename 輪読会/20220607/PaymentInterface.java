/**
 * 決済サービス用インターフェース
 */
public interface PaymentInterface {

  // 支払処理メソッド
  public int payment(PaymentModel model);
}
