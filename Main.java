import java.util.Scanner;
import java.util.LinkedList;
/**
 * Falta:
 * Undo/redo
**/
public class Main {
    public static void main(String[] args) {
        LinkedList<Horista> listaHorista = new LinkedList<Horista>();
        LinkedList<Assalariado> listaAssalariado = new LinkedList<Assalariado>();

        Scanner input = new Scanner(System.in);
        CalendarDates f = new CalendarDates();
        addEmployee addEmployee = new addEmployee(listaHorista, listaAssalariado);
        removeEmployee removeEmployee = new removeEmployee(listaHorista, listaAssalariado);
        setTimeCard setTimeCard = new setTimeCard(listaHorista, listaAssalariado);
        ServiceCharge serviceCharge = new ServiceCharge(listaHorista, listaAssalariado);
        ChangeData changeData = new ChangeData(listaHorista, listaAssalariado);
        ListEmployees list = new ListEmployees(listaHorista, listaAssalariado);
        Payment payment = new Payment(listaHorista, listaAssalariado);
        Sales sale = new Sales(listaHorista, listaAssalariado);
        int escolha = 0;
        int dia = f.hoje();
        int ultimoDiaUtil = f.getUltimoDiaUtilDoMes();

        while(true) {
            Menu.init();
            Menu.escolha();

            escolha = input.nextInt();
            input.nextLine();

            Menu.clearScreen(); 

            if(escolha == 1) {
                addEmployee.execute();
            }
            else if(escolha == 2) {
                removeEmployee.execute();
            }
            else if(escolha == 3) {
                setTimeCard.execute();
            }
            else if(escolha == 4) {
                sale.execute();
            }
            else if(escolha == 5) {
                serviceCharge.execute();
            }
            else if(escolha == 6) {
                changeData.execute();
            }
            else if(escolha == 7) {
                list.ListAllEmployees();
            }
            else if(escolha == 8) {
                payment.rodarPagamento(dia, ultimoDiaUtil);
            }
            else if(escolha == 99) {
                break;
            }
            else {
                Menu.alert_escolha_invalida();
            }
        }
    }
}
