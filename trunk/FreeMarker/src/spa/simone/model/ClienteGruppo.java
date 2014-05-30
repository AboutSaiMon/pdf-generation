package spa.simone.model;

/**
 * @author Simone Spaccarotella {s.spaccarotella@reply.it}
 * 
 */
public class ClienteGruppo extends Cliente {
	
	private String gruppo = "___";
	private String capitaleSociale = "___";
	private String registroImprese = "___";
	private String codiceFiscale = "___";
	private String partitaIva = "___";
	private String tipoRappresentanza = "___";

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	public String getCapitaleSociale() {
		return capitaleSociale;
	}

	public void setCapitaleSociale(String capitaleSociale) {
		this.capitaleSociale = capitaleSociale;
	}

	public String getRegistroImprese() {
		return registroImprese;
	}

	public void setRegistroImprese(String registroImprese) {
		this.registroImprese = registroImprese;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getTipoRappresentanza() {
		return tipoRappresentanza;
	}

	public void setTipoRappresentanza(String tipoRappresentanza) {
		this.tipoRappresentanza = tipoRappresentanza;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNome()).append(", società facente parte del Gruppo \"");
		builder.append(gruppo).append("\" con sede legale in ");
		builder.append(getViaSedeLegale()).append(", ");
		builder.append(getCittàSedeLegale()).append(" (");
		builder.append(getProvinciaSedeLegale()).append(", Capitale Sociale in euro ");
		builder.append(capitaleSociale).append(" interamente versato, iscritta al Registro delle Imprese di ");
		builder.append(registroImprese).append(", Codice Fiscale n. ");
		builder.append(codiceFiscale).append(", P.IVA n. ");
		builder.append(partitaIva).append(", rappresentata da ");
		builder.append(getRappresentanteLegale()).append(", nella sua qualità di ");
		builder
				.append(tipoRappresentanza)
				.append(
						" (di seguito denominata \"CLIENTE\") che interviene nel presente contratto sia in proprio che in favore delle società facenti parte del suddetto Gruppo, in virtù di apposito mandato alla stessa conferito");
		return builder.toString();
	}

}