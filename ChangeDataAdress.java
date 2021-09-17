import java.util.Scanner;
import java.util.LinkedList;

public class ChangeDataAdress implements command{
    LinkedList<Horista> listaHorista = new LinkedList<Horista>();
    LinkedList<Assalariado> listaAssalariado = new LinkedList<Assalariado>();
    Scanner input = new Scanner(System.in);
    id idFunctions = new id();
    Horista horista = new Horista();
    Assalariado assalariado = new Assalariado();
    SearchEmployee searchEmployee;

    ChangeDataAdress(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
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

        Menu.alterarDadosEndereco();
        String novoEndereco = input.nextLine();

        if(horista != null) {
            horista.nome = novoEndereco;
        }
        else if(assalariado != null) {
            assalariado.nome = novoEndereco;
        }
        else {
            Menu.userNotFound();
        }
	}
}
