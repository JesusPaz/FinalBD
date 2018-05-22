package mundo;

import java.sql.Date;

public class Cliente {
	
	// ATRIBUTOS
	/**
	 * cedula del cliente
	 */
	private String cedula;
	/**
	 * nombre del cliente
	 */
	private String nombre;
	/**
	 * fecha nacimiento del cliente
	 */
	private Date fechaNacimiento;
	/**
	 * direccion del cliente
	 */
	private String direccion;
	/**
	 * telefono del cliente
	 */
	private String telefono;
	
	
	
	// CONSTRUCTOR
	
	
	
	/** CONSTRUCTOR del cliente
	 * @param cedula
	 * @param nombre
	 * @param fechaNacimiento
	 * @param direccion
	 * @param telefono
	 */
	@SuppressWarnings("deprecation")
	public Cliente(String cedula, String nombre, String fechaNacimiento, String direccion, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimiento = new Date(2000,12,1);
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	
	
	// METODOS
	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}
	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}
