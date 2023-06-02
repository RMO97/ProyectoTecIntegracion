package com.perreria.backend.repository;

import com.perreria.backend.model.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Seguimiento,Long>{
}
