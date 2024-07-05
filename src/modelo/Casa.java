package modelo;

import util.DescontoMaiorDoQueJurosException;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    private void validarMaiorQueJuros(double valorJuros, double valorDesconto) throws DescontoMaiorDoQueJurosException {
        if (valorDesconto > valorJuros) {
            throw new DescontoMaiorDoQueJurosException("O valor do desconto é maior do que o valor dos juros da mensalidade.");
        }
    }

    // Método público para calcular o pagamento mensal do financiamento + Taxa R$80,00
    public double calcularPagamentoMensal() {

        // Calcula o valor dos juros da mensalidade
        double valorJuros = super.calcularPagamentoMensal();

        // Calcula o valor do pagamento mensal com o acréscimo de R$80
        double valorMensal = valorJuros + 80;
        try {

            // Valida se o valor do acréscimo é maior do que o valor dos juros
            validarMaiorQueJuros(valorJuros, 80);

        } catch (DescontoMaiorDoQueJurosException e) {
            System.out.println("Erro ao calcular o pagamento mensal: " + e.getMessage());

        }
        return valorMensal;
    }

    public double getareaConstruida() {
        return areaConstruida;
    }

    public double gettamanhoTerreno() {
        return tamanhoTerreno;
    }
}
