package TesEntidades;

import java.util.Date;
import java.util.List;

import Dao.ClassCrudEmpleadoImp;
import model.TblEmpleado;

public class TestEmpleado {

	public static void main(String[] args) {
		//realizamos las respectivas instancias
    TblEmpleado tblemp= new TblEmpleado();
    ClassCrudEmpleadoImp crud= new ClassCrudEmpleadoImp();
	//ingresamos valores
   /* tblemp.setNombre("Olegario bruno");
    tblemp.setApellido("Cueva Lozano");
    tblemp.setSexo("M");
    tblemp.setEmail("olegariobruno@gmail.com");
    tblemp.setDni("9769825");
    tblemp.setTelf("987258635");
    //convertimos la fecha a javasql
    Date fecha=new Date();
    Date fechasql=new Date(fecha.getTime());
    tblemp.setFechanac(fechasql);
    
   //invocamos metodo registrar
    crud.RegistrarEmpleado(tblemp);
    //emitimos un mensaje por consola
    System.out.println("dato registrado en BD");
   */
    /*-------------------------------------------*/
    /*  //TESTEANDO EL METODO Actualizar
    tblemp.setIdempleado(2);
    tblemp.setNombre("nilson alexander");
    tblemp.setApellido("silva rodrigez");
    tblemp.setSexo("M");
    tblemp.setEmail("nilson@hmail.com");
    tblemp.setDni("321654987");
    tblemp.setTelf("987654312");
    //convertimos la fecha en java.sql
    Date fecha=new Date();
    Date fechasql=new Date(fecha.getTime());
    tblemp.setFechanac(fechasql);
    //invocamos metodo actualizar
    crud.ActualizarEmpleado(tblemp);
    //emitimos un mensaje por consola
    System.out.println("dato actualizado en BD");
    */
    
     /*  //TESTEANDO ELIMINAR
    tblemp.setIdempleado(5);
    //invocamos al metodo eliminar
    crud.EliminarEmpleado(tblemp);*/
    
    /*//TESTEANDO EL LISTADO    
    
  
	List<TblEmpleado> listar =crud.ListadoEmpleado();
    //aplicamos un bucle
	for(TblEmpleado lis:listar){
		//imprimimos por pantalla
		System.out.println("\n" +"codigo : "+ lis.getIdempleado() + "\n" +
				           "nombre : "+ lis.getNombre()+ "\n" +
				           "apellido : "+ lis.getApellido()+ "\n" +
				           "sexo : "+ lis.getSexo()+ "\n" +
				           "email : "+ lis.getEmail()+ "\n" +
				           "DNI : "+ lis.getDni()+ "\n" +
				           "telf : "+ lis.getTelf() +"\n"+
	                       "Fecha nac : "+ list.getFechanac() +"\n"+"\n") ;			           
    
	} // fin de bucle for...
	 */
    /*/*TESTEANDO EL METODO BUSCAR
    tblemp.setIdempleado(1);
    TblEmpleado buscod=crud.BuscarEmpleadoCodigo(tblemp);
    
	System.out.println("\n" +"codigo : "+ buscod.getIdempleado() + "\n" +
	           "nombre : "+ buscod.getNombre()+ "\n" +
	           "apellido : "+ buscod.getApellido()+ "\n" +
	           "sexo : "+ buscod.getSexo()+ "\n" +
	           "email : "+ buscod.getEmail()+ "\n" +
	           "DNI : "+ buscod.getDni()+ "\n" +
	           "telf : "+ buscod.getTelf() +"\n"+
	           "Fecha nac : "+ buscod.getFechanac() +"\n"+"\n") ;
	*/
	}
}//fin de la clase testempleado
