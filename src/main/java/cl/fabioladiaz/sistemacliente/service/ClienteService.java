package cl.fabioladiaz.sistemacliente.service;

import cl.fabioladiaz.sistemacliente.model.Cliente;
import cl.fabioladiaz.sistemacliente.model.OrdenCompra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();
   // OrdenCompra ordenCompra = new OrdenCompra(1,new Date(),1);

    public ClienteService(){
        this.clientes.add(new Cliente(1,"111-1", "Homero", "Simpson", "homero@mail.com", "Calle 1",
                List.of(new OrdenCompra(1, new Date(), 1), new OrdenCompra(2, new Date(),2))));
        this.clientes.add(new Cliente(2,"111-2", "March", "Simpson", "march@mail.com", "Calle 1",
                List.of(new OrdenCompra(3, new Date(), 3), new OrdenCompra(4, new Date(),4))));
        this.clientes.add(new Cliente(3,"111-3", "Bart", "Simpson", "bart@mail.com", "Calle 1",
                List.of(new OrdenCompra(5, new Date(), 5))));
    }

    public List<Cliente> findAll(){
        return this.clientes;
    }

    public Cliente findByRut(String rut){
        Cliente clientes = this.clientes.stream().
                filter((clienteTemporal -> {
                    return clienteTemporal.getRut().equals(rut);
                })).findFirst().orElse(new Cliente());
        return clientes;
    }
    public Cliente create(Cliente estudiante){
        this.clientes.add(estudiante);
        Cliente clienteInsertado = this.clientes.stream().
                filter((clienteTemporal -> {
                    return clienteTemporal.getRut().equals(estudiante.getRut());
                })).findFirst().orElse(new Cliente());
        return clienteInsertado;
    }
    public Cliente update(Cliente cliente) {
        Cliente clienteEditado = this.clientes.stream().
                filter((clienteTemporal -> {
                    return clienteTemporal.getRut().equals(cliente.getRut());
                })).findFirst().orElse(new Cliente());
        Integer indiceActualizar = this.clientes.indexOf(clienteEditado);
        if (indiceActualizar <= 0) {
            this.clientes.set(indiceActualizar, cliente);
            return clienteEditado;
        }
        return new Cliente();

    }

    public Cliente delete (String rut){
        return null;
    }



}