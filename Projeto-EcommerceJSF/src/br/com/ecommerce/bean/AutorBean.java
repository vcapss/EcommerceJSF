package br.com.ecommerce.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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
			listaAutor = dao.listarAutor();
			autor = new Autor();
			JavaUtil.adicionarMensagemSucesso("Autor cadastrado com sucesso!");
		}
		else{
			JavaUtil.adicionarMensagemErro("Erro ao cadastrar Autor");
		}
	}
	
	public void excluir(ActionEvent evento){
		autor = (Autor) evento.getComponent().getAttributes().get("autorSelecionado");
		AutorDAO dao = new AutorDAO();
		dao.excluir(autor);
		listaAutor = dao.listarAutor();
		
		JavaUtil.adicionarMensagemSucesso("Autor exclu�do com sucesso!");
	}
	
	public void editar(ActionEvent evento){
		autor = (Autor) evento.getComponent().getAttributes().get("autorSelecionado");
		
	}
	
	public void alterar(){
		AutorDAO dao = new AutorDAO();
		boolean alterado = dao.editar(autor);
		if(alterado == true){
			listaAutor = dao.listarAutor();
			autor = new Autor();
			JavaUtil.adicionarMensagemSucesso("Autor alterado com sucesso!");
		}
		else{
			JavaUtil.adicionarMensagemSucesso("Erro ao editar banco");
		}
		
	}
	
}

