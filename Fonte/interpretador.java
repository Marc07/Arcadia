class Interpretador{
	
	public static Executa[] interpreta(String linha,Executa[] menu){
		String teste,next,prev;
		next = "0";
		int i = 0,aux=-1;
		teste = linha.substring(i,i+1);
		while(i<linha.length()){
			if(teste.compareTo("=")==0){
				next = linha.substring(i+1,i+2);
				prev = linha.substring(i-1,i);
				if(aux==-1){
					aux = i;
				}
				if(prev.compareTo("!")==0){
					menu[3].status = true;
				}else if(prev.compareTo("<")==0){
					menu[3].status = true;
				}else if(prev.compareTo(">")==0){;
					menu[3].status = true;
				}else if(next.compareTo("=")!=0&&prev.compareTo("=")!=0){
					menu[1].status = true;
					menu[1].indice = i;
				}else if(next.compareTo("=")==0||prev.compareTo("=")==0){
					menu[3].status = true;
					if(menu[3].indice == 0){
						menu[3].indice = i;
					}
				}
			}
			if(teste.compareTo("+")==0){
				menu[2].status = true;
				menu[2].indice = i;
			}else if(teste.compareTo("-")==0){
				menu[2].status = true;
				menu[2].indice = i;
			}else if(teste.compareTo("/")==0){
				menu[2].status = true;
				menu[2].indice = i;
			}else if(teste.compareTo("*")==0){
				menu[2].status = true;
				menu[2].indice = i;
			}else if(teste.compareTo("%")==0){
				menu[2].status = true;
				menu[2].indice = i;
			}
			if(teste.compareTo("!")==0){
				next = linha.substring(i+1,i+2);
				if(next.compareTo("=")==0){
					menu[3].status = true;
					menu[3].indice = i;
				}
			}
			if(teste.compareTo(">")==0){
				next = linha.substring(i+1,i+2);
				if(next.compareTo("=")==0){
					menu[3].status = true;
					menu[3].indice = i;
				}
			}
			if(teste.compareTo("<")==0){
				next = linha.substring(i+1,i+2);
				if(next.compareTo("=")==0){
					menu[3].status = true;
					menu[3].indice = i;
				}
			}
			if(teste.compareTo("<")==0){
				menu[3].status = true;
				menu[3].indice = i;
			}
			if(teste.compareTo(">")==0){
				menu[3].status = true;
				menu[3].indice = i;
			}
			i++;
			if(i<linha.length()){
				teste = linha.substring(i,i+1);
			}
			
		}
		if(linha.contains("vars")==true){
			menu[0].status = true;
		}
		if(linha.contains("select")==true){
			menu[5].status = true;
		}
		if(linha.contains("loop")==true){
			menu[4].status = true;
		}
		if(linha.contains("screen")==true){
			menu[1].status = false;
			menu[6].status = true;
		}
		if(linha.contains("screin")==true){
			menu[1].status = false;
			if(menu[6].indice!=aux){
				menu[6].indice = aux;
			}
			menu[6].status = true;
		}
		return menu;
	}
};
