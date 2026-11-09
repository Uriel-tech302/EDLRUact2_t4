package com.informati.spring.springboog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.informati.spring.springboog.controllers.dto.ProductoDTO;

@Controller
public class ProductoController {

    @Value("${estudiante.nombre}")
    private String nombreEstudiante;

    // Lista global para poder guardar nuevos productos
    private List<ProductoDTO> lista = new ArrayList<>(Arrays.asList(
        new ProductoDTO("Laptop ASUS TUF", 25000.0, "Computacion"),
        new ProductoDTO("Teclado Mecanico", 1200.0, "Accesorios"),
        new ProductoDTO("Monitor 24 pulgadas", 3500.0, "Pantallas")
    ));

    // 1. Muestra la tabla (lo que ya tenías)
    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", lista);
        model.addAttribute("alumno", nombreEstudiante);
        return "productos";
    }

    // 2. Muestra el formulario vacío
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new ProductoDTO());
        return "formulario";
    }

    // 3. Recibe los datos del formulario usando @ModelAttribute
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute ProductoDTO producto) {
        lista.add(producto);
        // Redirige a la tabla para ver el producto agregado
        return "redirect:/productos"; 
    }
    // 4. @RequestParam: Filtra la lista por categoría (Ej: /productos/buscar?categoria=Pantallas)
    @GetMapping("/productos/buscar")
    public String filtrarPorCategoria(@RequestParam("categoria") String categoria, Model model) {
        List<ProductoDTO> filtrados = new ArrayList<>();
        for (ProductoDTO p : lista) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                filtrados.add(p);
            }
        }
        model.addAttribute("productos", filtrados);
        model.addAttribute("alumno", nombreEstudiante + " (Filtro: " + categoria + ")");
        return "productos"; // Reutiliza la misma vista de la tabla
    }

    // 5. @PathVariable: Muestra el detalle de un solo producto en una ruta dinámica (Ej: /producto/Teclado)
    @GetMapping("/producto/{nombre}")
    public String verDetalle(@PathVariable("nombre") String nombre, Model model) {
        ProductoDTO encontrado = null;
        for (ProductoDTO p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = p;
                break;
            }
        }
        model.addAttribute("producto", encontrado);
        return "detalles"; // Llama a una vista nueva
    }
}