package com.example.easybank_jee.Services;

import com.example.easybank_jee.DTO.Employee;
import com.example.easybank_jee.Interfaces.EmployeInterface;

import java.util.List;
import java.util.Optional;

public class EmployeService {
    private EmployeInterface employeDao;

    public EmployeService(EmployeInterface employeDao) {
        this.employeDao = employeDao;
    }

    public Optional<Employee> add(Employee employee) {
        if (employee != null) {
            return this.employeDao.add(Optional.of(employee));
        }
        return Optional.empty();
    }

    public int delete(String registrationNumber) {
        return this.employeDao.delete(registrationNumber);
    }

    public Optional<Employee> update(Employee employee, String code) {
        return this.employeDao.update(employee, code);
    }

    public Optional<Employee> searchByRegistrationNumber(String registrationNumber) {
        return this.employeDao.SearchByRegistrationNumber(registrationNumber);
    }

    public List<Employee> search(Employee employee) {
        return this.employeDao.Search(employee);
    }
}