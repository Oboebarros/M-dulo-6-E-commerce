package com.ejemplo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "descripcion_larga", columnDefinition = "TEXT")
    private String descripcionLarga;
    
    @Column(nullable = false)
    private double precio;
    
    @Column(nullable = false)
    private String categoria;
    
    private String subcategoria;
    
    @Column(name = "imagen_url")
    private String imagenUrl;
    
    private String material;
    private String nivel;

    public Producto() {}

    public Producto(int id, String nombre, String descripcion, String descripcionLarga,
                    double precio, String categoria, String subcategoria,
                    String imagenUrl, String material, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descripcionLarga = descripcionLarga;
        this.precio = precio;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.imagenUrl = imagenUrl;
        this.material = material;
        this.nivel = nivel;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getDescripcionLarga() { return descripcionLarga; }
    public void setDescripcionLarga(String descripcionLarga) { this.descripcionLarga = descripcionLarga; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getSubcategoria() { return subcategoria; }
    public void setSubcategoria(String subcategoria) { this.subcategoria = subcategoria; }
    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
}