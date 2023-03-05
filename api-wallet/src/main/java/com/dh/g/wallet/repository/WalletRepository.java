package com.dh.g.wallet.repository;

import com.dh.g.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {

    Optional<Wallet> findByDocumentTypeAndDocumentValueAndCurrency_Code(String documentType, String document, String code);

    List<Wallet> findByDocumentTypeAndDocumentValue(String documentType, String document);
}
