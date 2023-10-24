package Interfaces;

import java.util.List;

import model.TblAuto;

public interface IAutoable {
	public void RegitrarAuto(TblAuto tblauto);
	public void ActualizarAuto(TblAuto tblauto);
	public void EliminarAuto(TblAuto tblauto);
	public List<TblAuto>ListadoAuto();
	public TblAuto BuscarAuto(TblAuto tblauto);

}// fin de la interfaz iautoable
