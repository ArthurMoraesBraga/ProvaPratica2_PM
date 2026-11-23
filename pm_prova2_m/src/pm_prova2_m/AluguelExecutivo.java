package pm_prova2_m;

public class AluguelExecutivo extends Aluguel implements Avaliavel {

	private int nota;

	public AluguelExecutivo(String nomeCliente, int quantidadeDias,
			double valorTotal, StatusAluguel status) {

		super(nomeCliente, quantidadeDias, valorTotal, status);
	}

	@Override
	public void avaliar(int nota) {

		if (nota >= 0 && nota <= 10) {
			this.nota = nota;
			System.out.println("Aluguel executivo avaliado!");
		} else {
			System.out.println("Nota deve estar entre 0 e 10.");
		}
	}

	@Override
	public boolean possuiSeguroIncluso() {
		return false;
	}

	@Override
	public void exibirDetalhes() {

		System.out.println("Tipo: Executivo");
		System.out.println("Cliente: " + getNomeCliente());
		System.out.println("Dias: " + getQuantidadeDias());
		System.out.println("Valor total: R$ " + getValorTotal());
		System.out.println("Status: " + getStatus());
		System.out.println("Quilometragem: Ilimitada");
		System.out.println("Motorista particular: Sim");
		System.out.println("Nota: " + nota);
		System.out.println("Veículos associados: " + getVeiculos().size());
	}
}