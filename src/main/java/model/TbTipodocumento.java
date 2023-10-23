package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipodocumento database table.
 * 
 */
@Entity
@Table(name="tb_tipodocumento")
@NamedQuery(name="TbTipodocumento.findAll", query="SELECT t FROM TbTipodocumento t")
public class TbTipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtipoDoc;

	private String descripcion;

	private String nomdocu;

	//bi-directional many-to-one association to TbDocumento
	@OneToMany(mappedBy="tbTipodocumento")
	private List<TbDocumento> tbDocumentos;

	public TbTipodocumento() {
	}

	public int getIdtipoDoc() {
		return this.idtipoDoc;
	}

	public void setIdtipoDoc(int idtipoDoc) {
		this.idtipoDoc = idtipoDoc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNomdocu() {
		return this.nomdocu;
	}

	public void setNomdocu(String nomdocu) {
		this.nomdocu = nomdocu;
	}

	public List<TbDocumento> getTbDocumentos() {
		return this.tbDocumentos;
	}

	public void setTbDocumentos(List<TbDocumento> tbDocumentos) {
		this.tbDocumentos = tbDocumentos;
	}

	public TbDocumento addTbDocumento(TbDocumento tbDocumento) {
		getTbDocumentos().add(tbDocumento);
		tbDocumento.setTbTipodocumento(this);

		return tbDocumento;
	}

	public TbDocumento removeTbDocumento(TbDocumento tbDocumento) {
		getTbDocumentos().remove(tbDocumento);
		tbDocumento.setTbTipodocumento(null);

		return tbDocumento;
	}

}