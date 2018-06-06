package bean;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Produto {

	private String cdProduto;
	private String nomeProduto;
	private int qtEstoque;
	private double valor;

	public Produto(String cd, String nome, int qt, double valor) {
		this.cdProduto = cd;
		this.nomeProduto = nome;
		this.qtEstoque = qt;
		this.valor = valor;
	}

	
	
	
	
	public String getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQtEstoque() {
		return qtEstoque;
	}

	public void setQtEstoque(int qtEstoque) {
		this.qtEstoque = qtEstoque;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
