
import java.util.Scanner;
import java.util.LinkedList;

public class ServiceCharge implements command{
    LinkedList<Horista> Horista = new LinkedList<Horista>();
    LinkedList<Assalariado> Assalariado = new LinkedList<Assalariado>();
    Scanner input = new Scanner(System.in);

    ServiceCharge(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.Horista = listaHorista;
        this.Assalariado = listaAssalariado;
    }

    @Override
    public void execute() {
        Menu.id();
        int aux = input.nextInt();
        input.nextLine();
        serviceCharge(aux);
    }
    
    public void serviceCharge(int id) {
        for (int i = 0; i < Assalariado.size(); i++) {
            Assalariado aux = Assalariado.get(i);

            if(aux.id == id) {
                if(aux.verSindicate == 1) {
                    Menu.digitarTaxa();
                    double servico = input.nextDouble();
                    input.nextLine();
                    aux.taxa_servico = servico;
                }
                else {
                    System.out.println("Esse funcionario não é comissionado!");
                }
            }
        }
    }
}
