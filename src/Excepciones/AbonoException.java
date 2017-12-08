package Excepciones;
 
public class AbonoException extends Exception {
 
    /**
     *
     */
    private static final long serialVersionUID = 2439648175793016312L;
    public AbonoException(String mensaje) {
        super(mensaje);
    }
}