package com.example.easybank_jee.Mapping;

import com.example.easybank_jee.DTO.Client;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;

public class ClientMap {
    private Client client;
    public ClientMap(Client client)
    {
        this.client = client;
    }

    public Client mapping(HttpServletRequest request)
    {
        this.client.setAdress(request.getParameter("adress"));
        this.client.setCode(request.getParameter("code"));
        this.client.setFirstName(request.getParameter("firstName"));
        this.client.setLastName(request.getParameter("lastName"));
        this.client.setPhoneNumber(request.getParameter("phoneNumber"));
        String date = request.getParameter("dateOfBirth");
        if(date!="")
          this.client.setDateOfBirth(LocalDate.parse(date));
        return this.client;
    }
}
