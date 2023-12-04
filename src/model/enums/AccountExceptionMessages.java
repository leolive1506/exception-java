package model.enums;

public enum AccountExceptionMessages {
  EXCEED_WITHDRAW_LIMIT("Withdraw error: The amount exceed withdraw limit"),
  NOT_ENOUGH_BALANCE("Withdraw error: Not enough balance");

  public final String label;

  AccountExceptionMessages(String label) {
    this.label = label;
  }
}
