package com.example.demo.service;

import com.example.demo.dto.PrintDto;
import com.example.demo.model.Printers;
import com.example.demo.projection.ImpressionsFilter;
import com.example.demo.repository.ImpressionsRepository;
import com.example.demo.repository.PrintersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrintersService {

    private final PrintersRepository printersRepository;
    private final ImpressionsRepository impressionsRepository;

    @Autowired
    public PrintersService(PrintersRepository printersRepository, ImpressionsRepository impressionsRepository) {
        this.printersRepository = printersRepository;
        this.impressionsRepository = impressionsRepository;
    }


    public List<Printers> getPrinters(){
        return this.printersRepository.findAll();
    }

    public void addPrinters(Printers printers){
        this.printersRepository.save(printers);
    }

    public ResponseEntity<List<PrintDto>> getPrintFilter(){
        List<Printers> printers =  this.printersRepository.findAll();
        ArrayList<PrintDto> printDto = new ArrayList<PrintDto>();
        if(!printers.isEmpty()){
            for (Printers printers1: printers){
                String nameModel = printers1.getBrand() + "  " + printers1.getModel();
                List<ImpressionsFilter> imList = this.impressionsRepository.getImpressionFilter(printers1.getId());
                PrintDto aux = new PrintDto(nameModel,imList);
                printDto.add(aux);
                return ResponseEntity.ok(printDto);
            }
        } else { return ResponseEntity.noContent().build();
        }return ResponseEntity.noContent().build();
    }

}
