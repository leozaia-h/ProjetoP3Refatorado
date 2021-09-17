
import java.util.Scanner;
import java.util.LinkedList;

public class Sales implements command{
    LinkedList<Horista> Horista = new LinkedList<Horista>();
    LinkedList<Assalariado> Assalariado = new LinkedList<Assalariado>();
    Scanner input = new Scanner(System.in);

    Sales(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.Horista = listaHorista;
        this.Assalariado = listaAssalariado;
    }

    @Override
    public void execute() {
        Menu.id();
        int aux = input.nextInt();
        vendas(aux);
    }

    public void vendas(int id) {
        for (int i = 0; i < Assalariado.size(); i++) {
            Assalariado aux = Assalariado.get(i);

            if(aux.id == id && aux.verComissao == 1) {
                Menu.valorVenda();
                Double venda = input.nextDouble();
                aux.valor_vendas += venda;
                System.out.printf("O valor de %.2f foi adicionado às vendas do funcionário %d\n", venda, id);
            }
            else {
                System.out.println("Funcionario não comissionado.");
            }
        }
    }
}
