package Interfaces;

import java.util.List;

import model.TbDocumento;;

public interface IDocumentoable {
	//declaramos sus metodos
	public void RegitrarDocumento(TbDocumento tbdocum);
	public void ActualizarDocumento(TbDocumento tbldocum);
	public void EliminarDocumento(TbDocumento tbldocum);
	public List<TbDocumento>ListadoDocumentos();
	public TbDocumento BuscarDocumento(TbDocumento tbldocum);

} //fin de la interface....