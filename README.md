# Sistema de Financiamento de Imóveis - Programação Orientada a Objetos POO

Este projeto é um sistema simples para calcular financiamentos de imóveis (casas, apartamentos e terrenos). Ele solicita dados do usuário, calcula os pagamentos mensais e totais, e salva as informações em um arquivo de texto.

## Estrutura do Projeto

- `Main.java`: Ponto de entrada do programa.
- `modelo/`: Contém as classes que representam diferentes tipos de imóveis e a classe base `Financiamento`.
  - `Apartamento.java`
  - `Casa.java`
  - `Financiamento.java`
  - `Terreno.java`
- `util/`: Contém utilitários e exceções usadas pelo programa.
  - `DescontoMaiorDoQueJurosException.java`
  - `InterfaceUsuario.java`

## Funcionalidades

- Solicitação de dados do usuário via console.
- Cálculo de pagamento mensal e total para diferentes tipos de imóveis.
- Validação de entrada do usuário.
- Salvar dados de financiamento e interações do usuário em um arquivo de texto.

## Como Executar

1. Clone o repositório:
    ```bash
    git clone https://github.com/igorfiori/sistema_financiamento_de_imoveis_poo
    ```
2. Compile o projeto:
    ```bash
    javac -d bin src/main/Main.java
    ```
3. Execute o projeto:
    ```bash
    java -cp bin main.Main
    ```

## Exemplo de Uso

Ao executar o programa, você será solicitado a inserir o tipo de imóvel, valor do imóvel, prazo de financiamento, taxa de juros anual e, dependendo do tipo de imóvel, informações adicionais como área construída, tamanho do terreno, número de vagas na garagem, etc. As informações fornecidas serão salvas em um arquivo `salvar_financiamentos.txt`.

## Estrutura das Classes

### `Main.java`

A classe principal que orquestra a interação com o usuário, coleta dados e calcula financiamentos.

### `Financiamento.java`

Classe base para representar um financiamento. Contém métodos para calcular o pagamento mensal e total.

### `Casa.java`, `Apartamento.java`, `Terreno.java`

Classes que herdam de `Financiamento` e representam tipos específicos de imóveis com atributos e cálculos específicos.

### `InterfaceUsuario.java`

Classe que gerencia a interação com o usuário via console.

### `DescontoMaiorDoQueJurosException.java`

Exceção personalizada para validar situações específicas nos cálculos.

