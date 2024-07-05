package main;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import util.InterfaceUsuario;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;

public class Main {

    public static void main(String[] args) {
        // Utiliza os métodos da classe InterfaceUsuario para ler os dados do financiamento
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Lista para armazenar dados de financiamento no arquivo txt
        ArrayList<String> consoleQuestionsAndAnswers = new ArrayList<>();

        // Solicita o tipo de imóvel desejado
        String tipoImovel = interfaceUsuario.pedirTipoImovel();
        consoleQuestionsAndAnswers.add("Tipo de imóvel escolhido: " + tipoImovel);

        // Solicita os dados comuns do financiamento ao usuário
        double valorImovel = interfaceUsuario.pedirValorImovel();
        consoleQuestionsAndAnswers.add("Valor do imóvel: " + valorImovel);

        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        consoleQuestionsAndAnswers.add("Prazo de financiamento: " + prazoFinanciamento + " anos");

        double taxaJurosAnual = interfaceUsuario.pedirTaxaJuros();
        consoleQuestionsAndAnswers.add("Taxa de juros anual: " + taxaJurosAnual + "%");

        // Variáveis para área construída e tamanho do terreno
        double areaConstruida = 0;
        double tamanhoTerreno = 0;

        // Solicita a área construída e o tamanho do terreno apenas para o tipo de imóvel Casa
        if (tipoImovel.equals("casa")) {
            areaConstruida = interfaceUsuario.pedirAreaConstruida();
            consoleQuestionsAndAnswers.add("Área construída: " + areaConstruida);
            tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();
            consoleQuestionsAndAnswers.add("Tamanho do terreno: " + tamanhoTerreno);
        }

        // Cadastra os financiamentos de acordo com o tipo de imóvel escolhido
        Financiamento financiamento;
        if (tipoImovel.equals("casa")) {
            financiamento = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, tamanhoTerreno);
        } else if (tipoImovel.equals("apartamento")) {
            int numeroVagasGaragem = interfaceUsuario.pedirNumeroVagasGaragem();
            consoleQuestionsAndAnswers.add("Número de vagas na garagem: " + numeroVagasGaragem);
            int numeroAndar = interfaceUsuario.pedirNumeroAndar();
            consoleQuestionsAndAnswers.add("Número do andar: " + numeroAndar);
            financiamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem, numeroAndar);
        } else {
            String tipoZona = interfaceUsuario.pedirTipoZona();
            consoleQuestionsAndAnswers.add("Tipo de zona do terreno: " + tipoZona);
            financiamento = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
        }

        // Adiciona o financiamento à lista
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        financiamentos.add(financiamento);

        // Formatação dos valores decimais
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols); // Define o formato de números com organização decimal

        // Salva os dados dos financiamentos e as perguntas e respostas do console em um arquivo de texto
        salvarFinanciamentos(financiamentos, consoleQuestionsAndAnswers, df);

        // Impressão dos detalhes de cada financiamento
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamentoAtual = financiamentos.get(i);
            System.out.println("Financiamento " + (i + 1) + " - valor do imóvel: R$ " + df.format(financiamentoAtual.getValorImovel()) + ", valor total do financiamento: R$ " + df.format(financiamentoAtual.calcularTotalPagamento()));
            System.out.println(); // Adiciona um espaço em branco após cada impressão
        }

        // Calcula o total de todos os imóveis e o total de todos os financiamentos
        double valorTotalImoveis = financiamentos.stream().mapToDouble(Financiamento::getValorImovel).sum();
        double valorTotalFinanciamentos = financiamentos.stream().mapToDouble(Financiamento::calcularTotalPagamento).sum();

        // Fecha o scanner utilizado para entrada de dados
        interfaceUsuario.fecharScanner();
    }

    // Método para salvar os financiamentos e as perguntas e respostas do console em um arquivo de texto
    private static void salvarFinanciamentos(ArrayList<Financiamento> financiamentos, ArrayList<String> consoleQuestionsAndAnswers, DecimalFormat df) {
        try (FileWriter writer = new FileWriter("salvar_financiamentos.txt")) {
            // Salva as perguntas e respostas do console
            writer.write("Perguntas e Respostas do Console:\n\n");
            for (String questionAndAnswer : consoleQuestionsAndAnswers) {
                writer.write(questionAndAnswer + "\n");
            }
            writer.write("\n");

            // Salva os detalhes de cada financiamento
            for (Financiamento financiamento : financiamentos) {
                if (financiamento instanceof Casa) {
                    Casa casa = (Casa) financiamento;
                    writer.write("Tipo de imóvel: Casa\n");
                    writer.write("Valor do imóvel: R$ " + df.format(casa.getValorImovel()) + "\n");
                    writer.write("Valor do financiamento: R$ " + df.format(financiamento.calcularTotalPagamento()) + "\n\n");
                } else if (financiamento instanceof Apartamento) {
                    Apartamento apartamento = (Apartamento) financiamento;
                    writer.write("Tipo de imóvel: Apartamento\n");
                    writer.write("Valor do imóvel: R$ " + df.format(apartamento.getValorImovel()) + "\n");
                    writer.write("Valor do financiamento: R$ " + df.format(financiamento.calcularTotalPagamento()) + "\n\n");
                } else {
                    Terreno terreno = (Terreno) financiamento;
                    writer.write("Tipo de imóvel: Terreno\n");
                    writer.write("Valor do imóvel: R$ " + df.format(terreno.getValorImovel()) + "\n");
                    writer.write("Valor do financiamento: R$ " + df.format(financiamento.calcularTotalPagamento()) + "\n\n");
                }
            }

            System.out.println("Os dados do financiamento foram salvos em 'salvar_financiamentos.txt'.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados do financiamento: " + e.getMessage());
        }
    }
}
