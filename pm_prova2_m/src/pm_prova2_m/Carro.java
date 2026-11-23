package pm_prova2_m;

public class Carro extends Veiculo implements Avaliavel {

	private int quantidadePortas;
	private int nota;

	public Carro(String placa, String modelo, int anoFabricacao,
			double valorDiaria, double quilometragem,
			StatusVeiculo status, int quantidadePortas) {

		super(placa, modelo, anoFabricacao, valorDiaria,
				quilometragem, status);

		this.quantidadePortas = quantidadePortas;
	}

	@Override
	public void avaliar(int nota) {

		if (nota >= 0 && nota <= 10) {
			this.nota = nota;
			System.out.println("Carro avaliado com sucesso!");
		} else {
			System.out.println("Nota deve estar entre 0 e 10.");
		}
	}

	@Override
	public void exibirDetalhes() {

		System.out.println("Tipo: Carro");
		System.out.println("Placa: " + getPlaca());
		System.out.println("Modelo: " + getModelo());
		System.out.println("Ano: " + getAnoFabricacao());
		System.out.println("Diária: R$ " + getValorDiaria());
		System.out.println("Quilometragem: " + getQuilometragem());
		System.out.println("Portas: " + quantidadePortas);
		System.out.println("Status: " + getStatus());
		System.out.println("Nota: " + nota);
	}

	@Override
	public boolean possuiSeguroEspecial() {
		return false;
	}

}