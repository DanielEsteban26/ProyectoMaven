package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IAutoable;
import model.TblAuto;

public class ClassCrudAutoImp implements IAutoable{

	@Override
	public void RegitrarAuto(TblAuto tblauto) {
		EntityManagerFactory fabri=Persistence.createEntityManagerFactory("ProyectoMaven");
		//permite gestionar entidades...
		EntityManager eman=fabri.createEntityManager();
		//iniciar trasaccion....
		eman.getTransaction().begin();
		//registramos
		eman.persist(tblauto);
		//cofirmamos
		eman.getTransaction().commit();
		//cerramos la transaccion
		eman.close();
		
	}

	@Override
	public void ActualizarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TblAuto> ListadoAuto() {
		// establecemos conexion con la unidad de persistencia
				EntityManagerFactory fabri=Persistence.createEntityManagerFactory("ProyectoMaven");
				//permite gestionar entidades...
				EntityManager eman=fabri.createEntityManager();
				//iniciar trasaccion....
				eman.getTransaction().begin();
				List<TblAuto> listado= eman.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
				
				return listado;
	}

	@Override
	public TblAuto BuscarAuto(TblAuto tblauto) {
		// TODO Auto-generated method stub
		return null;
	}

}
