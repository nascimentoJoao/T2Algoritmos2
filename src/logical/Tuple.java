package logical;

public class Tuple {

	public Integer Tube;
	public Integer Level;

	public Tuple(Integer t, Integer l) {
		this.Tube = t;
		this.Level = l;
	}

	@Override
	public String toString() {
		return "Tube: " + this.Tube + " Level: " + this.Level;
	}

}
