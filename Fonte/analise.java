class Analise{

	public static Variavelimite[] frase(String linha,Variavelimite[] lim){
		String teste,aux;
		aux = ";";
		int i = 0;
		teste = linha.substring(i,i+1);
		while((teste.compareTo(aux)!=0 && teste.compareTo("{")!=0) && i<linha.length()){
			if(teste.compareTo(" ")==0 && lim[0].valor==i){
				lim[0].valor++;
			}else if(teste.compareTo("	")==0 && lim[0].valor==i){
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
			if(teste.compareTo(";")!=0 || teste.compareTo("{")!=0){
				lim[1].valor = lim[0].valor-1;
			}
		}else{
			lim[1].valor=i+1;
		}
		return lim;
	}
};
