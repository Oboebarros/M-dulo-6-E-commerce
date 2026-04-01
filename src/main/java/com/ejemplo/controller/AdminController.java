package com.ejemplo.controller;

import com.ejemplo.modelo.Producto;
import com.ejemplo.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/products")
public class AdminController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public String listar(@RequestParam(required = false) String nombre,
                         @RequestParam(required = false) String categoria,
                         @RequestParam(required = false) String accion,
                         @RequestParam(required = false) Integer id,
                         Model model) {
        
        if (accion != null) {
            switch (accion) {
                case "nuevo" -> {
                    model.addAttribute("producto", new Producto());
                    model.addAttribute("categorias", service.listarCategorias());
                    return "formulario";
                }
                case "editar" -> {
                    if (id != null) {
                        Optional<Producto> p = service.buscarPorId(id);
                        if (p.isPresent()) {
                            model.addAttribute("producto", p.get());
                            model.addAttribute("categorias", service.listarCategorias());
                            return "formulario";
                        }
                    }
                    return "redirect:/admin/products";
                }
                case "eliminar" -> {
                    if (id != null) {
                        Optional<Producto> p = service.buscarPorId(id);
                        if (p.isPresent()) {
                            model.addAttribute("producto", p.get());
                            return "confirmar-eliminar";
                        }
                    }
                    return "redirect:/admin/products";
                }
            }
        }

        List<Producto> lista = service.buscar(nombre, categoria);
        model.addAttribute("lista", lista);
        model.addAttribute("categorias", service.listarCategorias());
        model.addAttribute("nombre", nombre);
        model.addAttribute("categoria", categoria);
        return "lista";
    }

    @PostMapping
    public String postAction(@RequestParam String accion,
                             @ModelAttribute Producto producto,
                             @RequestParam(required = false) Integer id,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        
        if ("eliminar".equals(accion)) {
            if (id != null) {
                service.eliminar(id);
            }
            return "redirect:/admin/products";
        }

        // Validación básica
        String error = validar(producto);
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("producto", producto);
            model.addAttribute("categorias", service.listarCategorias());
            return "formulario";
        }

        if ("crear".equals(accion) || "actualizar".equals(accion)) {
            service.guardar(producto);
            String msg = "actualizar".equals(accion) ? "actualizado" : "creado";
            redirectAttributes.addFlashAttribute("mensaje", "Producto '" + producto.getNombre() + "' " + msg + " exitosamente.");
        }

        return "redirect:/admin/products";
    }

    private String validar(Producto p) {
        if (p.getNombre() == null || p.getNombre().trim().isEmpty()) {
            return "El nombre del producto es obligatorio.";
        }
        if (p.getCategoria() == null || p.getCategoria().trim().isEmpty()) {
            return "La categoría es obligatoria.";
        }
        if (p.getPrecio() <= 0) {
            return "El precio debe ser un número mayor a 0.";
        }
        return null;
    }
}
