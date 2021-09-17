
import java.util.Scanner;
import java.util.LinkedList;

public class removeEmployee implements command {
    Scanner input = new Scanner(System.in);
    LinkedList<Horista> Horista = new LinkedList<Horista>();
    LinkedList<Assalariado> Assalariado = new LinkedList<Assalariado>();

    removeEmployee(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.Horista = listaHorista;
        this.Assalariado = listaAssalariado;
    }

    @Override
    public void execute() {
        Menu.rmEmpregado();
        int aux = input.nextInt();
        input.nextLine();

        remove(aux);
    }

    public void remove(int id) {

        for (int i = 0; i < Horista.size(); i++) {
            Horista aux = Horista.get(i);

            if(aux.id == id) {
                Horista.remove(i);
                Menu.empregado_removido();
            }
        }
		for (int i = 0; i < Assalariado.size(); i++) {
            Assalariado aux = Assalariado.get(i);

            if(aux.id == id) {
                Assalariado.remove(i);
                Menu.empregado_removido();
            }
        }
    }

    public void removerHorista(int id) {
        for (int i = 0; i < Horista.size(); i++) {
            Horista aux = Horista.get(i);

            if(aux.id == id) {
                Horista.remove(i);
            }
        }
    }

    public void removerAssalariado(int id) {
        for (int i = 0; i < Assalariado.size(); i++) {
            Assalariado aux = Assalariado.get(i);

            if(aux.id == id) {
                Assalariado.remove(i);
            }
        }
    }
}
