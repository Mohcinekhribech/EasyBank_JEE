package com.example.easybank_jee.Interfaces;


import com.example.easybank_jee.DTO.SavingAccount;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SavingAccountInterface {
    Optional<SavingAccount> add(Optional<SavingAccount> account);
    Optional<SavingAccount> update(Optional<SavingAccount> account,String code);
    List<SavingAccount> searchByClient(String clientCode);
}