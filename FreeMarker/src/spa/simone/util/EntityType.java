package spa.simone.util;

public enum EntityType {

	TIPO_CLIENTE {
		@Override
		public String toString() {
			return "tipoCliente";
		}
	},
	FASCIA {
		@Override
		public String toString() {
			return "fascia";
		}
	},
	ILLUMINAZIONE_PUBBLICA {
		@Override
		public String toString() {
			return "illuminazionePubblica";
		}
	},
	CLIENTE_BEAN {
		@Override
		public String toString() {
			return "cliente";
		}
	}
	
}