package pm_prova2_m;

public class Van extends Veiculo implements Avaliavel, Inspecionavel {

	private int quantidadePassageiros;
	private int nota;

	public Van(String placa, String modelo, int anoFabricacao,
			double valorDiaria, double quilometragem,
			StatusVeiculo status, int quantidadePassageiros) {

		super(placa, modelo, anoFabricacao, valorDiaria,
				quilometragem, status);

		this.quantidadePassageiros = quantidadePassageiros;
	}

	@Override
	public void avaliar(int nota) {

		if (nota >= 0 && nota <= 10) {
			this.nota = nota;
			System.out.println("Van avaliada com sucesso!");
		} else {
			System.out.println("Nota deve estar entre 0 e 10.");
		}
	}

	@Override
	public void realizarInspecao() {
		System.out.println("Inspeção da van realizada com sucesso!");
	}

	@Override
	public void exibirDetalhes() {

		System.out.println("Tipo: Van");
		System.out.println("Placa: " + getPlaca());
		System.out.println("Modelo: " + getModelo());
		System.out.println("Ano: " + getAnoFabricacao());
		System.out.println("Diária: R$ " + getValorDiaria());
		System.out.println("Quilometragem: " + getQuilometragem());
		System.out.println("Passageiros: " + quantidadePassageiros);
		System.out.println("Status: " + getStatus());
		System.out.println("Nota: " + nota);
	}

	@Override
	public boolean possuiSeguroEspecial() {
		return false;
	}

}