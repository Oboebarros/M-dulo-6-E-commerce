package com.ejemplo.controller;

import com.ejemplo.modelo.ItemCarrito;
import com.ejemplo.modelo.Producto;
import com.ejemplo.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public String verCarrito() {
        return "carrito";
    }

    @PostMapping
    public String postAction(@RequestParam String accion,
                             @RequestParam(required = false) Integer productoId,
                             @RequestParam(required = false) Integer cantidad,
                             HttpSession session,
                             Model model) {
        
        switch (accion != null ? accion : "") {
            case "agregar" -> {
                agregar(productoId, cantidad, session);
                return "redirect:/catalogo?msg=agregado";
            }
            case "eliminar" -> eliminar(productoId, session);
            case "vaciar" -> session.removeAttribute("carrito");
            case "finalizar" -> {
                return finalizar(session, model);
            }
        }
        return "redirect:/carrito";
    }

    private void agregar(Integer productoId, Integer cantidad, HttpSession session) {
        if (productoId == null) return;
        int cantidadAAgregar = (cantidad != null) ? cantidad : 1;

        Optional<Producto> optP = service.buscarPorId(productoId);
        if (optP.isPresent()) {
            Producto p = optP.get();
            List<ItemCarrito> carrito = obtenerCarrito(session);

            boolean encontrado = false;
            for (ItemCarrito item : carrito) {
                if (item.getProductoId() == p.getId()) {
                    item.setCantidad(item.getCantidad() + cantidadAAgregar);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                carrito.add(new ItemCarrito(
                        p.getId(),
                        p.getNombre(),
                        p.getPrecio(),
                        cantidadAAgregar,
                        p.getImagenUrl(),
                        p.getNivel()
                ));
            }
            session.setAttribute("carrito", carrito);
        }
    }

    private void eliminar(Integer productoId, HttpSession session) {
        if (productoId == null) return;
        List<ItemCarrito> carrito = obtenerCarrito(session);
        carrito.removeIf(item -> item.getProductoId() == productoId);
        session.setAttribute("carrito", carrito);
    }

    private String finalizar(HttpSession session, Model model) {
        List<ItemCarrito> carrito = obtenerCarrito(session);
        if (carrito.isEmpty()) {
            return "redirect:/carrito";
        }
        session.removeAttribute("carrito");
        model.addAttribute("mensaje", "¡Gracias por su compra! Su pedido ha sido procesado con éxito.");
        return "exito";
    }

    @SuppressWarnings("unchecked")
    private List<ItemCarrito> obtenerCarrito(HttpSession session) {
        List<ItemCarrito> carrito = (List<ItemCarrito>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        return carrito;
    }
}
