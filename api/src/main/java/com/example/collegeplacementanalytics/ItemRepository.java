package com.example.collegeplacementanalytics;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ItemRepository extends JpaRepository<Item,Long>{long countByStatus(String status);}
