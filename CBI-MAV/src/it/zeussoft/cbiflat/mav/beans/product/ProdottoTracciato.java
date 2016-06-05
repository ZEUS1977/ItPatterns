package it.zeussoft.cbiflat.mav.beans.product;

import it.zeussoft.cbiflat.mav.beans.CodaEF;
import it.zeussoft.cbiflat.mav.beans.TestaIM;

import java.util.List;

public class ProdottoTracciato {
	
	//rappresent an entore tracciato of a list of mav requests to send to the bank
	//from a single mittente with a unique sia code
	
	private TestaIM tastaIM;
	private List<RecordCodiceFisso> recordCodiciFissiList;
	private CodaEF codaEF;
	
	public TestaIM getTastaIM() {
		return tastaIM;
	}
	public void setTastaIM(TestaIM tastaIM) {
		this.tastaIM = tastaIM;
	}
	public List<RecordCodiceFisso> getRecordCodiciFissiList() {
		return recordCodiciFissiList;
	}
	public void setRecordCodiciFissiList(
			List<RecordCodiceFisso> recordCodiciFissiList) {
		this.recordCodiciFissiList = recordCodiciFissiList;
	}
	public CodaEF getCodaEF() {
		return codaEF;
	}
	public void setCodaEF(CodaEF codaEF) {
		this.codaEF = codaEF;
	}

}
