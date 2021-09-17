
import java.util.LinkedList;

public class ListEmployees {
    LinkedList<Horista> Horista = new LinkedList<Horista>();
    LinkedList<Assalariado> Assalariado = new LinkedList<Assalariado>();

    ListEmployees(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.Horista = listaHorista;
        this.Assalariado = listaAssalariado;
    }

    public void ListAllEmployees () {

        System.out.println("Assalariado:");
        System.out.println("-------------------------");
        for (int i = 0; i < Assalariado.size(); i++) {
            Assalariado aux = Assalariado.get(i);
            System.out.printf("%s[ID: %d / IDs: %d]\n", aux.nome, aux.id, aux.idSindicato);
            System.out.printf("Salario: %.2f\nSindicato: %d\nTaxa: %.2f\nAgenda de Pagamento: %s\n", aux.salario, aux.verSindicate, aux.taxSindicate, aux.agendaPagamento);
            System.out.println("-------------------------");
        }

        System.out.println("Horistas:");
        System.out.println("-------------------------");
        for (int i = 0; i < Horista.size(); i++) {
            Horista aux = Horista.get(i);
            System.out.printf("%s[ID: %d / IDs: %d]\n", aux.nome, aux.id, aux.idSindicato);
            System.out.printf("Salario: %.2f\nSindicato: %d\nTaxa: %.2f\nAgenda de Pagamento: %s\n", aux.salario, aux.verSindicate, aux.taxSindicate, aux.agendaPagamento);

            for (int j = 0; j < 30; j++) {
                if(aux.employeeTimecard[j].flag_trabalhou == 1) {
                    System.out.printf("dia %d  :  %dh\n", j + 1, aux.employeeTimecard[j].saida - aux.employeeTimecard[j].entrada);
                }
            }
            System.out.println("-------------------------");
        }
    }
}
