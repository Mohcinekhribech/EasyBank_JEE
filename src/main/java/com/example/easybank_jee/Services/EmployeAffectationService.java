package com.example.easybank_jee.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.example.easybank_jee.DTO.EmployeAffectation;
import com.example.easybank_jee.Interfaces.EmployeAffectationInterface;

public class EmployeAffectationService {
    EmployeAffectationInterface employeAffectationDao;

    public EmployeAffectationService(EmployeAffectationInterface employeAffectationDao) {
        this.employeAffectationDao = employeAffectationDao;
    }

    public Optional<EmployeAffectation> AssignAnEmployeeToAnAgency(EmployeAffectation employeAffectation) {
        if (employeAffectation != null) {
            if (employeAffectationDao.create(employeAffectation).isPresent())
                return Optional.of(employeAffectation);
        }
        return null;
    }

    public Optional<EmployeAffectation> transferAnEmployee(EmployeAffectation employeAffectation)
    {
        if(employeAffectationDao.update(employeAffectation).isPresent())
        {
            return Optional.of(employeAffectation);
        }
        return null;
    }

    public List<EmployeAffectation> assignmentHistory()
    {
        return employeAffectationDao.getAll();
    }
}
