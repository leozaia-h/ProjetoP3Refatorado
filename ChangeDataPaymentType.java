
import java.util.Scanner;
import java.util.LinkedList;

public class ChangeDataPaymentType implements command{
    LinkedList<Horista> listaHorista = new LinkedList<Horista>();
    LinkedList<Assalariado> listaAssalariado = new LinkedList<Assalariado>();
    Scanner input = new Scanner(System.in);
    id idFunctions = new id();
    Horista horista = new Horista();
    Assalariado assalariado = new Assalariado();
    SearchEmployee searchEmployee;
    Payment payment;
    removeEmployee remove;

    ChangeDataPaymentType(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.listaHorista = listaHorista;
        this.listaAssalariado = listaAssalariado;
        this.payment = new Payment(listaHorista, listaAssalariado);
        this.searchEmployee = new SearchEmployee(listaHorista, listaAssalariado);
        this.remove = new removeEmployee(listaHorista, listaAssalariado);
    }

    @Override
    public void execute () {
        Menu.id();
        int idChange = input.nextInt();
        input.nextLine();

        Menu.alterarDadosTipoPagamento();
        int escolhaTipoEmpregado = input.nextInt();
        input.nextLine();

        Horista horista = searchEmployee.procurarHorista(idChange);
        Assalariado assalariado = searchEmployee.procurarAssalariado(idChange);

        if(escolhaTipoEmpregado == 1) {
            if(horista != null) {
                alterarPagamentoAssalariado(horista);
                remove.removerHorista(idChange);
            }
            else {
                Menu.alreadySalaried();
            }
        }
        else if(escolhaTipoEmpregado == 2) {
            if(assalariado != null) {
                alterarPagamentoHorista(assalariado);
                remove.removerAssalariado(idChange);
            }
            else {
                Menu.alreadyHourly();
            }
        }
	}

    public void changeEmployeeBasicData(Funcionario f, Funcionario newF) {
        newF.nome = f.nome;
        newF.endereco = f.endereco;
		newF.id = f.id;
        newF.idSindicato = f.idSindicato;
        newF.verSindicate = f.verSindicate;
		newF.taxSindicate = f.taxSindicate;
		newF.tipo_pagamento = f.tipo_pagamento;
        newF.taxa_servico = 0;
    }

    public void alterarPagamentoAssalariado(Horista h) {
        Assalariado novoAssalariado = new Assalariado();
		
        changeEmployeeBasicData(h, novoAssalariado);

        novoAssalariado.valor_vendas = 0;

        Menu.salario();
        novoAssalariado.salario = input.nextDouble();
        Menu.ver_comissao();
        novoAssalariado.verComissao = input.nextInt();
        input.nextLine();
        if(novoAssalariado.verComissao == 1) {
            Menu.digitarTaxa();
            novoAssalariado.taxaComissao = input.nextDouble();
        }

        novoAssalariado.agendaPagamento = payment.formaPagamento();

		listaAssalariado.add(novoAssalariado);
    }

    public void alterarPagamentoHorista(Assalariado a) {
        Horista novoHorista = new Horista();

        changeEmployeeBasicData(a, novoHorista);

        Menu.salario();
        novoHorista.salario = input.nextDouble();

        for (int i = 0; i < 30; i++) {
            novoHorista.employeeTimecard[i] = new Timecard();
        }

        novoHorista.agendaPagamento = payment.formaPagamento();
		
		listaHorista.add(novoHorista);
    }
}