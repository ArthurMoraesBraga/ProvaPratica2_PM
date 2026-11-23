package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;

public abstract class Aluguel {

	private String nomeCliente;
	private int quantidadeDias;
	private double valorTotal;
	private StatusAluguel status;
	private List<Veiculo> veiculos;

	public Aluguel(String nomeCliente, int quantidadeDias,
			double valorTotal, StatusAluguel status) {

		this.nomeCliente = nomeCliente;
		this.quantidadeDias = quantidadeDias;
		this.valorTotal = valorTotal;
		this.status = status;
		this.veiculos = new ArrayList<>();
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getQuantidadeDias() {
		return quantidadeDias;
	}

	public void setQuantidadeDias(int quantidadeDias) {
		this.quantidadeDias = quantidadeDias;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusAluguel getStatus() {
		return status;
	}

	public void setStatus(StatusAluguel status) {
		this.status = status;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void associarVeiculo(Veiculo veiculo) {

		if (veiculo.getStatus() == StatusVeiculo.DISPONIVEL) {
			veiculos.add(veiculo);
			veiculo.setStatus(StatusVeiculo.ALUGADO);
			System.out.println("Veículo associado com sucesso!");
		} else {
			System.out.println("Veículo não está disponível.");
		}
	}

	public abstract void exibirDetalhes();

	public abstract boolean possuiSeguroIncluso();

}