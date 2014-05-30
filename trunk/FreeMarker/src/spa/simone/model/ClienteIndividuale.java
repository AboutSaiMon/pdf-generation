package spa.simone.model;

/**
 * @author Simone Spaccarotella {s.spaccarotella@reply.it}
 */
public class ClienteIndividuale extends Cliente {

	private String ragioneSociale = "___";
	private String capitaleSociale = "___";
	private String registroImprese = "___";
	private String codiceFiscale = "___";
	private String partitaIva = "___";
	private String tipoRappresentanza = "___";

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
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
		builder.append(getNome()).append(", Ragione Sociale ");
		builder.append(ragioneSociale).append(" con sede legale in ");
		builder.append(getViaSedeLegale()).append(", ");
		builder.append(getCitt‡SedeLegale()).append(" (");
		builder.append(getProvinciaSedeLegale()).append("), Capitale Sociale di euro ");
		builder.append(capitaleSociale).append(" interamente versato, iscritta al Registro delle imprese di ");
		builder.append(registroImprese).append(", Codice Fiscale n. ");
		builder.append(codiceFiscale).append(", P.IVA n. ");
		builder.append(partitaIva).append(", rappresentata da ");
		builder.append(getRappresentanteLegale()).append(", nella sua qualit‡ di ");
		builder.append(tipoRappresentanza).append(" (di seguito denominata \"Cliente\")");
		return builder.toString();
	}

}