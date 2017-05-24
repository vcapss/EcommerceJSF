package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Venda;
import br.com.ecommerce.util.JavaUtil;

public class VendaDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public boolean cadastrarGenero(ArrayList<Venda> venda){
    	boolean cadastrado = false;
    	sql = "INSERT INTO PEDIDO VALUES ( NULL, ?, ?, ?, SYSDATE)";
    	connection = Conexao.getConnection();
    	
    	try {
    		p = connection.prepareStatement(sql);
    		for (int i = 0; i < venda.size(); i++) {
				p.setInt(1, venda.get(i).getLivro().getIdLivro());
				p.setString(2, venda.get(i).getPessoa().getCpf());
				p.setDouble(3, venda.get(i).getPrecoTotal());
				p.execute();
			}
    		cadastrado = true;
    		
    	}catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
			JavaUtil.adicionarMensagemErro("Erro ao Cadastrar dados no banco");
		}
    	
    	return cadastrado;
    }
}
