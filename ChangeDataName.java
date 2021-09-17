
import java.util.Scanner;
import java.util.LinkedList;

public class ChangeDataName implements command{
    LinkedList<Horista> listaHorista = new LinkedList<Horista>();
    LinkedList<Assalariado> listaAssalariado = new LinkedList<Assalariado>();
    Scanner input = new Scanner(System.in);
    id idFunctions = new id();
    Horista horista = new Horista();
    Assalariado assalariado = new Assalariado();

    ChangeDataName(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.listaHorista = listaHorista;
        this.listaAssalariado = listaAssalariado;
    }

    @Override
    public void execute () {
        SearchEmployee searchEmployee = new SearchEmployee(listaHorista, listaAssalariado);

        Menu.id();
        int idChange = input.nextInt();
        input.nextLine();

		Menu.alterarDadosNome();
        String novoNome = input.nextLine();

        horista = searchEmployee.procurarHorista(idChange);
        assalariado = searchEmployee.procurarAssalariado(idChange);

        if(horista == null && assalariado == null) {
            Menu.userNotFound();
        }
        else if(horista != null) {
            horista.nome = novoNome;
        }
        else if(assalariado != null) {
            assalariado.nome = novoNome;
        }
	}
}
