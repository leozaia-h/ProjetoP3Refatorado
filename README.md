# ProjetoP3Refatorado
## Primeira smell (complexa):
##### ANTES
```java
        while(true) {
            menu.init();
            menu.escolha();

            if(escolha == 1) {
                System.out.printf("O ID do funcionario adicionado é %d\n", id-1);
            }

            escolha = input.nextInt();
            input.nextLine();

            menu.clearScreen(); 
        
            if(escolha == 1) {
                menu.tipoFuncionario();
                int tipoFuncionario = input.nextInt();
                input.nextLine();

                if(tipoFuncionario == 1) {
                    Funcoes.add_assalariado(id, idSindicato);
                }
                else if(tipoFuncionario == 2) {
                    Funcoes.addHorista(id, idSindicato);
                }
                id++;
                idSindicato++;
            }
            else if(escolha == 2) {
                menu.rmEmpregado();
                int aux = input.nextInt();
                input.nextLine();

                Funcoes.Rm_empregado(aux);
            }
            else if(escolha == 3) {
                menu.id();
                int aux = input.nextInt();
                input.nextLine();
                Funcoes.cartao_de_ponto(aux, dia-1);
            }
            else if(escolha == 4) {
                menu.id();
                int aux = input.nextInt();
                Funcoes.vendas(aux);
            }
            else if(escolha == 5) {
                menu.id();
                int aux = input.nextInt();
                input.nextLine();
                Funcoes.taxa_de_servico(aux);
            }
            else if(escolha == 6) {
                menu.alterarDados();
                int aux = input.nextInt();
                input.nextLine();

                menu.id();
                int idChange = input.nextInt();
                input.nextLine();

                Funcoes.alterarDados(aux, idChange, idSindicato, diasMes);
                idSindicato++;
            }
            else if(escolha == 7) {
                Funcoes.Lista_de_empregados();
            }
            else if(escolha == 8) {
                Funcoes.rodarPagamento(dia, ultimoDiaUtil);
            }
            else if(escolha == 99) {
                break;
            }
            else {
                menu.alert_escolha_invalida();
            }
        }
```

##### DEPOIS [Aplicado command pattern]

```java
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
```

## Segunda smell (complexa):
##### ANTES
```java

    public void alterarDados(int escolha, int id, int idSindicato, int diasMes) {
        Horista horista = new Horista();
        Assalariado assalariado = new Assalariado();
        String novoNome;

        horista = procurarHorista(id);
        assalariado = procurarAssalariado(id);
        
        switch (escolha) {
            case 1:
                menu.alterarDadosNome();
                novoNome = input.nextLine();

                if(horista == null && assalariado == null) {
                    System.out.println("Empregado não encontrado");
                }
                else if(horista != null) {
                    horista.nome = novoNome;
                }
                else if(assalariado != null) {
                    assalariado.nome = novoNome;
                }
                break;
            case 2:
                menu.alterarDadosEndereco();
                String novoEndereco = input.nextLine();

                if(horista != null) {
                    horista.nome = novoEndereco;
                }
                else if(assalariado != null) {
                    assalariado.nome = novoEndereco;
                }
                else {
                    System.out.println("Empregado não encontrado");
                }
                break;
            case 3:
                menu.alterarDadosTipoPagamento();
                int escolhaTipoEmpregado = input.nextInt();
                input.nextLine();

                if(escolhaTipoEmpregado == 1) {
                    if(horista != null) {
                        alterarPagamentoAssalariado(horista, id, idSindicato);
                        removerHorista(id);
                    }
                    else {
                        System.out.println("O funcionário já é assalariado!");
                    }
                }
                else if(escolhaTipoEmpregado == 2) {
                    if(assalariado != null) {
                        alterarPagamentoHorista(assalariado, id, idSindicato);
                        removerAssalariado(id);
                    }
                    else {
                        System.out.println("O funcionário já é horista!");
                    }
                }
                break;
            case 4:
                menu.alterarDadosMetodoPagamento();
                int novoTipoPagamento = input.nextInt();
                input.nextLine();

                if(horista != null) {
                    horista.tipo_pagamento = novoTipoPagamento;
                }
                else if(assalariado != null) {
                    assalariado.tipo_pagamento = novoTipoPagamento;
                }
                else {
                    System.out.println("Empregado não encontrado");
                }
                break;
            case 5:
                menu.alterarDadosSindicato();
                int novoIdentSindicato = input.nextInt();
                input.nextLine();

                int taxaSind = 0;

                if(novoIdentSindicato == 2) {
                    novoIdentSindicato = 0;
                }
                else {
                    novoIdentSindicato = 1;
                    menu.alterarDadosNovaTaxaSind();
                    taxaSind = input.nextInt();
                    input.nextLine();
                }

                if(horista != null) {
                    horista.verSindicate = novoIdentSindicato;
                    horista.idSindicato = idSindicato;
                    horista.taxSindicate = taxaSind;
                }
                else if(assalariado != null) {
                    assalariado.verSindicate = novoIdentSindicato;
                    assalariado.idSindicato = idSindicato;
                    assalariado.taxSindicate = taxaSind;
                }
                else {
                    System.out.println("Empregado não encontrado");
                }
                break;
            default:
                break;
        }
    }
```

##### DEPOIS [Aplicado command pattern]
```java
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
```

## Terceira smell (simples):
[Implementado]
```java
public class id {
    private int id = 0;
    private int idSindicato = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSindicato() {
        return idSindicato;
    }
    
    public void setIdSindicato(int idSindicato) {
        this.idSindicato = idSindicato;
    }

    public void incrementId() {
        this.id++;
    }

    public void incrementIdSindicato() {
        this.idSindicato++;
    }
}
```
