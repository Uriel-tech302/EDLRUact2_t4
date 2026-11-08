package com.informati.spring.springboog.controllers;


//import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EjemploRestController {
    @GetMapping("/detalles_info2")
    
    public Map<String, Object>detalles_info2() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Titulo", "Servidor en linea");
        respuesta.put("Servidor", "Informaticonfig");
        respuesta.put("ip", "192.168.1.1");
        return respuesta;
    }
    
}