/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe implementa a Variavel respons�vel por reduzir uma linha do c�digo fonte ignorando
espa�os antes do primeiro caractere alfanum�rico e coment�rios ap�s o caractere de termina��o*/
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
