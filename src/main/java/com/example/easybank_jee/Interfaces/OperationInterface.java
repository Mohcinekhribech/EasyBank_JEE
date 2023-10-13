package com.example.easybank_jee.Interfaces;

import com.example.easybank_jee.DTO.Operation;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OperationInterface {
    Optional<Operation> add(Operation operation);
    int delete(int operationNumber);
    List<Operation> searchOperation(Operation operation);
    Optional<Operation> searchOperationByNum(int operationNumber);

}
