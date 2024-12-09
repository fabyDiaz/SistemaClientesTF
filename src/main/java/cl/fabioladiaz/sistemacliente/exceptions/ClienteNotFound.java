package cl.fabioladiaz.sistemacliente.exceptions;

public class ClienteNotFound  extends RuntimeException{

    public ClienteNotFound(String messege){
        super(messege);
    }
}
