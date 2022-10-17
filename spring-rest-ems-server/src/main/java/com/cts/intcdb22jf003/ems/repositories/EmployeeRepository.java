package com.cts.intcdb22jf003.ems.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.intcdb22jf003.ems.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
	// Query Methods 
	/**
	 * 
	 * @param username
	 * @return  employee if found else returns null
	 */
	public Optional<Employee> findByUsername(String username);
}
