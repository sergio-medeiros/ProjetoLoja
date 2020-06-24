package model;

public class ClienteVip extends Cliente{
	private float creditoespecial;

	public ClienteVip(int id, String nome, String email, float credito, float creditoespecial) {
		super(id, nome, email, credito);
		if(creditoespecial <= 0 ) {
			throw new LojaException("Não tem mais limite");
		}
		this.creditoespecial = creditoespecial;
	}

	public float getCreditoespecial() {
		return creditoespecial;
	}

	public void setCreditoespecial(float creditoespecial) {
		this.creditoespecial = creditoespecial;
	}
	public boolean fazercomprar(float valor) {
		if(valor <= this.creditoespecial + super.credito) {
			super.credito = super.credito - valor;
			return true;
		}
			throw new LojaException("insuficiente para compra");
	}

	@Override
	public String toString() {
		return "ClienteVip [nome=" + nome + ", credito=" + credito + ", creditoespecial=" + creditoespecial +  "]";
	}
	

}
