package br.com.ecomerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.ecommerce.conexao.Conexao;
import br.com.ecommerce.modelo.Livro;

public class LivroDAO {
	private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    
    public boolean cadastrarLivro(Livro livro){
    	boolean cadastrou = false;
    	sql = "INSERT INTO LIVRO VALUES ( NULL, ?, NULL, ?, ?, ?, ?)";
    	connection = Conexao.getConnection();
        
        try {
			p = connection.prepareStatement(sql);
			p.setString(1, livro.getTitulo());
			p.setString(2, livro.getDescricao());
			p.setInt(3, livro.getEditora().getIdEditora());
			p.setInt(4, livro.getGenero().getGeneroId());
			p.setInt(5, livro.getAutor().getIdAutor());
			p.execute();
			cadastrou = true;
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    	return cadastrou;
    }
}
