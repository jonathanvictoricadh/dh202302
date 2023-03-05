package com.dh.g.wallet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageError {
    WALLET_NOT_FOUND("Wallet not found"),
    CUSTOMER_NOT_FOUND("Customer not found"), WALLET_EXISTS("Wallet exists");

    String message;
}
