package Clases;


public class ActividadHorarioView {
	  	private int codigo;
	    private String nombre;
	    private String horaInicio;
	    private String horaFin;
	    private String dia;
	    public ActividadHorarioView(int codigo, String nombre, String horaInicio, String horaFin, String dia) { 
	        super();
	        this.codigo = codigo;
	        this.nombre = nombre;
	        this.horaInicio = horaInicio;
	        this.horaFin = horaFin;
	        this.dia = dia;

	    }
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getHoraInicio() {
			return horaInicio;
		}
		public void setHoraInicio(String horaInicio) {
			this.horaInicio = horaInicio;
		}
		public String getHoraFin() {
			return horaFin;
		}
		public void setHoraFin(String horaFin) {
			this.horaFin = horaFin;
		}
		public String getDia() {
			return dia;
		}
		public void setDia(String dia) {
			this.dia = dia;
		}
		@Override
	    public String toString()
	    {
	    	return "Codigo: "+ codigo +"; " + nombre + " De "+ horaInicio + " a " + horaFin;
	    }
}
