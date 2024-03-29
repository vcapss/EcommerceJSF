package br.com.ecommerce.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ecomerce.dao.ClienteDAO;
import br.com.ecommerce.modelo.Pessoa;
import br.com.ecommerce.util.JavaUtil;

@ManagedBean(name="Cliente")
@ViewScoped
public class ClienteBean {
	private Pessoa cliente = new Pessoa();

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
	public void cadastrar(){
		ClienteDAO dao = new ClienteDAO();
		boolean cadastrado = dao.cadastrarCliente(cliente);
		if(cadastrado == true){
			cliente = new Pessoa();
			JavaUtil.adicionarMensagemSucesso("Cliente cadastrado com sucesso!");
		}
		else{
			JavaUtil.adicionarMensagemSucesso("Erro ao cadastrar Cliente!");
		}
	}
}
