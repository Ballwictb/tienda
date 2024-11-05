package Clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nombre;
	private float precio;
	private String imagen;
	private int stock;
	private boolean renovar;

	public Producto() {}

	public Producto(String nombre, int precio, String imagen, int stock,boolean renovar) {
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.stock = stock;
		this.renovar = renovar;
	}

	
	
	
	public boolean isRenovar() {
		return renovar;
	}

	public void setRenovar(boolean renovar) {
		this.renovar = renovar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
