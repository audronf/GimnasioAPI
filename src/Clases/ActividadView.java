package Clases;


public class ActividadView {
	private int codigo;
	private String nombre;
	private float precioHora;
	public ActividadView(int codigo, String nombre, float precioHora) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioHora = precioHora;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public float getPrecioHora() {
		return precioHora;
	}
	public String toString()
	{
		return "Codigo: " + codigo + "; nombre";
	}
	
	
}
