package Controller;

public class PumakatariNotFoundException extends RuntimeException{
    public PumakatariNotFoundException(Long id) {
        super("No se pudo encontrar el Pumakatari "+id);
    }
}
