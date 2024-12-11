package cl.fabioladiaz.sistemacliente.service;

import cl.fabioladiaz.sistemacliente.model.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();
    public Cliente findByRut(String rut);
    public Cliente create(Cliente cliente);
    public Cliente update(Cliente cliente);
    public Cliente delete(String rut);

    /*
    para hacerlo genérico se hace lo siguiente
     public List<T> findAll();
    public T findByRut(S rut);
    public T create(T cliente);
    public T update(T cliente);
    public T delete(S rut);
     */


}
