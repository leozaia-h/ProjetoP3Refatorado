
import java.util.Scanner;
import java.util.LinkedList;

public class Payment {
    Scanner input = new Scanner(System.in);
    CalendarDates calendar = new CalendarDates();

    LinkedList<Horista> Horista = new LinkedList<Horista>();
    LinkedList<Assalariado> Assalariado = new LinkedList<Assalariado>();
    
    Payment(LinkedList <Horista>listaHorista, LinkedList <Assalariado>listaAssalariado) {
        this.Horista = listaHorista;
        this.Assalariado = listaAssalariado;
    }

    public void rodarPagamento(int hoje, int ultimoDiaUtil) {
        pagarAssalariados(hoje, ultimoDiaUtil);
        pagarHoristas(hoje);
    }

    public String formaPagamento() {
        String sSemanas = "";
        String result = "";
        String sDias = "";
        Menu.formaPagamento();
        int escolha = input.nextInt();
        input.nextLine();

        if(escolha == 2) {
            result = "Semanal";

            Menu.semanasPagamento();
            int semanas = input.nextInt();
            input.nextLine();

            Menu.diaSemana();
            int dia = input.nextInt();
            input.nextLine();

            sSemanas = Integer.toString(semanas);

            if(dia == 2) {
                sDias = "segunda";
            }
            else if(dia == 3) {
                sDias = "terça";
            }
            else if(dia == 4) {
                sDias = "quarta";
            }
            else if(dia == 5) {
                sDias = "quinta";
            }
            else if(dia == 6) {
                sDias = "sexta";
            }
            result += " " + sSemanas + " " + sDias;
        }
        else if (escolha == 1) {
            result = "Mensal";

            Menu.ultimoDia();
            int ultimoDia = input.nextInt();
            input.nextLine();

            if(ultimoDia != 1) {
                Menu.dia();
                int dia = input.nextInt();
                input.nextLine();
                String sDia = Integer.toString(dia);
                result += " " + sDia;
            }
            else {
                result += " $";
            }
        }
        return result;
    }

    public void pagarHoristas(int hoje) {
        int horasDia;
        float salario = 0;

        for (int i = 0; i < Horista.size(); i++) {
            Horista funcionario = Horista.get(i);
            String sHoje = calendar.sHoje();

            System.out.printf("[%d]%s\nHoras trabalhadas:\n", funcionario.id, funcionario.nome);

            if(funcionario.agendaPagamento.contains(sHoje)) {
                for (int j = 0; j < 30; j++) {
                    if(funcionario.employeeTimecard[j].flag_trabalhou == 1) {
                        horasDia = funcionario.employeeTimecard[j].saida - funcionario.employeeTimecard[j].entrada;
                        if(horasDia <= 8) {
                            salario += horasDia * funcionario.salario;
                        }
                        else {
                            salario += 8 * funcionario.salario;
                            salario += ((horasDia - 8) * (funcionario.salario * 1.5));
                        }
                        System.out.printf("Dia %d: %dh\n", j+1, horasDia);
                    }
                }
            }
            System.out.printf("Total por horas: R$%.2f\n", salario);
            salario += funcionario.taxa_servico + funcionario.taxSindicate;
            System.out.printf("Taxa Sindicato: R$%.2f\n", funcionario.taxSindicate);
            System.out.printf("Taxa de serviço: R$%.2f\n", funcionario.taxa_servico);
            System.out.printf("Total a pagar: R$%.2f\n\n", salario);
            salario = 0;
        }
    }

    public void pagarAssalariados(int hoje, int ultimoDiaUtil) {
        double salario = 0;

        for (int i = 0; i < Assalariado.size(); i++) {
            Assalariado funcionario = Assalariado.get(i);
            String sHoje = Integer.toString(hoje);

            if(funcionario.agendaPagamento.contains(sHoje) || (funcionario.agendaPagamento.contains("$") && hoje == ultimoDiaUtil)) {
                if(funcionario.verComissao == 0) {
                    salario += funcionario.taxa_servico + funcionario.taxSindicate + funcionario.salario;
                    System.out.printf("[%d]%s\nSalario: R$%.2f\nTaxa de Serviço: R$%.2f\nTaxa Sindicato: R$%.2f\nTotal: R$ %.2f\n\n",funcionario.id, funcionario.nome, funcionario.salario, funcionario.taxa_servico, funcionario.taxSindicate, salario);
                }
                else {
                    salario = ((funcionario.taxaComissao/100)*funcionario.valor_vendas) + funcionario.salario + funcionario.taxa_servico + funcionario.taxSindicate;
                    System.out.printf("[%d]%s\nSalario: R$%.2f\nTaxa de Serviço: R$%.2f\nTaxa Sindicato: R$%.2f\nComissao: R$%.2f\nTotal: R$%.2f\n\n",funcionario.id, funcionario.nome, funcionario.salario, funcionario.taxa_servico, funcionario.taxSindicate, ((funcionario.taxaComissao/100)*funcionario.valor_vendas),salario);
                }
            }
        }   
    }
}
