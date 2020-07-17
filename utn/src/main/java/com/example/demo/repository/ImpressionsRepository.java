package com.example.demo.repository;

import com.example.demo.model.Impressions;
import com.example.demo.projection.ImpressionsFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImpressionsRepository extends JpaRepository<Impressions,Integer> {
    @Query(value = "SELECT im.name as Name, im.weight as Weight FROM impressions im " +
            "WHERE im.printers_id = ?1",nativeQuery = true)
    List<ImpressionsFilter> getImpressionFilter(Integer id);
}
