package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IDocumentoable;
import model.TbDocumento;

public class ClassCrudDocumentoable implements IDocumentoable{

	@Override
	public void RegitrarDocumento(TbDocumento tbldocum) {
		// establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//permite gestionar entidades...
		EntityManager eman=fabri.createEntityManager();
		//iniciar trasaccion....
		eman.getTransaction().begin();
		//registramos
		eman.persist(tbldocum);
		//cofirmamos
		eman.getTransaction().commit();
		//cerramos la transaccion
		eman.close();
		
		
	}//fin del metodo registrar

	@Override
	public void ActualizarDocumento(TbDocumento tbldocum) {
		// establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//permite gestionar entidades...
		EntityManager eman=fabri.createEntityManager();
		//iniciar trasaccion....
		eman.getTransaction().begin();
		//actualizamos
		eman.merge(tbldocum);
		//confirmamos
		eman.getTransaction().commit();
		//cerramos
		eman.close();
	}//fin del metodo actualizar

	@Override
	public void EliminarDocumento(TbDocumento tbldocum) {
		// TODO Auto-generated method stub
		
	}//fin del metodo eliminar

	@Override
	public List<TbDocumento> ListadoDocumentos() {
		// establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//permite gestionar entidades...
		EntityManager eman=fabri.createEntityManager();
		//iniciar trasaccion....
		eman.getTransaction().begin();
		List<TbDocumento> listado= eman.createQuery("select docu from TbDocumento docu",TbDocumento.class).getResultList();
		
		return listado;
	}//fin del metodo listado

	@Override
	public TbDocumento BuscarDocumento(TbDocumento tbldocum) {
		// establecemos conexion con la unidad de persistencia
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
		//permite gestionar entidades...
		EntityManager eman=fabri.createEntityManager();
		//iniciar trasaccion....
		eman.getTransaction().begin();
		//iniciar transaccion
		TbDocumento buscado= eman.find(TbDocumento.class,tbldocum.getIdDocumento());
		return buscado;
	}//fin del metodo buscar

}
