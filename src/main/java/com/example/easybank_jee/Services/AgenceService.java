package com.example.easybank_jee.Services;

import com.example.easybank_jee.DTO.Agence;
import com.example.easybank_jee.Interfaces.AgenceInterface;

import java.util.Optional;

public class AgenceService {
    private AgenceInterface agenceDao;

    public AgenceService(AgenceInterface agenceDao) {
        this.agenceDao = agenceDao;
    }

    public Optional<Agence> add(Agence agence) {
        if (agence != null) {
            return this.agenceDao.add(agence);
        }
        return Optional.empty();
    }

    public int delete(String code) {
        return this.agenceDao.delete(code);
    }

    public Optional<Agence> update(Agence agence, String code) {
        return this.agenceDao.update(agence, code);
    }

    public Optional<Agence> searchByCode(String code) {
        return this.agenceDao.searchByCode(code);
    }

    public Optional<Agence> searchByAdress(String adress) {
        return this.agenceDao.searchByAdress(adress);
    }
}