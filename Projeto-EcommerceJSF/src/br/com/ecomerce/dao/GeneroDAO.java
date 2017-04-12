package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Genero;
import br.com.ecommerce.util.JavaUtil;

public class GeneroDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public boolean cadastrarGenero(Genero genero){
    	boolean cadastrado = false;
    	sql = "INSERT INTO GENERO VALUES ( NULL, ?)";
        connection = Conexao.getConnection();
        
        try {
			p = connection.prepareStatement(sql);
			p.setString(1, genero.getNome());
			p.execute();
			cadastrado = true;
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
			JavaUtil.adicionarMensagemErro("Erro ao Cadastrar dados no banco");
		}
        return cadastrado;
    }
}
