package Clases;
 
import java.util.List;

 
public class AbonoView {
    private int codigo;
    private String nombre;
    private List<ItemActividadHorario> actividades;
    public AbonoView(int codigo, String nombre, List<ItemActividadHorario> actividades) { //Esto está mal, marcos arreglalo
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.actividades = actividades;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public List<ItemActividadHorario> getActividades() {
        return actividades;
    }
   
}