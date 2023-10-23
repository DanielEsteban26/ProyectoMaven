package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_documento database table.
 * 
 */
@Entity
@Table(name="tb_documento")
@NamedQuery(name="TbDocumento.findAll", query="SELECT t FROM TbDocumento t")
public class TbDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDocumento;

	private String descripciondocument;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nroDocumento;

	private String proveDocument;

	private String rucDocument;

	//bi-directional many-to-one association to TbTipodocumento
	@ManyToOne
	@JoinColumn(name="idtipoDoc")
	private TbTipodocumento tbTipodocumento;

	public TbDocumento() {
	}

	public int getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getDescripciondocument() {
		return this.descripciondocument;
	}

	public void setDescripciondocument(String descripciondocument) {
		this.descripciondocument = descripciondocument;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getProveDocument() {
		return this.proveDocument;
	}

	public void setProveDocument(String proveDocument) {
		this.proveDocument = proveDocument;
	}

	public String getRucDocument() {
		return this.rucDocument;
	}

	public void setRucDocument(String rucDocument) {
		this.rucDocument = rucDocument;
	}

	public TbTipodocumento getTbTipodocumento() {
		return this.tbTipodocumento;
	}

	public void setTbTipodocumento(TbTipodocumento tbTipodocumento) {
		this.tbTipodocumento = tbTipodocumento;
	}

}