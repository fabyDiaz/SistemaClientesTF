package cl.fabioladiaz.sistemacliente.service;

import cl.fabioladiaz.sistemacliente.model.Cliente;
import cl.fabioladiaz.sistemacliente.model.OrdenCompra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ImplClienteService implements IClienteService {

    private List<Cliente> clientes = new ArrayList<>();
   // OrdenCompra ordenCompra = new OrdenCompra(1,new Date(),1);

    public ImplClienteService(){
        this.clientes.add(new Cliente("111-1", "Homero", "Simpson", "homero@mail.com", "Calle 1",
                List.of(new OrdenCompra(1, new Date(), 1), new OrdenCompra(2, new Date(),2))));
        this.clientes.add(new Cliente("111-2", "March", "Simpson", "march@mail.com", "Calle 1",
                List.of(new OrdenCompra(3, new Date(), 3), new OrdenCompra(4, new Date(),4))));
        this.clientes.add(new Cliente("111-3", "Bart", "Simpson", "bart@mail.com", "Calle 1",
                List.of(new OrdenCompra(5, new Date(), 5))));
    }

    public List<Cliente> findAll() {
        return this.clientes;
    }


    public Cliente findByRut(String rut) {
        return this.clientes.stream()
                .filter(cliente -> cliente.getRut().equals(rut))
                .findFirst()
                .orElse(null);
    }


    public Cliente create(Cliente cliente) {
        // Verificar si ya existe un cliente con el mismo RUT o correo
        Cliente existeCliente = this.clientes.stream()
                .filter(clienteTemporal ->
                        clienteTemporal.getRut().equals(cliente.getRut()) ||
                                clienteTemporal.getCorreo().equals(cliente.getCorreo()))
                .findFirst()
                .orElse(null);

        // Si ya existe un cliente con el mismo RUT o correo, devolver null o lanzar excepción
        if (existeCliente != null) {
            return new Cliente();
        }
        Integer id = Cliente.getIncrementarid();
        id+=1;
        cliente.setId(id);

        // Agregar el nuevo cliente a la lista
        this.clientes.add(cliente);

        // Retornar el cliente recién creado
        return cliente;
    }

    // Actualizar un cliente existente
    public Cliente update(Cliente cliente) {
        Cliente clienteExistente = this.findByRut(cliente.getRut());
        if (clienteExistente != null) {
            int indiceActualizar = this.clientes.indexOf(clienteExistente);
            this.clientes.set(indiceActualizar, cliente);
            return cliente;
        }
        return null;
    }

    // Eliminar un cliente por RUT
    public Cliente delete(String rut) {
        Cliente clienteAEliminar = this.findByRut(rut);
        if (clienteAEliminar != null) {
            this.clientes.remove(clienteAEliminar);
            return clienteAEliminar;
        }
        return null;
    }

}