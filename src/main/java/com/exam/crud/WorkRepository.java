package com.exam.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Workdetails, Long>{	
    @Query("FROM Workdetails WHERE id = ?1")
    List<Workdetails> findById(long id);
}