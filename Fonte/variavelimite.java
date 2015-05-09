/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe implementa a Variavel responsável por reduzir uma linha do código fonte ignorando
espaços antes do primeiro caractere alfanumérico e comentários após o caractere de terminação*/
class Variavelimite{
	private String nome;
	public int valor;

	public void setNome(String s){
		this.nome = s;
	}
	public void setValor(int n){
		this.valor = n;
	}
	public String getNome(){
		return this.nome;
	}
	public int getValor(){
		return this.valor;
	}
};
