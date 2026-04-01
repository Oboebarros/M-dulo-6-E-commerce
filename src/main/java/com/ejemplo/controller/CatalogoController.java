package com.ejemplo.controller;

import com.ejemplo.modelo.Producto;
import com.ejemplo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public String listar(@RequestParam(required = false) String nombre,
                         @RequestParam(required = false) String categoria,
                         @RequestParam(required = false) String accion,
                         @RequestParam(required = false) Integer id,
                         Model model) {
        
        if ("detalle".equals(accion) && id != null) {
            Optional<Producto> p = service.buscarPorId(id);
            if (p.isPresent()) {
                model.addAttribute("p", p.get());
                return "detalle";
            }
            return "redirect:/catalogo";
        }

        List<Producto> lista = service.buscar(nombre, categoria);
        model.addAttribute("lista", lista);
        model.addAttribute("categorias", service.listarCategorias());
        model.addAttribute("nombre", nombre);
        model.addAttribute("categoria", categoria);

        return "catalogo";
    }
}
