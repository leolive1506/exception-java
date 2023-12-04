package model.exceptions;

import model.enums.AccountExceptionMessages;

public class AccountException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public AccountException(AccountExceptionMessages msg) {
    super(msg.label);
  }
}
