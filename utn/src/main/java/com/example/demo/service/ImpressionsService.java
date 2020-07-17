package com.example.demo.service;

import com.example.demo.model.Impressions;
import com.example.demo.repository.ImpressionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpressionsService {


   private final ImpressionsRepository impressionsRepository;

   @Autowired
    public ImpressionsService(ImpressionsRepository impressionsRepository) {
        this.impressionsRepository = impressionsRepository;
    }

    public List<Impressions> getImpressions(){
       return this.impressionsRepository.findAll();
    }

    public void addImpressions(Impressions impressions){
       this.impressionsRepository.save(impressions);
    }
}
