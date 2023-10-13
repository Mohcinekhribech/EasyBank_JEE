package com.example.easybank_jee.Services;


import com.example.easybank_jee.DTO.Client;
import com.example.easybank_jee.Interfaces.ClientInterface;
import com.example.easybank_jee.Interfaces.EmployeInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ClientService {
    private ClientInterface clientDao;

    public ClientService(ClientInterface clientDao) {
        this.clientDao = clientDao;
    }

    public Optional<Client> add(Client client) {
        if (client != null) {
            return this.clientDao.add(Optional.of(client));
        }
        return Optional.empty();
    }

    public int delete(String code) {
        return this.clientDao.delete(code);
    }

    public Optional<Client> update(Client client, String code) {
        return this.clientDao.update(client, code);
    }

    public Optional<Client> searchByCode(String code) {
        return this.clientDao.searchByCode(code);
    }
    public List<Client> getAll()
    {
        return this.clientDao.showClients();
    }
    public List<Client> searchByAttribute(String attribute)
    {
        return this.clientDao.Search(attribute);
    }
}