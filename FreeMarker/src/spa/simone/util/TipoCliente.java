package spa.simone.util;

public enum TipoCliente {

	INDIVIDUALE {
		@Override
		public String toString() {
			return "individuale";
		}
	},
	CONSORZIO {
		@Override
		public String toString() {
			return "consorzio";
		}
	},
	GRUPPO {
		@Override
		public String toString() {
			return "gruppo";
		}
	}
	
}