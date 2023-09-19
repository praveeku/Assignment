package com.assignment.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Code;
@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {
   
}

