
import java.util.Scanner;
import java.util.LinkedList;
public class ChangeDataSindicate implements command{
    LinkedList<Horista> listaHorista = new LinkedList<Horista>();
    LinkedList<Assalariado> listaAssalariado = new LinkedList<Assalariado>();
    Scanner input = new Scanner(System.in);
    id idFunctions = new id();
    Horista horista = new Horista();
    Assalariado assalariado = new Assalariado();
    SearchEmployee searchEmployee;

    ChangeDataSindicate(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.listaHorista = listaHorista;
        this.listaAssalariado = listaAssalariado;
        this.searchEmployee = new SearchEmployee(listaHorista, listaAssalariado);
    }

    @Override
    public void execute () {
        Menu.alterarDadosSindicato();

        int novoIdentSindicato = input.nextInt();
        input.nextLine();

        int taxaSind = 0;

        if(novoIdentSindicato == 2) {
            novoIdentSindicato = 0;
        }
        else {
            novoIdentSindicato = 1;
            Menu.alterarDadosNovaTaxaSind();
            taxaSind = input.nextInt();
            input.nextLine();
        }

        if(horista != null) {
            horista.verSindicate = novoIdentSindicato;
            if(novoIdentSindicato != 0) {
                horista.idSindicato = idFunctions.getIdSindicato();
                idFunctions.incrementIdSindicato();
                horista.taxSindicate = taxaSind;
            }
            else {
                horista.idSindicato = -1;
                horista.taxSindicate = 0;
            }
        }
        else if(assalariado != null) {
            assalariado.verSindicate = novoIdentSindicato;
            if(novoIdentSindicato != 0) {
                assalariado.idSindicato = idFunctions.getIdSindicato();
                idFunctions.incrementIdSindicato();
                assalariado.taxSindicate = taxaSind;
            }
            else {
                horista.idSindicato = -1;
                horista.taxSindicate = 0;
            }
        }
        else {
            Menu.userNotFound();
        }
	}
}
