
import java.util.Scanner;
import java.util.LinkedList;

public class addEmployee implements command {
    LinkedList<Horista> Horista = new LinkedList<Horista>();
    LinkedList<Assalariado> Assalariado = new LinkedList<Assalariado>();
    Payment payment;
    Scanner input = new Scanner(System.in);
    id idFunctions = new id();

    addEmployee(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.Horista = listaHorista;
        this.Assalariado = listaAssalariado;
        this.payment = new Payment(listaHorista, listaAssalariado);
    }

    @Override
    public void execute () {
		Menu.tipoFuncionario();
        int tipoFuncionario = input.nextInt();
        input.nextLine();

        if(tipoFuncionario == 1) {
            addAssalariado(idFunctions.getId(), idFunctions.getIdSindicato());
        }
        else if(tipoFuncionario == 2) {
            addHorista(idFunctions.getId(), idFunctions.getIdSindicato());
        }
        idFunctions.incrementId();
        idFunctions.incrementIdSindicato();
	}
    
    public void addHorista (int id, int idSindicato) {
		Horista novoHorista = new Horista();

		Menu.addName();
        novoHorista.nome = input.nextLine();
            
        Menu.addAddress();
        novoHorista.endereco = input.nextLine();

        Menu.salario_horista();
        novoHorista.salario = input.nextDouble();

        Menu.tipo_pagamento();
        novoHorista.tipo_pagamento = input.nextInt();
        input.nextLine();
		
		novoHorista.id = id;

        Menu.verSindicate();
		novoHorista.verSindicate = input.nextInt();
		input.nextLine();
		
		if(novoHorista.verSindicate == 1) {
            novoHorista.idSindicato = idSindicato;

			Menu.taxSindicate();
			novoHorista.taxSindicate = input.nextDouble();
		}
        else {
            novoHorista.idSindicato = -1;
        }

        for (int i = 0; i < 30; i++) {
            novoHorista.employeeTimecard[i] = new Timecard();
        }

        novoHorista.agendaPagamento = payment.formaPagamento();
		
        System.out.printf("O ID do funcionario adicionado é: %d\n", novoHorista.id);


		Horista.add(novoHorista);
	}

    public void addAssalariado (int id, int idSindicato) {
		Assalariado novoAssalariado = new Assalariado();
		
		Menu.addName();
        novoAssalariado.nome = input.nextLine();

        Menu.addAddress();
        novoAssalariado.endereco = input.nextLine();

        Menu.salario();
        novoAssalariado.salario = input.nextDouble();
		
		novoAssalariado.id = id;
		
		Menu.tipo_pagamento();
		novoAssalariado.tipo_pagamento = input.nextInt();
        input.nextLine();

        Menu.ver_comissao();
        novoAssalariado.verComissao = input.nextInt();
        input.nextLine();

        if(novoAssalariado.verComissao == 1) {
            Menu.porcentagem_comissao();
            novoAssalariado.taxaComissao = input.nextDouble();
        }
		Menu.verSindicate();
		novoAssalariado.verSindicate = input.nextInt();
		input.nextLine();
		
		if(novoAssalariado.verSindicate == 1) {
            novoAssalariado.idSindicato = idSindicato;

			Menu.taxSindicate();
			novoAssalariado.taxSindicate = input.nextDouble();
		}
        else {
            novoAssalariado.idSindicato = -1;
        }
		
        novoAssalariado.agendaPagamento = payment.formaPagamento();

        System.out.printf("O ID do funcionario adicionado é: %d\n", novoAssalariado.id);

		Assalariado.add(novoAssalariado);
	}

}
