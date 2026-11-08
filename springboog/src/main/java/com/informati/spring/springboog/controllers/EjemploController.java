package com.informati.spring.springboog.controllers;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@Controller 
public class EjemploController {
    @GetMapping("/detalles_info")
    
    public String info(Map<String, Object> modelo) {
        modelo.put("Titulo", "Servidor en linea");
        modelo.put("Servidor", "Informaticonfig");
        modelo.put("ip", "192.168.1.1");
        return "detalles_info";
    }
}