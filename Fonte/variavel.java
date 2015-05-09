/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe implementa a Variavel principal do programa*/
class Variavel{
	private String nome;
	public double valor;

	public void setNome(String s){
		this.nome = s;
	}
	public void setValor(double n){
		this.valor = n;
	}
	public String getNome(){
		return this.nome;
	}
	public double getValor(){
		return this.valor;
	}
};
