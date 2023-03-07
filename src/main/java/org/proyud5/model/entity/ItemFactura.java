package org.proyud5.model.entity;

import org.bson.types.ObjectId;

public class ItemFactura {

    private Integer cantidad;

    private ObjectId producto;

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
