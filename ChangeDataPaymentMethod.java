
import java.util.Scanner;
import java.util.LinkedList;

public class ChangeDataPaymentMethod implements command{
    LinkedList<Horista> listaHorista = new LinkedList<Horista>();
    LinkedList<Assalariado> listaAssalariado = new LinkedList<Assalariado>();
    Scanner input = new Scanner(System.in);
    id idFunctions = new id();
    Horista horista = new Horista();
    Assalariado assalariado = new Assalariado();
    SearchEmployee searchEmployee;

    ChangeDataPaymentMethod(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.listaHorista = listaHorista;
        this.listaAssalariado = listaAssalariado;
        this.searchEmployee = new SearchEmployee(listaHorista, listaAssalariado);
    }

    @Override
    public void execute () {
        Menu.id();
        int idChange = input.nextInt();
        input.nextLine();

        horista = searchEmployee.procurarHorista(idChange);
        assalariado = searchEmployee.procurarAssalariado(idChange);

        Menu.alterarDadosMetodoPagamento();
        int novoTipoPagamento = input.nextInt();
        input.nextLine();

        if(horista != null) {
            horista.tipo_pagamento = novoTipoPagamento;
        }
        else if(assalariado != null) {
            assalariado.tipo_pagamento = novoTipoPagamento;
        }
        else {
            Menu.userNotFound();
        }
	}
    
}
