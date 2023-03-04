package org.proyud5.model.entity;

import org.bson.types.ObjectId;

import java.util.List;

public class Proveedor {

    private Long id;
    private String nombreEmpresa;
    private String cif;
    private String direccion;

    private List<ObjectId> productos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<ObjectId> getProductos() {
        return productos;
    }

    public void setProductos(List<ObjectId> productos) {
        this.productos = productos;
    }
}
