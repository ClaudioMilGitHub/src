package org.elis.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LibreriaId {

	@Column(name="utente_id")
	private Long utenteId;
	
	@Column(name="gioco_id")
	private Long giocoId;
	
	public LibreriaId () {}

	
	@Override
	public int hashCode() {
		return Objects.hash(giocoId, utenteId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibreriaId other = (LibreriaId) obj;
		return Objects.equals(giocoId, other.giocoId) && Objects.equals(utenteId, other.utenteId);
	}

	public Long getUtenteId() {
		return utenteId;
	}

	public void setUtenteId(Long utenteId) {
		this.utenteId = utenteId;
	}

	public Long getGiocoId() {
		return giocoId;
	}

	public void setGiocoId(Long giocoId) {
		this.giocoId = giocoId;
	}
}