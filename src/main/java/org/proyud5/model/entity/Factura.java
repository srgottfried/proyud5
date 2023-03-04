package org.proyud5.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Long id;

    private String descripcion;

    private String observacion;

    private int anhoFactura;


    private List<ItemFactura> items;

    public Factura() {
        this.items = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }

    public void addItemFactura(ItemFactura item) {
        this.items.add(item);
    }

    public int getAnhoFactura() {
        return anhoFactura;
    }

    public void setAnhoFactura(int anhoFactura) {
        this.anhoFactura = anhoFactura;
    }

}
