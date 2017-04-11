package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Autor;
import br.com.ecommerce.modelo.Editora;

public class AutorDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public void cadastrarAutor(Autor autor){
    	sql = "INSERT INTO AUTOR (NOME, ENDERECO, CPF, TELEFONE)"
    			+ " VALUES ( NULL, ?, ?, ?, ?)";
        connection = Conexao.getConnection();
        
        try {
			p = connection.prepareStatement(sql);
			p.setString(1, autor.getNome());
			p.setString(3, autor.getCpf());
			p.setString(2, autor.getEndereco());
			p.setString(4, autor.getTelefone());
			p.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}