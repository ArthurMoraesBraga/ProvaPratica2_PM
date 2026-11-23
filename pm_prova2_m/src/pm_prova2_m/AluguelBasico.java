package pm_prova2_m;

public class AluguelBasico extends Aluguel {

	public AluguelBasico(String nomeCliente, int quantidadeDias,
			double valorTotal, StatusAluguel status) {

		super(nomeCliente, quantidadeDias, valorTotal, status);
	}

	@Override
	public boolean possuiSeguroIncluso() {
		return false;
	}

	@Override
	public void exibirDetalhes() {

		System.out.println("Tipo: Básico");
		System.out.println("Cliente: " + getNomeCliente());
		System.out.println("Dias: " + getQuantidadeDias());
		System.out.println("Valor total: R$ " + getValorTotal());
		System.out.println("Status: " + getStatus());
		System.out.println("Limite: 100 km por dia");
		System.out.println("Seguro: Não incluso");
		System.out.println("Veículos associados: " + getVeiculos().size());
	}
}