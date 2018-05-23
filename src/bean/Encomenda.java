package bean;

import java.util.ArrayList;

public class Encomenda {
	
	private int idEncomenda;
	private String nomeCliente;
	private String endEntrega;
	private ArrayList<Produto> produtos;
	private double valorTotal;
	
	public Encomenda(String nome, String end, ArrayList<Produto> produtos, double valorTotal) {
		this.nomeCliente = nome;
		this.endEntrega = end;
		this.produtos = produtos;
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

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
