package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Encomenda {
	
	private int idEncomenda;
	private String nomeCliente;
	private String endEntrega;
	private Produto produto;
	private double valorTotal;
	
	public Encomenda(String nome, String end, Produto produtos, double valorTotal) {
		this.nomeCliente = nome;
		this.endEntrega = end;
		this.produto = produtos;
		this.valorTotal = valorTotal;
	}
	
	

	public int getIdEncomenda() {
		return idEncomenda;
	}

	public void setIdEncomenda(int idEncomenda) {
		this.idEncomenda = idEncomenda;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEndEntrega() {
		return endEntrega;
	}

	public void setEndEntrega(String endEntrega) {
		this.endEntrega = endEntrega;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
