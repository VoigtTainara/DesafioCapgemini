package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Anuncio;

public class AnuncioDAO {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastroAnuncios","root","root");
		} catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	/* SQL para criação do banco, e da tabela:
	  
	  create database cadastroAnuncios;
	  use cadastroAnuncios; 
	  
	 CREATE TABLE `anuncio` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nomeAnuncio` INT NOT NULL,
	`DataInicio` VARCHAR(100) NOT NULL,
	`dataTermino` VARCHAR(100) NOT NULL,
	`investimento` DOUBLE NOT NULL
	 PRIMARY KEY (`id`)
	 );
		
		*/
	
	
	public int salvar(Anuncio a) {
		int statusDaInclusao = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps= (PreparedStatement) con.prepareStatement("insert into anuncio"
					+ "(nomeAnuncio, cliente, dataInicio, dataTermino, investimento)"
					+ "values (?,?,?,?,?)");
			ps.setString(1, a.getNomeAnuncio());
			ps.setString(2, a.getCliente());
			ps.setString(3, a.getDataInicio());
			ps.setString(4, a.getDataTermino());
			ps.setDouble(5, a.getInvestimento());
			statusDaInclusao = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return statusDaInclusao;
	}
	
	public List<Anuncio> buscarPorNome(String nome) {
		List<Anuncio> lista = new ArrayList<Anuncio>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from anuncio where cliente=?");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				Anuncio a = new Anuncio();
				a.setId(rs.getInt("id"));
				a.setNomeAnuncio(rs.getString("nomeAnuncio"));
				a.setCliente(rs.getString("cliente"));
				a.setDataInicio(rs.getString("dataInicio"));
				a.setDataTermino(rs.getString("dataTermino"));
				a.setInvestimento(rs.getDouble("investimento"));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return lista;
	}
	
	public List<Anuncio> buscarPorIntervaloTempo(String dataInicio, String dataTermino) {
		List<Anuncio> lista = new ArrayList<Anuncio>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from anuncio where dataInicio>=?"
					+ "and dataTermino<=?");
			ps.setString(1, dataInicio);
			ps.setString(2, dataTermino);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				Anuncio a = new Anuncio();
				a.setId(rs.getInt("id"));
				a.setNomeAnuncio(rs.getString("nomeAnuncio"));
				a.setCliente(rs.getString("cliente"));
				a.setDataInicio(rs.getString("dataInicio"));
				a.setDataTermino(rs.getString("dataTermino"));
				a.setInvestimento(rs.getDouble("investimento"));
				lista.add(a);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return lista;
	}
}
