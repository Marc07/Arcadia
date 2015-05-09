/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe é usada para o programa principal saber quais métodos serão usados para interpretar cada linha do código fonte*/
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
