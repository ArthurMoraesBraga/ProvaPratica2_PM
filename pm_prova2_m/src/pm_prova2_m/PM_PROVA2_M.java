package pm_prova2_m;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PM_PROVA2_M {

	private static Scanner entrada = new Scanner(System.in);

	private static List<Veiculo> veiculos = new ArrayList<>();
	private static List<Aluguel> alugueis = new ArrayList<>();

	public static void main(String[] args) {

		criarDadosIniciais();

		int opcao;

		do {

			System.out.println("\n===== SISTEMA DE ALUGUEL DE VEÍCULOS =====");
			System.out.println("1 - Associar veículo a um aluguel");
			System.out.println("2 - Exibir todos os veículos");
			System.out.println("3 - Exibir todos os aluguéis");
			System.out.println("4 - Exibir veículos disponíveis");
			System.out.println("5 - Avaliar objeto");
			System.out.println("6 - Realizar inspeção");
			System.out.println("7 - Remover veículos em manutenção");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");

			opcao = Integer.parseInt(entrada.nextLine());

			switch (opcao) {

				case 1:
					associarVeiculo();
					break;

				case 2:
					exibirVeiculos();
					break;

				case 3:
					exibirAlugueis();
					break;

				case 4:
					exibirDisponiveis();
					break;

				case 5:
					avaliarObjeto();
					break;

				case 6:
					realizarInspecao();
					break;

				case 7:
					removerManutencao();
					break;

				case 0:
					System.out.println("Sistema encerrado!");
					break;

				default:
					System.out.println("Opção inválida!");
			}

		} while (opcao != 0);

		entrada.close();
	}

	// Criação dos dados iniciais
	public static void criarDadosIniciais() {

		veiculos.add(new Carro(
				"ABC1234", "Honda Civic", 2022,
				150.00, 25000, StatusVeiculo.DISPONIVEL, 4
		));

		veiculos.add(new Moto(
				"DEF5678", "Honda CG 160", 2023,
				80.00, 12000, StatusVeiculo.DISPONIVEL, 160
		));

		veiculos.add(new Van(
				"GHI9012", "Mercedes Sprinter", 2021,
				250.00, 40000, StatusVeiculo.MANUTENCAO, 15
		));

		alugueis.add(new AluguelBasico(
				"João", 5, 750.00, StatusAluguel.ATIVO
		));

		alugueis.add(new AluguelPremium(
				"Maria", 7, 1800.00, StatusAluguel.ATIVO
		));

		System.out.println("Dados iniciais cadastrados!");
	}

	// 1 - Associar veículos
	public static void associarVeiculo() {

		if (veiculos.isEmpty() || alugueis.isEmpty()) {
			System.out.println("Não existem veículos ou aluguéis.");
			return;
		}

		System.out.println("\n===== VEÍCULOS =====");

		for (int i = 0; i < veiculos.size(); i++) {
			System.out.println(i + " - " + veiculos.get(i).getModelo()
					+ " | " + veiculos.get(i).getPlaca());
		}

		System.out.print("Digite o índice do veículo: ");
		int indiceVeiculo = Integer.parseInt(entrada.nextLine());

		if (indiceVeiculo < 0 || indiceVeiculo >= veiculos.size()) {
			System.out.println("Veículo inválido!");
			return;
		}

		System.out.println("\n===== ALUGUÉIS =====");

		for (int i = 0; i < alugueis.size(); i++) {
			System.out.println(i + " - " + alugueis.get(i).getNomeCliente());
		}

		System.out.print("Digite o índice do aluguel: ");
		int indiceAluguel = Integer.parseInt(entrada.nextLine());

		if (indiceAluguel < 0 || indiceAluguel >= alugueis.size()) {
			System.out.println("Aluguel inválido!");
			return;
		}

		alugueis.get(indiceAluguel).associarVeiculo(
				veiculos.get(indiceVeiculo)
		);
	}

	// 2 - Exibir todos os veículos
	public static void exibirVeiculos() {

		System.out.println("\n===== TODOS OS VEÍCULOS =====");

		for (Veiculo veiculo : veiculos) {
			veiculo.exibirDetalhes();
			System.out.println("-------------------------");
		}
	}

	// 3 - Exibir todos os aluguéis
	public static void exibirAlugueis() {

		System.out.println("\n===== TODOS OS ALUGUÉIS =====");

		for (Aluguel aluguel : alugueis) {

			aluguel.exibirDetalhes();

			System.out.println("Veículos:");

			for (Veiculo veiculo : aluguel.getVeiculos()) {
				System.out.println("- " + veiculo.getModelo());
			}

			System.out.println("-------------------------");
		}
	}

	// 4 - Exibir veículos disponíveis
	public static void exibirDisponiveis() {

		System.out.println("\n===== VEÍCULOS DISPONÍVEIS =====");

		for (Veiculo veiculo : veiculos) {

			if (veiculo.getStatus() == StatusVeiculo.DISPONIVEL) {
				veiculo.exibirDetalhes();
				System.out.println("-------------------------");
			}
		}
	}

	// 5 - Avaliar objetos
	public static void avaliarObjeto() {

		List<Avaliavel> avaliaveis = new ArrayList<>();
		List<String> nomes = new ArrayList<>();

		for (Veiculo veiculo : veiculos) {

			if (veiculo instanceof Avaliavel) {
				avaliaveis.add((Avaliavel) veiculo);
				nomes.add(veiculo.getModelo());
			}
		}

		for (Aluguel aluguel : alugueis) {

			if (aluguel instanceof Avaliavel) {
				avaliaveis.add((Avaliavel) aluguel);
				nomes.add("Aluguel de " + aluguel.getNomeCliente());
			}
		}

		if (avaliaveis.isEmpty()) {
			System.out.println("Nenhum objeto pode ser avaliado.");
			return;
		}

		System.out.println("\n===== OBJETOS AVALIÁVEIS =====");

		for (int i = 0; i < avaliaveis.size(); i++) {
			System.out.println(i + " - " + nomes.get(i));
		}

		System.out.print("Escolha o objeto: ");
		int indice = Integer.parseInt(entrada.nextLine());

		if (indice < 0 || indice >= avaliaveis.size()) {
			System.out.println("Índice inválido!");
			return;
		}

		System.out.print("Digite a nota (0 a 10): ");
		int nota = Integer.parseInt(entrada.nextLine());

		avaliaveis.get(indice).avaliar(nota);
	}

	// 6 - Realizar inspeção
	public static void realizarInspecao() {

		List<Inspecionavel> inspecionaveis = new ArrayList<>();
		List<String> nomes = new ArrayList<>();

		for (Veiculo veiculo : veiculos) {

			if (veiculo instanceof Inspecionavel) {
				inspecionaveis.add((Inspecionavel) veiculo);
				nomes.add(veiculo.getModelo());
			}
		}

		if (inspecionaveis.isEmpty()) {
			System.out.println("Nenhum veículo precisa de inspeção.");
			return;
		}

		System.out.println("\n===== VEÍCULOS INSPECIONÁVEIS =====");

		for (int i = 0; i < inspecionaveis.size(); i++) {
			System.out.println(i + " - " + nomes.get(i));
		}

		System.out.print("Escolha o veículo: ");
		int indice = Integer.parseInt(entrada.nextLine());

		if (indice < 0 || indice >= inspecionaveis.size()) {
			System.out.println("Índice inválido!");
			return;
		}

		inspecionaveis.get(indice).realizarInspecao();
	}

	// 7 - Remover veículos em manutenção
	public static void removerManutencao() {

		boolean removido = veiculos.removeIf(
				veiculo -> veiculo.getStatus() == StatusVeiculo.MANUTENCAO
		);

		if (removido) {
			System.out.println("Veículos em manutenção removidos!");
		} else {
			System.out.println("Nenhum veículo em manutenção encontrado.");
		}
	}

}