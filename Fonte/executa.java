/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe � usada para o programa principal saber quais m�todos ser�o usados para interpretar cada linha do c�digo fonte*/
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
