package TesEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import model.TbDocumento;
import model.TblCategoria;
import model.TblProducto;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     EntityManagerFactory facto=Persistence.createEntityManagerFactory("BDAutoJPA");
     // manejador de entidades...
     EntityManager eman = facto.createEntityManager();
     //procesos : registrar , actualizar , listar , etc..
     
     //iniciamos transaccion
     eman.getTransaction().begin();
     //instanciamos las respectivas entidades...
     TblCategoria tblcat= new TblCategoria();
     TblProducto tblpro= new TblProducto();
     
     ///********* REGISTRAR .......
     /*tblcat.setNomcateg("generico");
     tblcat.setDescrip("producto de bajo precio");
     ///****** ingresamos datos a la tabla producto....
     tblpro.setNomprod("cetirizina");
     tblpro.setPrecio(10);
     Date fech=new Date();
     Date fechasql= new Date(fech.getTime());
     tblpro.setFechavenc(fechasql);
     tblpro.setCodbarras("321987");
     tblpro.setNrolote("L963254");
     //asignamos el objeto tblcat
     tblpro.setTblCategoria(tblcat);
     eman.persist(tblpro);
     //emitimos mensaje por pantalla
     System.out.println("dato registrado");
     //confirmamos
     eman.getTransaction().commit();
     //cerramos
     eman.close();
     */
     
     //********Actualizar
     /*tblcat.setIdcategoria(1);
     tblcat.setNomcateg("Generico");
     tblcat.setDescrip("Recomendado por el Ministerio del Perú");
	 tblpro.setIdproducto(1);
	 tblpro.setNomprod("misoprostol");
	 tblpro.setPrecio(30);
	 Date fech=new Date();
     Date fechasql= new Date(fech.getTime());
     tblpro.setFechavenc(fechasql);
     tblpro.setCodbarras("23548");
     tblpro.setNrolote("L123489");
     tblpro.setTblCategoria(tblcat);
     eman.merge(tblpro);
     
     System.out.println("dato actualizado");
     //confirmamos
     eman.getTransaction().commit();
     //cerramos
     eman.close();*/
     
     //LISTADOO//
     
    /* List<TbDocumento> listado=eman.createQuery("select docu from TbDocumento docu",TbDocumento.class).getResultList();
	 
     //aplicamos un bucle for
     for(TbDocumento lis:listado){
    	//imprimimos por pantalla
			System.out.println("\n"+"\n"+ " codigo: "+lis.getIdDocumento()+"\n"+" nro de documento: "+lis.getNroDocumento()
			+"\n"+" nombre proveedor: "+lis.getProveDocument()+"\n"+" ruc de docum: "+lis.getRucDocument()+"\n"+
			" fecha: "+lis.getFecha()+"\n"+" descrip document: "+lis.getDescripciondocument()+"\n"+" codigo tipo documento: "+
			lis.getTbTipodocumento().getIdtipoDoc()+"\n"+" nombre documento: "+lis.getTbTipodocumento().getNomdocu()
			+"\n"+" descrip tipo documento: "+lis.getTbTipodocumento().getDescripcion());
		}  //fin del bucle for...*/
     TbDocumento buscarcodigo=eman.find(TbDocumento.class, 2);
     //imprimir por pantalla
     System.out.println(" codigo: "+buscarcodigo.getIdDocumento()+"\n"+" nro de documento: "+buscarcodigo.getNroDocumento()
		+"\n"+" nombre proveedor: "+buscarcodigo.getProveDocument()+"\n"+" ruc de docum: "+buscarcodigo.getRucDocument()+"\n"+
		" fecha: "+buscarcodigo.getFecha()+"\n"+" descrip document: "+buscarcodigo.getDescripciondocument()+"\n"+" codigo tipo documento: "+
		buscarcodigo.getTbTipodocumento().getIdtipoDoc()+"\n"+" nombre documento: "+buscarcodigo.getTbTipodocumento().getNomdocu()
		+"\n"+" descrip tipo documento: "+buscarcodigo.getTbTipodocumento().getDescripcion());
	}//fin del metodo main

}//fin de la clase testproducot
