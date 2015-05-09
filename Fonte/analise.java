/*Marcelo Norberto
marcelonorberto07@gmail.com
Esta classe elimina espaços antes do primeiro caractere alfanumérico escrito na String linha,
Também testa se a linha do código tem ou não o caractere de terminação*/
class Analise{
	public static Variavelimite[] frase(String linha,Variavelimite[] lim){
		String teste,aux;
		aux = ";";
		int i = 0;
		lim[0].valor=i;
		lim[1].valor=i;
		teste = linha.substring(i,i+1);
		if(teste.compareTo("}")==0){
			lim[0].valor=i;
			lim[1].valor=i+1;
			return lim;
		}
		while((teste.compareTo(aux)!=0 && teste.compareTo("{")!=0) &&i<linha.length()&&teste.compareTo("}")!=0){
			if(teste.compareTo("	")==0 && lim[0].valor==i){
				lim[0].valor++;
			}else if(teste.compareTo(" ")==0 && lim[0].valor==i){
				lim[0].valor++;
			}else if(teste.compareTo("_")==0 && lim[0].valor==i){
				lim[0].valor++;
			}
			if(teste.compareTo("(")==0){
				aux = "{";
			}
			if(teste.compareTo(")")==0){
				aux = ";";
			}
			i++;
			if(i<linha.length()){
				teste = linha.substring(i,i+1);
			}else{
				teste = linha.substring(i,linha.length());
			}
		}
		if(i==linha.length()){
			teste = linha.substring(i-1,i);
			if(teste.compareTo(";")!=0 || teste.compareTo("{")!=0||teste.compareTo("}")!=0){
				lim[1].valor = lim[0].valor-1;
			}
		}else{
			lim[1].valor=i+1;
		}
		return lim;
	}
};
