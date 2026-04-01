package com.ejemplo.service;

import com.ejemplo.modelo.Producto;
import com.ejemplo.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductoServiceTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private ProductoService service;

    @Test
    public void testListar() {
        List<Producto> mockList = new ArrayList<>();
        mockList.add(new Producto(1, "Oboe", "Desc", "DescL", 1000, "Cat", "Sub", "Url", "Mat", "Niv"));
        
        when(repository.findAll()).thenReturn(mockList);

        List<Producto> result = service.listar();
        assertEquals(1, result.size());
        assertEquals("Oboe", result.get(0).getNombre());
    }
}
