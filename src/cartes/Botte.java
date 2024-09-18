package cartes;

public class Botte extends Probleme {

	protected Botte(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		Type type = getType();
		return type.getBotte();
	}
}
