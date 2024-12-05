package cl.fabioladiaz.sistemacliente.model;

import lombok.*;

import java.util.Date;

@ToString
public class OrdenCompra {

    private int id;
    private Date fecha;
    private int idProducto;

    public OrdenCompra(int id, Date fecha, int idProducto) {
        this.id = id;
        this.fecha = fecha;
        this.idProducto = idProducto;
    }

    public OrdenCompra() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
