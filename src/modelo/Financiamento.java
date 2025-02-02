package modelo;

public class Financiamento {

    // Atributos protegidos

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

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
        System.out.println("Dados do Financiamento:");
        System.out.println("Valor do Imóvel: " + valorImovel);
        System.out.println("Prazo do Financiamento: " + prazoFinanciamento + " anos");
        System.out.println("Taxa de Juros Anual: " + taxaJurosAnual + "%");
        System.out.println("Total do Financiamento: " + calcularTotalPagamento());
    }
}
