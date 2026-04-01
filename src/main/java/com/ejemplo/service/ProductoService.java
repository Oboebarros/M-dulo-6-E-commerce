package com.ejemplo.service;

import com.ejemplo.modelo.Producto;
import com.ejemplo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> listar() {
        return repository.findAll();
    }

    public List<Producto> buscar(String nombre, String categoria) {
        if ((nombre == null || nombre.isEmpty()) && (categoria == null || categoria.isEmpty())) {
            return listar();
        }
        return repository.findByNombreContainingAndCategoriaContainingOrderByNombre(
                nombre != null ? nombre : "",
                categoria != null ? categoria : ""
        );
    }

    public Optional<Producto> buscarPorId(int id) {
        return repository.findById(id);
    }

    public Producto guardar(Producto p) {
        return repository.save(p);
    }

    public void eliminar(int id) {
        repository.deleteById(id);
    }

    public List<String> listarCategorias() {
        return repository.findDistinctCategorias();
    }
}
