package com.dh.g.wallet.exception;

public class WalletException extends Exception {

    public WalletException(MessageError messageError) {
        super(messageError.message);
    }
}
