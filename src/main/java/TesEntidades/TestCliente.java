package TesEntidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.sun.security.ntlm.Client;

import model.TblAuto;
import model.TblCliente;

public class TestCliente {

	public static void main(String[] args) {
		//establecemos la conexion de persistencia..
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutoJPA");
				
		//gestionar entidades como registrar, actualizar, eliminar, listar, buscar..
		EntityManager emanager= conex.createEntityManager();
		//iniciamos transaccion...(inicar las operaciones)
		emanager.getTransaction().begin();
				
		//analizamos un instancia
		TblCliente cliente= new TblCliente();
		//creamos una variable de tipo string de nombre accion
		String accion = JOptionPane.showInputDialog("ingrese la accion");
		//aplicamos el switch....
		switch (accion) {
		case "Registrar":
			cliente.setNombre("patricia evelyn");
			cliente.setApellido("alva macedo");
			cliente.setEmail("AlvaEvelyn@gmail.com");
			cliente.setSexo("F");
			cliente.setDni("3216345");
			
			//registramos en la BD
			emanager.persist(cliente);
            System.out.println("Registrado en BD");
			//confimar
			emanager.getTransaction().commit();
			//cerramos 
			emanager.close();
			
			//salimos
			break;
		case "Actualizar":
			cliente.setIdcliente(1);
			cliente.setNombre("dany estiven");
			cliente.setApellido("isidro castañeda");
			cliente.setEmail("isidrocat@gmail.com");
			cliente.setSexo("M");
			cliente.setDni("3216345");
			
			//realizamos la actualizacion
			//update tbl_auto set color="marron", modelo="BMV"  where id=5;
			emanager.merge(cliente);
			System.out.println("datos actualizados correctamente");
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos 
			emanager.close();
	
			//salimos
			break;
		case "Eliminar":
			cliente.setIdcliente(6);
			TblCliente elim=emanager.merge(cliente);
			//realizamos la eliminacion
			//en jdbc delete  from tbl_cliente where idcliente;
			emanager.remove(elim);
			//imprimimos el mensaje
			System.out.println("dato eliminado correctamente");
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos 
			emanager.close();
			
			//salimos
			break;
		case "Buscar":
			//en jdbc 
			//select * from tbl_auto where idauto=?;
			TblCliente busc=emanager.find(TblCliente.class,4);
 
			//aplicamos un condicion
			if(busc == null){
				//emitimos un mensaje por pantalla
				System.out.println("registro no encontrado");
			}
			else{
				System.out.println("registro encontrado");
				//imprimimos por pantalla las caracteristicas del registro
				System.out.println("codigo : " + busc.getIdcliente() + "\n" +
						           "nombre : " + busc.getNombre() + "\n" +
						           "apellido : " + busc.getApellido() + "\n" +
						           "email : " + busc.getEmail() + "\n" +
						           "DNI : " + busc.getDni() + "\n" +
						           "sexo : " + busc.getSexo());
			}
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos
			emanager.close();
			//salimos
			break;
		case "Listar":
			
			
			//salimos
			break;
		case "EliminarII":
			
			
			//salimos
			break;

		default:
			break;
	
		
	}

	}
}
