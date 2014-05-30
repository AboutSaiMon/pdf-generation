package spa.simone.model;

/**
 * @author Simone Spaccarotella {s.spaccarotella@reply.it}
 * 
 */
public abstract class Cliente {

	private String nome = "___";
	private String viaSedeLegale = "___";
	private String citt‡SedeLegale = "___";
	private String provinciaSedeLegale = "___";
	private String rappresentanteLegale = "___";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getViaSedeLegale() {
		return viaSedeLegale;
	}

	public void setViaSedeLegale(String viaSedeLegale) {
		this.viaSedeLegale = viaSedeLegale;
	}

	public String getCitt‡SedeLegale() {
		return citt‡SedeLegale;
	}

	public void setCitt‡SedeLegale(String citt‡SedeLegale) {
		this.citt‡SedeLegale = citt‡SedeLegale;
	}

	public String getProvinciaSedeLegale() {
		return provinciaSedeLegale;
	}

	public void setProvinciaSedeLegale(String provinciaSedeLegale) {
		this.provinciaSedeLegale = provinciaSedeLegale;
	}

	public String getRappresentanteLegale() {
		return rappresentanteLegale;
	}

	public void setRappresentanteLegale(String rappresentanteLegale) {
		this.rappresentanteLegale = rappresentanteLegale;
	}

}