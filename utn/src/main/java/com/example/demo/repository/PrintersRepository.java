package com.example.demo.repository;

import com.example.demo.model.Printers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintersRepository extends JpaRepository<Printers,Integer> {
}
