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
        double taxaMensal = taxaJurosAnual / 12 / 100; // Convertendo a taxa anual para mensal
        int totalMeses = prazoFinanciamento * 12;
        return (valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -totalMeses));
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
