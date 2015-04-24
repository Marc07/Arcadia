class Agiliza{
	public static String crescente(String s,int i,int aux){
		String teste,var = null;
		while(i<aux){
			teste = s.substring(i,i+1);
			if(teste.compareTo(" ")!=0){
				if(var==null){
					var = teste;
				}else{
					var+=teste;
				}
			}else{
				if(var!=null){
					i = aux;
				}
			}
			i++;
		}
		return var;
	}
	public static String testanum(String s,int i,int aux){
		String teste,var = null;
		while(i<aux){
			teste = s.substring(i,i+1);
			if(((teste.charAt(0) >= 'A') && (teste.charAt(0) <='Z')) || ((teste.charAt(0) >= 'a') && (teste.charAt(0) <='z'))){
				return var;
			}
			i++;
		}
		return s;
	}
	public static String testanome(String s,int i){
		String teste,var = null;
		teste = s.substring(i,i+1);
		if(((teste.charAt(0) >= '0') && (teste.charAt(0) <='9'))){
			return var;
		}else{
			return s;
		}
	}
	public static String decrescente(String s,int i,int aux){
		String teste,var = null;
		while(aux>i){
			teste = s.substring(aux-1,aux);
			if(teste.compareTo(" ")!=0){
				if(var==null){
					var = teste;
				}else{
					teste+=var;
					var = teste;
				}
			}else{
				if(var!=null){
					aux = -1;
				}
			}
			aux--;
		}
		return var;
	}
};
