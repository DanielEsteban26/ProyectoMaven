package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IEmpleadoable;

import model.TblEmpleado;

public class ClassCrudEmpleadoImp implements IEmpleadoable{

	@Override
	public void RegistrarEmpleado(TblEmpleado tblemp) {
		
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Manejador de entidades segun unidad de persistencia....
		EntityManager entitymanag= conex.createEntityManager();
		//Realizamos el proceso...
		//iniciar transaccion..
		entitymanag.getTransaction().begin();
		//registrar datos...
		entitymanag.persist(tblemp);
		//confirmamos
		entitymanag.getTransaction().commit();
		//cerramos
		entitymanag.close();
		
	}// fin de registrar

	@Override
	public void ActualizarEmpleado(TblEmpleado tblemp) {
		// TODO Auto-generated method stub
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
		//manejador de entidades segun unidad de persistencia
		EntityManager entitymanag= conex.createEntityManager();
		//realizamos el proceso
		//iniciar transaccion
		entitymanag.getTransaction().begin();
		//actualizamos datos
		entitymanag.merge(tblemp);
		System.out.println("dato actualizado");
		//confirmamos
		entitymanag.getTransaction().commit();
		//cerramos
		entitymanag.close();
		
	}//fin de actualizar

	@Override
	public void EliminarEmpleado(TblEmpleado tblemp) {
		// TODO Auto-generated method stub
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Manejador de entidades segun unidad de persistencia....
		EntityManager entitymanag= conex.createEntityManager();
		//Realizamos el proceso...
		//iniciar transaccion..
		entitymanag.getTransaction().begin();
		
		//RECUPERAR EL CODIGO A ELIMINAR
		TblEmpleado eli=entitymanag.merge(tblemp);
		//eliminamos el datos de la base de datos
		entitymanag.remove(eli);
		System.out.println("Dato eliminado de la BD!!!!!");
		//confirmamos 
		entitymanag.getTransaction().commit();
		//cerramos
		entitymanag.close();
		
		
	}//fin de eliminar 

	@Override
	public List<TblEmpleado> ListadoEmpleado() {
		// TODO Auto-generated method stub
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Manejador de entidades segun unidad de persistencia....
		EntityManager entitymanag= conex.createEntityManager();
		//Realizamos el proceso...
		//iniciar transaccion..
		entitymanag.getTransaction().begin();
		
		//aplicamos JPQL se base en entidades..
		List<TblEmpleado> listado= entitymanag.createQuery("select e from TblEmpleado e",TblEmpleado.class).getResultList();
	    //confirmamos 
		entitymanag.getTransaction().commit();
		//cerramos 
		entitymanag.close();
		
		//retornamos el listado
		return listado;
	}//fin de list

	@Override
	public TblEmpleado BuscarEmpleadoCodigo(TblEmpleado tblemp) {
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
		//Manejador de entidades segun unidad de persistencia....
		EntityManager entitymanag= conex.createEntityManager();
		//Realizamos el proceso...
		//iniciar transaccion..
		entitymanag.getTransaction().begin();
		
		//realizamos el proceso
		//iniciar transaccion
		TblEmpleado buscar= entitymanag.find(TblEmpleado.class, tblemp.getIdempleado());
		//confirmamos 
		entitymanag.close();
		//retornamos el valor buscado
		
		
		return buscar;
	}// fin de buscar

}
