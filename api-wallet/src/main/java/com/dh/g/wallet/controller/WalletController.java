package com.dh.g.wallet.controller;

import com.dh.g.wallet.dto.WalletDTO;
import com.dh.g.wallet.exception.WalletException;
import com.dh.g.wallet.model.Wallet;
import com.dh.g.wallet.services.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {


    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/find-document-currency/{documentType}/{document}/{code}")
    public Wallet findByDocumentAndCurrency(@PathVariable String documentType,
                                            @PathVariable String document,
                                            @PathVariable String code) throws Exception {
        return walletService.findByDocumentAndCurrency(documentType, document, code);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody Wallet wallet) throws WalletException {
        walletService.create(wallet);
    }

    @GetMapping("/find-document/{documentType}/{document}")
    public List<Wallet> findByDocument(@PathVariable String documentType,
                                       @PathVariable String document) {
        return walletService.findByDocument(documentType, document);
    }


    @PutMapping("/update-balance")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateBalance(@RequestBody WalletDTO walletDTO) throws Exception {
        walletService.updateBalance(walletDTO);
    }
}
