package cl.fabioladiaz.sistemacliente.model;

import lombok.*;

import java.util.List;


@ToString
public class Cliente {

    private int id;
    private String rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String direccion;
    private List<OrdenCompra> ordenesList;

    public Cliente(int id, String rut, String nombre, String apellido, String correo, String direccion, List<OrdenCompra> ordenesList) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.ordenesList = ordenesList;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<OrdenCompra> getOrdenesList() {
        return ordenesList;
    }

    public void setOrdenesList(List<OrdenCompra> ordenesList) {
        this.ordenesList = ordenesList;
    }
}
