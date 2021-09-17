public class Menu {

    public static void init() {
        System.out.println("SISTEMA DE FOLHA DE PAGAMENTOS");
    }
    
    public static void escolha() {
        System.out.println("[1] - Adicionar empregado");
        System.out.println("[2] - Remover empregado");
        System.out.println("[3] - Lançar cartão de ponto");
        System.out.println("[4] - Lançar Resultado Venda");
        System.out.println("[5] - lançar uma taxa de serviço");
        System.out.println("[6] - Alterar detalhes de um empregado");
        System.out.println("[7] - Listar todos empregados");
        System.out.println("[8] - Rodar folha de pagamento");
        System.out.println("[99] - Sair");
    }

    public static void addName() {
        System.out.println("Digite o nome do empregado:");
    }

    public static void addAddress() {
        System.out.println("Digite o nome do endereço do empregado:");
    }

    public static void tipo_pagamento() {
        System.out.println("Digite a forma de pagamento do funcionario:\n");
        System.out.println("1 - cheque\n2 - em dinheiro\n3 - deposito em conta");
    }

    public static void alert_escolha_invalida() {
        System.out.println("Escolha inválida");
        System.out.println("Digite novamente:");
    }

    public static void empregado_removido() {
        System.out.println("Empregado removido com sucesso!");
    }

    public static void ver_comissao() {
        System.out.println("1 - Comissionado");
        System.out.println("2 - Não comissionado");
    }

    public static void menu_carto_de_ponto () {
        System.out.println("1 - Horario de chegada");
        System.out.println("2 - Horario de saída");
    }

    public static void id() {
        System.out.println("Digite o ID do empregado:");
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.printf("\n");
        }
    }

    public static void salario_horista(){
        System.out.println("Digite o salario por hora:");
    }
	
	public static void salario(){
        System.out.println("Digite o valor do salario:");
    }

    public static void carto_de_ponto_chegada() {
        System.out.println("Digite o horario de chegada:");
    }
    public static void carto_de_ponto_saida() {
        System.out.println("Digite o horario de saída:");
    }
	
	public static void verSindicate() {
		System.out.println("O empregado participa do sindicato?");
		System.out.println("1 - SIM			2 - NÃO");
	}
	
	public static void taxSindicate () {
		System.out.println("Digite o valor da taxa do sindicato:");
	}

    public static void porcentagem_comissao () {
        System.out.println("Digite a porcentagem da comissão:");
    }

    public static void tipoFuncionario() {
        System.out.println("Digite o tipo do funcionario:");
        System.out.println("1 - Assalariado\n2 - Horista\n");
    }

    public static void formaPagamento() {
        System.out.println("Qual a forma de pagamento?");
        System.out.println("1 - Mensal      2 - Semanal");
    }

    public static void semanasPagamento() {
        System.out.println("A cada quantas semanas deseja receber?");
        System.out.println("1 - A cada semana");
        System.out.println("2 - A cada 2 semanas");
        System.out.println("3 - A cada 3 semanas");
    }

    public static void diaSemana() {
        System.out.println("Escolha o dia da semana:");
        System.out.println("2 - Segunda");
        System.out.println("3 - terça");
        System.out.println("4 - Quarta");
        System.out.println("5 - Quinta");
        System.out.println("6 - Sexta");
    }

    public static void dia() {
        System.out.println("Digite o dia:");
    }

    public static void ultimoDia() {
        System.out.println("O pagamento ira ser realizado no ultimo dia do mês?\n1 - SIM\n2 - NÃO");
    }

    public static void inOut() {
        System.out.println("1 - Entrada");
        System.out.println("2 - Saída");
    }

    public static void digitarTaxa() {
        System.out.println("Digite o valor da taxa a ser cobrada:");
    }

    public static void alterarDados() {
        System.out.println("Qual dado você deseja alterar?");
        System.out.println("[1] - Nome");
        System.out.println("[2] - Endereço");
        System.out.println("[3] - Tipo do funcionário");
        System.out.println("[4] - Método de pagamento");
        System.out.println("[5] - Membro do sindicato");
        System.out.println("[6] - Identificação no sindicato");
        System.out.println("[7] - Taxa sindical");
    }

    public static void alterarDadosNome() {
        System.out.println("Digite o novo nome:");
    }

    public static void alterarDadosEndereco() {
        System.out.println("Digite o novo endereço:");
    }

    public static void alterarDadosTipoPagamento() {
        System.out.println("Digite o novo método de pagameto:");
        System.out.println("1 - Assalariado\n2 - Horista\n");
    }

    public static void alterarDadosMetodoPagamento() {
        System.out.println("Digite o novo método de pagameto:");
        System.out.println("1 - Cheque\n2 - Dinheiro\n3 - Depósito");
    }

    public static void alterarDadosSindicato() {
        System.out.println("O funcionário pertence ao sindicato?");
        System.out.println("1 - SIM\n2 - NÃO");
    }

    public static void alterarDadosNovaTaxaSind() {
        System.out.println("Digite a taxa do sindicato:");
    }

    public static void valorVenda() {
        System.out.println("Digite o valor da venda:");
    }

    public static void rmEmpregado() {
        System.out.println("Digite o ID do empregado que deseja remover:");
    }

    public static void userNotFound() {
        System.out.println("Usuário não encontrado");
    }

    public static void alreadyHourly() {
        System.out.println("O usuário já é horista.");
    }

    public static void alreadySalaried() {
        System.out.println("O usuário já é assalariado.");
    }
}
