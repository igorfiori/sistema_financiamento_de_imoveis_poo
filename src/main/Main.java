import java.text.DecimalFormat;

public class Financiamento {

    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Método público para calcular o pagamento mensal do financiamento
    public double calcularPagamentoMensal() {
        return (this.valorImovel /(this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    // Método público para calcular o total do pagamento do financiamento
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    // Getters para os atributos privados
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Método público para exibir os dados do financiamento na tela
    public void mostrarDadosFinanciamento() {
        DecimalFormat df = new DecimalFormat("R$ #,##0.00"); // Define o formato de números com organização decimal e símbolo de moeda
        System.out.println("Dados do Financiamento:");
        System.out.println("Valor do Imóvel: " + df.format(valorImovel));
        System.out.println("Prazo do Financiamento: " + prazoFinanciamento + " anos");
        System.out.println("Taxa de Juros Anual: " + taxaJurosAnual + "%");
        System.out.println("Total do Financiamento: " + df.format(calcularTotalPagamento()));
    }
}
