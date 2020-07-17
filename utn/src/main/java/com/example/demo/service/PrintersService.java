package com.example.demo.service;

import com.example.demo.model.Printers;
import com.example.demo.repository.PrintersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintersService {

    private final PrintersRepository printersRepository;

    @Autowired
    public PrintersService(PrintersRepository printersRepository) {
        this.printersRepository = printersRepository;
    }

    public List<Printers> getPrinters(){
        return this.printersRepository.findAll();
    }

    public void addPrinters(Printers printers){
        this.printersRepository.save(printers);
    }

}
