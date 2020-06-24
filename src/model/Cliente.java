package model;

public class Cliente {
	protected int id;
	protected String nome;
	protected String email;
	protected float credito;
	public Cliente(int id, String nome, String email, float credito) {
		super();
		if(id == 0 || nome == "" || nome.length() == 0 || email == null || credito <=0) {
			throw new RuntimeException("Os dados não foram preenchidos corretamente ou  credito é negativo");
		}
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.credito = credito;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id == 0) {
			throw new LojaException("ID invalido");
		}
		this.id=id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == null || nome.length() == 0) {
			throw new LojaException("Nome esta vazio");
		}
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email == null ) {
			throw new LojaException("Email esta vazio");
		}
		this.email = email;
	}
	public float getCredito() {
		return credito;
	}
	public void setCredito(float credito) {
		if(credito <= 0) {
			throw new LojaException("Saldo não pode ser vazio ou negativo");
		}
		this.credito = credito;
	}
	
	public boolean fazercompra(float valor) {
		if (valor < this.credito) {
			this.credito -= valor;
			return true;
		}
		else {
			throw new LojaException("Saldo insuficiente para compra");
		}
		
	}
	public boolean quitardivida(float valor) {
			this.credito += valor;
			return true;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", credito=" + credito + "]";
	}
	
}
