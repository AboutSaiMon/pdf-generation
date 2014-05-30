package spa.simone.model;

/**
 * @author Simone Spaccarotella {s.spaccarotella@reply.it}
 * 
 */
public class ClienteConsorzio extends Cliente {

	private String repAttoNotarile = "___";
	private String raccAttoNotarile = "___";
	private String dataAttoNotarile = "___";
	private String notaio = "___";

	public String getRepAttoNotarile() {
		return repAttoNotarile;
	}

	public void setRepAttoNotarile(String repAttoNotarile) {
		this.repAttoNotarile = repAttoNotarile;
	}

	public String getRaccAttoNotarile() {
		return raccAttoNotarile;
	}

	public void setRaccAttoNotarile(String raccAttoNotarile) {
		this.raccAttoNotarile = raccAttoNotarile;
	}

	public String getDataAttoNotarile() {
		return dataAttoNotarile;
	}

	public void setDataAttoNotarile(String dataAttoNotarile) {
		this.dataAttoNotarile = dataAttoNotarile;
	}

	public String getNotaio() {
		return notaio;
	}

	public void setNotaio(String notaio) {
		this.notaio = notaio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNome()).append(" con sede legale in ");
		builder.append(getViaSedeLegale()).append(", ");
		builder.append(getCitt‡SedeLegale()).append(" (");
		builder.append(getProvinciaSedeLegale()).append("), costituito con atto notarile rep. ");
		builder.append(repAttoNotarile).append(" racc. ");
		builder.append(raccAttoNotarile).append(" del ");
		builder.append(dataAttoNotarile).append(" presso il notaio Dott. ");
		builder.append(notaio).append(" (di seguito \"CLIENTE\"), rappresentato da ");
		builder
				.append(getRappresentanteLegale())
				.append(
						" nella sua qualit‡ di Presidente che sottoscrive il presente CONTRATTO, anche in nome e per conto delle Imprese consorziate");
		return builder.toString();
	}
}