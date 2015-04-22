class Declara{
	public static Variavel getVariavel(String nome,Variavel[] seq){
		int aux;
		String test;
		for(aux=0;aux<seq.length;aux++){
			if(seq[aux]!=null){
				test = seq[aux].getNome();
				if(test.compareTo(nome)==0){
					return seq[aux];
				}    
			}
		}                               
		return null;
	}
			                      
	public static void setVariavel(Variavel v,Variavel[] seq){
		int aux;    
		for(aux=0;aux<seq.length;aux++){
			if(seq[aux]==null){
				seq[aux] = v;
				return;
			}
		} 
		return;
	}
	
	public static Variavel[] insere(String s,Variavel[] seq){
		int aux;
		Variavel i;
		i = new Variavel();
		String teste,var=null;
		aux = s.length();
		aux-=1;
		while(aux>0){
			teste = s.substring(aux-1,aux);
			if(teste.compareTo(" ")!=0){
				if(var==null){
					var = teste;
				}else{
					var+=teste;
				}
			}else{
				if(var!=null){
					aux = -1;
				}
			}
			aux--;
		}
		if(Declara.getVariavel(var,seq)==null){
			i.setNome(var);
			Declara.setVariavel(i,seq);
			return seq;
		}else{
			return seq;
		}
	}
};