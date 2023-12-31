package com.example.easybank_jee.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.easybank_jee.DTO.Agence;

public interface AgenceInterface {
    Optional<Agence> add(Agence agence) ;
    int delete(String code);
    Optional<Agence> searchByCode(String code);
    Optional<Agence> searchByAdress(String adress);
    Optional<Agence> update(Agence agence,String code);
    Optional<Agence> getOne(String code);
}
