package cl.fabioladiaz.sistemacliente.controller;

import cl.fabioladiaz.sistemacliente.model.Cliente;
import cl.fabioladiaz.sistemacliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    //CRUD
   @GetMapping
    public List<Cliente> findAll() {
        System.out.println("findAll");
        return clienteService.findAll();
    }

    // Obtener un estudiante por RUT
    @GetMapping("/{rut}")
    public Cliente findByRut(@PathVariable String rut) {
        System.out.println("findByRut: " + rut);
        return clienteService.findByRut(rut);
    }

    // Crear un nuevo estudiante
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        System.out.println("create: " + cliente);
        return clienteService.create(cliente);
    }

    // Actualizar un estudiante existente
    @PutMapping
    public Cliente update(@RequestBody Cliente cliente) {
        System.out.println("update: " + cliente);
        return clienteService.update(cliente);
    }

    // Eliminar un estudiante por RUT
    @DeleteMapping("/{rut}")
    public Cliente delete(@PathVariable String rut) {
        System.out.println("deleteByRut: " + rut);
        return clienteService.delete(rut);
    }
}
