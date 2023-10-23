package TesEntidades;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TbDocumento;
import model.TbTipodocumento;

public class tesDocumento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// establecemos conexion con la unidad de persistencia
				EntityManagerFactory fabri=Persistence.createEntityManagerFactory("BDAutoJPA");
				//permite gestionar entidades...
				EntityManager eman=fabri.createEntityManager();
				//iniciar trasaccion....
				eman.getTransaction().begin();
				//instanciar las respectivas entidades
				TbDocumento docum=new TbDocumento();
				TbTipodocumento tipodocu=new TbTipodocumento();
				
				//......registrar//ingresamos nuevos valores....
				/*
				tipodocu.setNomdocu("factura");
				tipodocu.setDescripcion("comprobante de pago");
				eman.persist(tipodocu);
				docum.setNroDocumento("789465");
				docum.setProveDocument("pc leticia e.i.r.l");
				docum.setRucDocument("654412132");
				Date fecha=new Date();
				Date fechasql=new Date();
				docum.setFecha(fechasql);
				docum.setDescripciondocument("recolectar IGV para la sunat");
				docum.setTbTipodocumento(tipodocu);
				eman.persist(docum);
				//emitimos un mensaje por consola
				System.out.println("Dato Registrado!");
				//emitimos un mensaje por consola....
				eman.getTransaction().commit();
				//cerramos
				eman.close();
				*/
				
				/*//------Actualizar------/
				tipodocu.setIdtipoDoc(1);
				tipodocu.setNomdocu("ticket");
				tipodocu.setDescripcion("para llevar control interno");
				eman.merge(tipodocu);
				docum.setIdDocumento(1);
				docum.setNroDocumento("623721");
				docum.setProveDocument("policlinico lima");
				docum.setRucDocument("2019291921");
				Date fecha=new Date();
				Date fechaact=new Date (fecha.getTime());
				docum.setFecha(fechaact);
				docum.setDescripciondocument("comprobante de pago");
				docum.setTbTipodocumento(tipodocu);
				eman.merge(docum);
				//emitimos un mensaje
				System.out.println("Dato Actualizado!");
				//emitimos un mensaje por consola....
			    eman.getTransaction().commit();
				//cerramos
				eman.close();*/
	}

}
