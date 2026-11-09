package com.informati.spring.springboog.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.informati.spring.springboog.controllers.dto.ProductoDTO;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

    // Aquí usamos @RequestBody en lugar de @ModelAttribute
    @PostMapping("/producto-post")
    public ProductoDTO recibirProductoRest(@RequestBody ProductoDTO nuevoProducto) {
        // El endpoint recibe el JSON, lo convierte a DTO y lo devuelve tal cual
        // para confirmar en Postman que la comunicación fue exitosa.
        return nuevoProducto;
    }
}