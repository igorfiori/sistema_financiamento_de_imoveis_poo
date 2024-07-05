import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Método para solicitar ao usuário o valor do imóvel
    public double pedirValorImovel() {
        double valor;
        do {
            System.out.print("Digite o valor do imóvel (deve ser positivo): ");
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("Valor inválido. O valor do imóvel deve ser positivo.");
            }
        } while (valor <= 0);
        return valor;
    }

    // Método para solicitar ao usuário o prazo do financiamento em anos
    public int pedirPrazoFinanciamento() {
        int prazo;
        do {
            System.out.print("Digite o prazo do financiamento em anos (deve ser positivo): ");
            prazo = scanner.nextInt();
            if (prazo <= 0) {
                System.out.println("Valor inválido. O prazo do financiamento deve ser positivo.");
            }
        } while (prazo <= 0);
        return prazo;
    }

    // Método para solicitar ao usuário a taxa de juros anual
    public double pedirTaxaJuros() {
        double taxa;
        do {
            System.out.print("Digite a taxa de juros anual (%) (deve ser positiva): ");
            taxa = scanner.nextDouble();
            if (taxa <= 0) {
                System.out.println("Valor inválido. A taxa de juros anual deve ser positiva.");
            }
        } while (taxa <= 0);
        return taxa;
    }

    // Método para fechar o scanner
    public void fecharScanner() {
        scanner.close();
    }
}
