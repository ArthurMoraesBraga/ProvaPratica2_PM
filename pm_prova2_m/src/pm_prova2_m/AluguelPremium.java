package pm_prova2_m;

public class AluguelPremium extends Aluguel {

	public AluguelPremium(String nomeCliente, int quantidadeDias,
			double valorTotal, StatusAluguel status) {

		super(nomeCliente, quantidadeDias, valorTotal, status);
	}

	@Override
	public boolean possuiSeguroIncluso() {
		return true;
	}

	@Override
	public void exibirDetalhes() {

		System.out.println("Tipo: Premium");
		System.out.println("Cliente: " + getNomeCliente());
		System.out.println("Dias: " + getQuantidadeDias());
		System.out.println("Valor total: R$ " + getValorTotal());
		System.out.println("Status: " + getStatus());
		System.out.println("Quilometragem: Ilimitada");
		System.out.println("Seguro: Incluso");
		System.out.println("Veículos associados: " + getVeiculos().size());
	}
}
