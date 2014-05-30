package spa.simone.util;

public enum Fascia {

	MONO {
		@Override
		public String toString() {
			return "mono";
		}
	},
	POP {
		@Override
		public String toString() {
			return "pop";
		}
	},
	FA {
		@Override
		public String toString() {
			return "fa";
		}
	},
	ORARIA {
		@Override
		public String toString() {
			return "oraria";
		}
	}
	
}