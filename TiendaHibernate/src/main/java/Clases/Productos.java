package Clases;

import Clases.Producto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.io.File;
import java.util.List;

public class Productos {
	static StandardServiceRegistry s = null;
	static SessionFactory sf = null;

	public static void abrirConexion() {
		File f = new File("C:\\Users\\Administrator\\eclipse-workspace\\TiendaHibernate\\hibernate.cfg.xml");
		s = new StandardServiceRegistryBuilder().configure(f).build();
		sf = new MetadataSources(s).buildMetadata().buildSessionFactory();
	}

	public static void cerrarConexion() {
		if (sf != null) {
			sf.close();
		}

	}

	public static void agregarProducto(Producto producto) {
		abrirConexion();
		Transaction transaction = null;
		try (Session session = sf.openSession()) {
			transaction = session.beginTransaction();
			session.save(producto);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		cerrarConexion();

	}

	public static List listarProductos() {
		abrirConexion();
		List lista = null;
		try (Session session = sf.openSession()) {
			Query query = session.createQuery("from Producto");
			lista = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		cerrarConexion();
		return lista;

	}

	public static void eliminarProducto(Producto producto) {
		abrirConexion();
		Transaction transaction = null;
		try (Session session = sf.openSession()) {
			transaction = session.beginTransaction();
			session.delete(producto);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		cerrarConexion();

	}

	public static void comprarProducto(int id) {
		abrirConexion();

		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Producto producto = session.get(Producto.class, id);
		if (producto != null && producto.getStock() > 0) {
			producto.setStock(producto.getStock() - 1);
			session.save(producto);
		} else if(producto != null && producto.isRenovar()){
			producto.setStock(10);
			session.save(producto);
		}else {
			eliminarProducto(producto);
		}
		transaction.commit();
		cerrarConexion();
	}
}
