package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		Type type = getType();
		return type.getBotte();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Botte) {
			Botte botte = (Botte)obj; 
			return getType().equals(botte.getType()); 
		}
		return false; 
	}
}
