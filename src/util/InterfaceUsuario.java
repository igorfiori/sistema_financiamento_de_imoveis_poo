package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Método para solicitar ao usuário o tipo de imóvel desejado
    public String pedirTipoImovel() {
        String tipoImovel = "";
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite o tipo de imóvel desejado (casa, apartamento ou terreno): ");
                tipoImovel = scanner.nextLine().toLowerCase();
                if (!tipoImovel.equals("casa") && !tipoImovel.equals("apartamento") && !tipoImovel.equals("terreno")) {
                    throw new IllegalArgumentException("Tipo de imóvel inválido. Por favor, digite 'casa', 'apartamento' ou 'terreno'.");
                }
                inputValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!inputValido);
        return tipoImovel;
    }

    // Métodos para solicitar os dados comuns de financiamento
    public double pedirValorImovel() {
        double valor = 0;
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite o valor do imóvel (entre R$250.000,00 e R$5.000.000,00): ");
                valor = scanner.nextDouble();
                if (valor < 250000 || valor > 5000000) {
                    throw new IllegalArgumentException("Valor inválido. O valor do imóvel deve estar entre R$250.000,00 e R$5.000.000,00.");
                }
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!inputValido);
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = 0;
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite o prazo do financiamento em anos (entre 2 e 25 anos): ");
                prazo = scanner.nextInt();
                if (prazo < 2 || prazo > 25) {
                    throw new IllegalArgumentException("Valor inválido. O prazo do financiamento deve estar entre 2 e 25 anos.");
                }
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpa o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!inputValido);
        return prazo;
    }

    public double pedirTaxaJuros() {
        double taxa = 0;
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite a taxa de juros anual (% entre 11% e 12,2%): ");
                taxa = scanner.nextDouble();
                if (taxa < 11 || taxa > 12.2) {
                    throw new IllegalArgumentException("Valor inválido. A taxa de juros anual deve estar entre 11% e 12.2%.");
                }
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!inputValido);
        return taxa;
    }

    // Métodos adicionais para solicitar os dados específicos de cada tipo de imóvel
    public double pedirAreaConstruida() {
        double areaConstruida = 0;
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite a área construída M² do imóvel: ");
                areaConstruida = scanner.nextDouble();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        } while (!inputValido);
        return areaConstruida;
    }

    public double pedirTamanhoTerreno() {
        double tamanhoTerreno = 0;
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite o tamanho do terreno M² do imóvel: ");
                tamanhoTerreno = scanner.nextDouble();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        } while (!inputValido);
        return tamanhoTerreno;
    }

    public int pedirNumeroVagasGaragem() {
        int numeroVagas = 0;
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite o número de vagas na garagem do apartamento (entre 0 e 7): ");
                numeroVagas = scanner.nextInt();
                if (numeroVagas < 0 || numeroVagas > 7) {
                    throw new IllegalArgumentException("Número de vagas inválido. Por favor, digite um valor entre 0 e 7.");
                }
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpa o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!inputValido);
        return numeroVagas;
    }

    public int pedirNumeroAndar() {
        int numeroAndar = 0;
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite o número do andar do apartamento (-1 para subsolo, 1 a 128 para andares): ");
                numeroAndar = scanner.nextInt();
                if (numeroAndar < -1 || numeroAndar > 128) {
                    throw new IllegalArgumentException("Número de andares inválido. Por favor, digite um valor entre -1 e 128.");
                }
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpa o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!inputValido);
        return numeroAndar;
    }

    public String pedirTipoZona() {
        String tipoZona = "";
        boolean inputValido = false;
        do {
            try {
                System.out.print("Digite o tipo de zona do terreno (residencial ou comercial): ");
                tipoZona = scanner.next().toLowerCase();
                if (!tipoZona.equals("residencial") && !tipoZona.equals("comercial")) {
                    throw new IllegalArgumentException("Tipo de zona inválido. Por favor, digite 'residencial' ou 'comercial'.");
                }
                inputValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!inputValido);
        return tipoZona;
    }

    // Método para fechar o scanner
    public void fecharScanner() {
        scanner.close();
    }
}
