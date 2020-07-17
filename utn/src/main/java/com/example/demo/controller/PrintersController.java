package com.example.demo.controller;

import com.example.demo.dto.PrintDto;
import com.example.demo.model.Printers;
import com.example.demo.service.PrintersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/printers")
public class PrintersController {


    private final PrintersService printersService;

    @Autowired
    public PrintersController(PrintersService printersService) {
        this.printersService = printersService;
    }


    @GetMapping("/")
    public List<Printers> getPrinters(){
        return this.printersService.getPrinters();
    }

    @PostMapping("/")
    public void  addPrinters(@RequestBody Printers printers){
        this.printersService.addPrinters(printers);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PrintDto>> getPrintersFilter(){
        return this.printersService.getPrintFilter();
    }

}
