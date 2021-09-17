
import java.util.Scanner;
import java.util.LinkedList;

public class setTimeCard implements command{
    Scanner input = new Scanner(System.in);
    CalendarDates dia = new CalendarDates();
    LinkedList<Horista> Horista = new LinkedList<Horista>();
    LinkedList<Assalariado> Assalariado = new LinkedList<Assalariado>();

    setTimeCard(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.Horista = listaHorista;
        this.Assalariado = listaAssalariado;
    }

    @Override
    public void execute() {
        Menu.id();
        int aux = input.nextInt();
        input.nextLine();
        timeCard(aux, dia.hoje()-1);
    }

    public void timeCard(int id, int dia) {
        Menu.inOut();
        int escolha = input.nextInt();
        input.nextLine();

        for (int i = 0; i < Horista.size(); i++) {
            Horista aux = Horista.get(i);

            if(aux.id == id) {
                if(escolha == 1) {
                    Menu.carto_de_ponto_chegada();
                    int horarioChegada = input.nextInt();
                    input.nextLine();
                    aux.employeeTimecard[dia].entrada = horarioChegada;
                }
                else if(escolha == 2) {
                    Menu.carto_de_ponto_saida();
                    int horarioSaida = input.nextInt();
                    input.nextLine();
                    aux.employeeTimecard[dia].saida = horarioSaida;
                    aux.employeeTimecard[dia].flag_trabalhou = 1;
                }
                else {
                    System.out.println("Escolha inválida");
                }
            }
        }
    }
}
