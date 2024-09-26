package org.elis.model;

public class Recensione {
	private boolean isRecommended;
	private String testo;
	
	public Recensione(Boolean isRecommended, String testo) {
		this.isRecommended = isRecommended;
		this.testo = testo;
	}

	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}
}