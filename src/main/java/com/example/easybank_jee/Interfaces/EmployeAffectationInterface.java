package com.example.easybank_jee.Interfaces;

import com.example.easybank_jee.DTO.EmployeAffectation;

import java.util.List;
import java.util.Optional;


public interface EmployeAffectationInterface {
    Optional<EmployeAffectation> create(EmployeAffectation employeAffectation);
    Optional<EmployeAffectation> update(EmployeAffectation employeAffectation);
    List<EmployeAffectation> getAll();
}
