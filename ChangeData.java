
import java.util.Scanner;
import java.util.LinkedList;

public class ChangeData implements command{
    LinkedList<Horista> listaHorista = new LinkedList<Horista>();
    LinkedList<Assalariado> listaAssalariado = new LinkedList<Assalariado>();
    Scanner input = new Scanner(System.in);
    CalendarDates calendarDates = new CalendarDates();
    SearchEmployee searchEmployee;
    removeEmployee remove;
    Payment payment;
    ChangeDataName changeName;
    ChangeDataAdress changeAdress;
    ChangeDataPaymentType changePaymentType;
    ChangeDataPaymentMethod changePaymentMethod;
    ChangeDataSindicate changeSindicate;
    id id = new id();

    ChangeData(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.listaHorista = listaHorista;
        this.listaAssalariado = listaAssalariado;
        this.changeName = new ChangeDataName(listaHorista, listaAssalariado);
        this.searchEmployee = new SearchEmployee(listaHorista, listaAssalariado);
        this.changeAdress = new ChangeDataAdress(listaHorista, listaAssalariado);
        this.changePaymentType = new ChangeDataPaymentType(listaHorista, listaAssalariado);
        this.changePaymentMethod = new ChangeDataPaymentMethod(listaHorista, listaAssalariado);
        this.changeSindicate = new ChangeDataSindicate(listaHorista, listaAssalariado);
        this.payment = new Payment(listaHorista, listaAssalariado);
        this.remove = new removeEmployee(listaHorista, listaAssalariado);
    }

    @Override
    public void execute() {
        Menu.alterarDados();
        int aux = input.nextInt();
        input.nextLine();

        alterarDados(aux, id.getIdSindicato(), calendarDates.diasMes());
        id.incrementIdSindicato();
    }

    public void alterarDados(int escolha, int idSindicato, int diasMes) {
        
        switch (escolha) {
            case 1:
                changeName.execute();
                break;
            case 2:
                changeAdress.execute();
                break;
            case 3:
                changePaymentType.execute();
                break;
            case 4:
                changePaymentMethod.execute();
                break;
            case 5:
                changeSindicate.execute();
                break;
            default:
                break;
        }
    }
}
