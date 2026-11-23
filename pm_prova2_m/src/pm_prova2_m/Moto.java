package pm_prova2_m;

public class Moto extends Veiculo implements Inspecionavel {

	private int cilindrada;

	public Moto(String placa, String modelo, int anoFabricacao,
			double valorDiaria, double quilometragem,
			StatusVeiculo status, int cilindrada) {

		super(placa, modelo, anoFabricacao, valorDiaria,
				quilometragem, status);

		this.cilindrada = cilindrada;
	}

	@Override
	public void realizarInspecao() {
		System.out.println("Inspeção da moto realizada com sucesso!");
	}

	@Override
	public void exibirDetalhes() {

		System.out.println("Tipo: Moto");
		System.out.println("Placa: " + getPlaca());
		System.out.println("Modelo: " + getModelo());
		System.out.println("Ano: " + getAnoFabricacao());
		System.out.println("Diária: R$ " + getValorDiaria());
		System.out.println("Quilometragem: " + getQuilometragem());
		System.out.println("Cilindrada: " + cilindrada + " cc");
		System.out.println("Status: " + getStatus());
	}

	@Override
	public boolean possuiSeguroEspecial() {
		return false;
	}

}