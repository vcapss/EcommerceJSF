package br.com.ecommerce.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="Teste")
@ViewScoped
public class testeBean {
	private String timePreferido;

	public String getTimePreferido() {
		return timePreferido;
	}

	public void setTimePreferido(String timePreferido) {
		this.timePreferido = timePreferido;
	}
	
	public void Testar(){
		if(timePreferido.equals("Corinthians")){
			System.out.println("Foi escolhido o corinthians");
		}else if(timePreferido.equalsIgnoreCase("Palmeiras")){
			System.out.println("Foi escolhido o Palmeiras");
		}else{
			System.out.println("Foi escolhido o S�o Paulo");
		}
	}
}
