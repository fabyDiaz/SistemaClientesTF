package cl.fabioladiaz.sistemacliente.controller;

import cl.fabioladiaz.sistemacliente.model.Cliente;
import cl.fabioladiaz.sistemacliente.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);


    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        logger.info("ciente encontrado");
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes); // Retorna HTTP 200 OK con la lista de clientes
    }


    @GetMapping("/{rut}")
    public ResponseEntity<Cliente> findByRut(@PathVariable String rut) {
        logger.info("cliente encontrado con el rut: {}", rut);
        Cliente cliente = clienteService.findByRut(rut);
        if (cliente == null) {
            logger.warn("Cliente con el rut {} not encontrado", rut);
            return ResponseEntity.notFound().build(); // Retorna HTTP 404 Not Found
        }
        return ResponseEntity.ok(cliente); // Retorna HTTP 200 OK con el cliente encontrado
    }


    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        logger.info("Se creado el cliente: {}", cliente);
        Cliente nuevoCliente = clienteService.create(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente); // Retorna HTTP 201 Created
    }


    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        logger.info("se ha modificado el cliente: {}", cliente);
        Cliente clienteActualizado = clienteService.update(cliente);
        if (clienteActualizado == null) {
            logger.warn("Cliente cpn rut {} no encontrdo para modificar", cliente.getRut());
            return ResponseEntity.notFound().build(); // Retorna HTTP 404 Not Found
        }
        return ResponseEntity.ok(clienteActualizado); // Retorna HTTP 200 OK con el cliente actualizado
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<Cliente> delete(@PathVariable String rut) {
        logger.info("ciente con rut {} eliminado", rut);
        Cliente clienteEliminado = clienteService.delete(rut);
        if (clienteEliminado == null) {
            logger.warn("Cliente con rut {} no encontrado para eliminar", rut);
            return ResponseEntity.notFound().build(); // Retorna HTTP 404 Not Found
        }
        return ResponseEntity.ok(clienteEliminado); // Retorna HTTP 200 OK con el cliente eliminado
    }
}
