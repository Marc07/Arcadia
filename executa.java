class Executa{
	private String nome;
	public boolean status;
	public int indice;
	
	public Executa(){
		this.status = false;
	}
	public void setStatus(){
		this.status = false;
	}
	public void setNome(String s){
		this.nome = s;
	}
	public String getNome(){
		return this.nome;
	}
};
