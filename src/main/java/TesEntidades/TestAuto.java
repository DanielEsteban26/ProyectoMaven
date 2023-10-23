package TesEntidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import java.util.List;

import model.TblAuto;

public class TestAuto{
	public static void main(String[] args){
		//establecemos la conexion de persistencia..
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("ProyectoMaven");
		
		//gestionar entidades como registrar, actualizar, eliminar, listar, buscar..
		EntityManager emanager= conex.createEntityManager();
		//iniciamos transaccion...(inicar las operaciones)
		emanager.getTransaction().begin();
		
		//analizamos un instancia
		TblAuto auto= new TblAuto();
		
		//aplicamos  un switch....
		String accion=JOptionPane.showInputDialog("Ingrese la Accion");
		switch(accion){
		case "Registrar":
			//ingresamos valores a enviar a la base de datos
			auto.setColor("rojoMaven");
			auto.setModelo("civicMaven");
			auto.setMotor("1.2");
			auto.setPrecio(20000);
			auto.setMarca("honda");
			auto.setFabricacion("2022");
			//registremos los datos con presist...
			//persist...(insert into tbl_auto values(.........))	
			emanager.persist(auto);
			//emitimos un mensaje por consola
			System.out.println("Datos registrados en la BD");
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos la transaccion
			emanager.close();
			//salimos
			break;
		case "Actualizar" :
			auto.setIdAuto(4);
			auto.setColor("azul claro");
			auto.setModelo("f1");
			auto.setMotor("1.8");
			auto.setPrecio(15000);
			auto.setMarca("BMW");
			auto.setFabricacion("2023");
			//realizamos la actualizacion
			//update tbl_auto set color="marron", modelo="BMV"  where id=5;
			emanager.merge(auto);
			System.out.println("datos actualizados correctamente");
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos 
			emanager.close();
			//salimos
			break;
		case "Eliminar" :
			auto.setIdAuto(4);
			TblAuto elim=emanager.merge(auto);
			//realizamos la eliminacion
			//en jdbc delete  from tbl_auto where idauto;
			emanager.remove(elim);
			//imprimimos el mensaje
			System.out.println("dato eliminado correctamente");
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos 
			emanager.close();
			//salimos
			break;
		case "Buscar" :
			//en jdbc 
			//select * from tbl_auto where idauto=?;
			TblAuto busc=emanager.find(TblAuto.class,3);
 
			//aplicamos un condicion
			if(busc == null){
				//emitimos un mensaje por pantalla
				System.out.println("registro no encontrado");
			}
			else{
				System.out.println("registro encontrado");
				//imprimimos por pantalla las caracteristicas del registro
				System.out.println("codigo : " + busc.getIdAuto() + "\n" +
						           "color : " + busc.getColor() + "\n" +
						           "modelo : " + busc.getModelo() + "\n" +
						           "motor : " + busc.getMotor() + "\n" +
						           "precio : " + busc.getPrecio() + "\n" +
						           "fabricacion : " + busc.getFabricacion());
			}
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos
			emanager.close();
			//out
			break;
		case "listar" :
			 List<TblAuto> listado = emanager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
		     for(TblAuto lis:listado){
		    	 //imprimimos dentro del bucle
		    	 System.out.println( "\n" + "codigo : " + lis.getIdAuto() + "\n" +
				           "color : " + lis.getColor() + "\n" +
				           "modelo : " + lis.getModelo() + "\n" +
				           "motor : " + lis.getMotor() + "\n" +
				           "precio : " + lis.getPrecio() + "\n" +
				           "fabricacion : " + lis.getFabricacion() + "\n" + "\n" );
		    	 
		     }//fin del bucle
		     
		     emanager.getTransaction().commit();
		     //cerramos 
		     emanager.close();
		     //salimos
		     break;
		     
		 case "EliminarII":
			 //eliminado el codigo numero "3"
		     TblAuto elimII=emanager.find(TblAuto.class,3);
		     //aplicacion una codicion...
		      if(elimII==null){
		    	  //emitimos un mensaje...
		    	  System.out.println("el codigo no existe en la BD1!!!!!");  
		      }else{
		    	  //emitimos un mensaje por pantalla 
		    	  System.out.println("Registrado encontrado");
		    	  //eliminamos el registro
		    	  emanager.remove(elimII);
		    	  //confirmamos
		    	  emanager.getTransaction().commit();
		    	  //cerramos
		    	  emanager.close();	 
		    	//mensaje
		    	  System.out.println("codigo eliminado de la BD!!!!!");
		      }//fin del else
		    //salimos  
	    	break;
		      
		     
		 default:   	 
		    	 System.out.println("Accion no encontrada");

		 
			  
		}//fin del swicth....
		
	}//fin del metodo principal
}//fin de la clase