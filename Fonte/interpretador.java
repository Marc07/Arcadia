class Interpretador{
	
	public static Executa[] interpreta(String linha,Executa[] menu){
		String teste,aux,comp;
		aux = "0";
		int i = 0;
		teste = linha.substring(i,i+1);
		while(i<linha.length()){
			if(teste.compareTo("=")==0){
				aux = linha.substring(i+1,i+2);
				comp = linha.substring(i-1,i);
				if(aux.compareTo("=")==0||comp.compareTo("!")==0){
					menu[3].status = true;
					menu[3].indice = i;
				}else if(aux.compareTo("=")!=0&&comp.compareTo("=")!=0){
					menu[1].status = true;
					menu[1].indice = i;
				}else if(comp.compareTo("<")==0){
					menu[3].status = true;
					menu[3].indice = i;
				}else if(comp.compareTo(">")==0){
					menu[3].status = true;
					menu[3].indice = i;
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
				aux = linha.substring(i+1,i+2);
				if(aux.compareTo("=")==0){
					menu[3].status = true;
					menu[3].indice = i;
				}
			}
			if(teste.compareTo(">")==0){
				aux = linha.substring(i+1,i+2);
				if(aux.compareTo("=")==0){
					menu[3].status = true;
					menu[3].indice = i;
				}
			}
			if(teste.compareTo("<")==0){
				aux = linha.substring(i+1,i+2);
				if(aux.compareTo("=")==0){
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
			if(teste.compareTo("#")==0){
				for(i=0;i<menu.length;i++){
					menu[i].setStatus();
				}
				return menu;
			}
			i++;
			if(i<linha.length()){
				teste = linha.substring(i,i+1);
			}
			
		}
		aux = "0";
		for(i=0;i<menu.length;i++){
			if(menu[i].status==true){
				aux = aux+"1";
			}else {
				aux = aux+"0";
			}
		}
		if(aux.compareTo("00000")==0){
			menu[0].status = true;
		}
		if(linha.contains("vars")==true){
			menu[0].status = true;
		}
		return menu;
	}
};
