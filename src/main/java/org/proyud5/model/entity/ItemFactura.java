package org.proyud5.model.entity;

import org.bson.types.ObjectId;

public class ItemFactura {

    private Long id;

    private Integer cantidad;


    private ObjectId producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ObjectId getProducto() {
        return producto;
    }

    public void setProducto(ObjectId referencia) {
        this.producto = referencia;
    }
}
