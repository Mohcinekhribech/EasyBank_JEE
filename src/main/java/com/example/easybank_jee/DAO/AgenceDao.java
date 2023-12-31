package com.example.easybank_jee.DAO;

import java.util.List;
import java.util.Optional;

import com.example.easybank_jee.DTO.Agence;
import com.example.easybank_jee.Helpers.Database;
import com.example.easybank_jee.Interfaces.AgenceInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AgenceDao implements AgenceInterface {
    private Connection Connection = Database.ConnectToDb();

    @Override
    public Optional<Agence> add(Agence agence) {
        try {
            PreparedStatement statement = this.Connection
                    .prepareStatement("insert into agence (code,name,address,phonenumber) values (?,?,?,?)");
            statement.setString(1, agence.getCode());
            statement.setString(2, agence.getName());
            statement.setString(3, agence.getAdress());
            statement.setString(4, agence.getPhoneNumber());
            if (statement.execute())
                return Optional.of(agence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public int delete(String code) {
        try {
            PreparedStatement statement = this.Connection.prepareStatement("delete from agence where code = ?");
            statement.setString(1, code);
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Optional<Agence> searchByCode(String code) {
        try {
            PreparedStatement statement = this.Connection.prepareStatement("select * from agence where code = ?");
            statement.setString(1, code);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                Agence agence = new Agence();
                agence.setCode(code);
                agence.setAdress(resultSet.getString("address"));
                agence.setName(resultSet.getString("name"));
                agence.setPhoneNumber(resultSet.getString("phoneNumber"));
               return Optional.of(agence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Agence> searchByAdress(String adress) {
        try {
            PreparedStatement statement = this.Connection.prepareStatement("select * from agence where address = ?");
            statement.setString(1, adress);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                Agence agence = new Agence();
                agence.setAdress(adress);
                agence.setCode(resultSet.getString("code"));
                agence.setName(resultSet.getString("name"));
                agence.setPhoneNumber(resultSet.getString("phoneNumber"));
               return Optional.of(agence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Agence> update(Agence agence,String code) {
        try {
           PreparedStatement statement = this.Connection.prepareStatement("update agence set name = ? , address =? , phoneNumber = ?");
           statement.setString(1,agence.getName());
           statement.setString(2,agence.getAdress());
           statement.setString(3,agence.getPhoneNumber());
           if(statement.executeUpdate()>0)
          return Optional.of(agence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public Optional<Agence> getOne(String code)
    {
        try {
            PreparedStatement statement = this.Connection.prepareStatement("select * from agence where code = ?");
            statement.setString(1, code);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                Agence agence = new Agence();
                agence.setAdress(resultSet.getString("address"));
                agence.setCode(code);
                agence.setName(resultSet.getString("name"));
                agence.setPhoneNumber("phoneNumber");
                return Optional.of(agence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}