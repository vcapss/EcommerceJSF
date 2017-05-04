package br.com.ecommerce.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.dao.AutorDAO;
import br.com.ecommerce.modelo.Autor;
import br.com.ecommerce.util.JavaUtil;

@ManagedBean(name="Autor")
@ViewScoped
public class AutorBean{
	private Autor autor = new Autor();
	private List<Autor> listaAutor;
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public List<Autor> getListaAutor() {
		return listaAutor;
	}
	
	public void setListaAutor(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}
	
	@PostConstruct
	public void listar(){
		AutorDAO autor = new AutorDAO();
		listaAutor = autor.listarAutor();
	}

	public void cadastrar(){
		AutorDAO dao = new AutorDAO();
		boolean cadastrado = dao.cadastrarAutor(autor);
		if(cadastrado == true){
			JavaUtil.adicionarMensagemSucesso("Autor cadastrado com sucesso!");
		}
	}
	
}

