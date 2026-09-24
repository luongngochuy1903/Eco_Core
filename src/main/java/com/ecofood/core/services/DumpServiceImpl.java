package com.ecofood.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DumpServiceImpl {
    public String printScreen(){
        return "Hello service core";
    }
}
