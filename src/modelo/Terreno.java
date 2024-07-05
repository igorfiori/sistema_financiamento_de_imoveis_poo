package modelo;

public class Terreno extends Financiamento {

    // Novo atributo para o tipo de zona do terreno
    private String tipoZona;

    // Construtor que inclui o novo atributo
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    // Método para calcular o pagamento mensal do financiamento para terrenos
    @Override
    public double calcularPagamentoMensal() {

        // Calcula o pagamento mensal com base na taxa de juros e prazo de financiamento da superclasse
        double pagamentoMensal = super.calcularPagamentoMensal();

        // Acrescenta 2% sobre o valor com os juros já incluídos previamente
        pagamentoMensal *= 1.02;

        return pagamentoMensal;
    }

    // Método getter para obter o tipo de zona do terreno
    public String getTipoZona() {
        return tipoZona;
    }

    // Método setter para definir o tipo de zona do terreno
    public void setTipoZona(String tipoZona) {
        this.tipoZona = tipoZona;
    }


}
