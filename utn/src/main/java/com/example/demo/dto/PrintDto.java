package com.example.demo.dto;

import com.example.demo.projection.ImpressionsFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrintDto {

    private String print;

    private List<ImpressionsFilter> imp;

}
