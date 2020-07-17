package com.example.demo.controller;

import com.example.demo.model.Impressions;
import com.example.demo.service.ImpressionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/impressions")
public class ImpressionsController {

    private final ImpressionsService impressionsService;

    @Autowired
    public ImpressionsController(ImpressionsService impressionsService) {
        this.impressionsService = impressionsService;
    }

    @GetMapping("/")
    public List<Impressions> getImpressions(){
        return  this.impressionsService.getImpressions();
    }

    @PostMapping("/")
    public void addImpressions(@RequestBody Impressions impressions){
        this.addImpressions(impressions);
    }

}
