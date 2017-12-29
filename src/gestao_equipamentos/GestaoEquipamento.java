/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import util.Consola;

/**
 *
 * @author Ricardo Anastácio
 */
public class GestaoEquipamento {

    public static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    public static Gestor gerir = new Gestor();

    public static void main(String[] args) {

        //gerir.lerFicheiro();
        testes(gerir); // COMENTAR 
        int op;
        int op2;
        int op3;
        do {
            op = menu();
            switch (op) {
                case 1:
                    do {
                        op2 = gestaoEscolas();
                        switch (op2) {
                            case 1:
                                inserirEscola(gerir);
                                break;
                            case 2:
                                if (gerir.getSizeEscolas() != 0) {
                                    consulaEscolaNIF(gerir);
                                } else {
                                    System.err.println("\nÉ necessário existir escolas!\n");
                                }
                                break;
                        }
                    } while (op2 != 0);
                    break;
                case 2:
                    do {
                        op2 = gestaoFuncionarios();
                        switch (op2) {
                            case 1:
                                if (gerir.getSizeEscolas() != 0) {
                                    inserirFuncionario(gerir);
                                } else {
                                    System.err.println("\nÉ necessário existir escolas para registar funcionarios!\n");
                                }
                                break;
                            case 2:
                                if (gerir.getSizeFuncionarios() != 0) {
                                    alterarFuncionario(gerir);
                                } else {
                                    System.err.println("\nÉ necessário existirem funcionários!\n");
                                }
                                break;
                            case 3:
                                if (gerir.getSizeFuncionarios() != 0) {
                                    consultaFuncionarioNIF(gerir);
                                } else {
                                    System.err.println("\nÉ necessário existirem funcionários!\n");
                                }
                                break;
                            case 4:
                                if (gerir.getSizeFuncionarios() != 0) {    //se o funcionario nao estiver associado a avarias
                                    eliminarFuncionarioNIF(gerir);
                                } else {
                                    System.err.println("\nÉ necessário existirem funcionários!\n");
                                }
                                break;
                        }
                    } while (op2 != 0);
                    break;
                case 3:
                    do {
                        op2 = gestaoLaboratorios();
                        switch (op2) {
                            case 1:
                                if (gerir.getSizeEscolas() != 0) {
                                    inserirLaboratorio(gerir);
                                } else {
                                    System.err.println("\nÉ necessário existirem escolas!\n");
                                }
                                break;
                            case 2:
                                do {
                                    op3 = menuLabConsulta();
                                    switch (op3) {
                                        case 1:
                                            if (gerir.getSizeLaboratorio() != 0) {
                                                consultarLaboratorioDescricao(gerir);
                                            } else {
                                                System.err.println("\nÉ necessário existirem laboratórios!\n");
                                            }
                                            break;
                                        case 2:
                                            if (gerir.getSizeLaboratorio() != 0) {
                                                consultarLaboratorioEscola(gerir);
                                            } else {
                                                System.err.println("\nÉ necessário existirem laboratórios!\n");
                                            }
                                    }
                                } while (op3 != 0);
                                break;
                            case 3:
                        }
                    } while (op2 != 0);
                    break;
                case 4:
                    do {
                        op2 = gestaoTiposEquipamento();
                        switch (op2) {
                            case 1:
                                inserirTiposEquipamento(gerir);
                                break;
                            case 2:
                                if (gerir.getSizeTipoEquipamento() != 0) {
                                    consultarTiposEquipamentos(gerir);
                                } else {
                                    System.err.println("\nÉ necessario existirem tipos de equipamento!\n");
                                }
                                break;
                            case 3:
                        }
                    } while (op2 != 0);
                    break;
                case 5:
                    do {
                        op2 = gestaoEquipamentos();
                        switch (op2) {
                            case 1:
                                if (gerir.getSizeEscolas() != 0 && gerir.getSizeFuncionarios() != 0 && gerir.getSizeTipoEquipamento() != 0) {
                                    registarEquipamento(gerir);
                                } else {
                                    System.err.println("\nÉ necessario existir escolas, funcionários e tipo de equipamentos para se registarem equipamentos!\n");
                                }
                                break;
                            case 2:
                                if (gerir.getSizeEquipamento() != 0 && gerir.getSizeLaboratorio() != 0) {
                                    associarLabEquipamento(gerir);
                                } else {
                                    System.err.println("\nÉ necessario existir equipamentos e laboratórios para associar equipamentos a laboratórios!\n");
                                }

                                break;
                            case 3:
                                if (gerir.getSizeEquipamento() != 0) {
                                    consultarEquipamentoNumero(gerir);
                                } else {
                                    System.err.println("\nÉ necessario existir equipamentos para os puder consultar!\n");
                                }
                                break;
                        }
                    } while (op2 != 0);
                    break;
                case 6:
                    do {
                        op2 = gestaoAvarias();
                        switch (op2) {
                            case 1:
                                if (gerir.getSizeEquipamento() != 0) {
                                    registarAvaria(gerir);
                                } else {
                                    System.err.println("\nÉ necessario existir equipamentos para registar avarias!\n");
                                }
                                break;
                            case 2:
                                if (gerir.getSizeEquipamento() != 0 && gerir.verificarAvarias() && gerir.verificaNaoDocenteTecnico()) {
                                    alterarEstadoAvaria(gerir);
                                } else {
                                    if (gerir.getSizeEquipamento() == 0) {
                                        System.err.println("\nÉ necessario existir avarias!\n");
                                    }
                                    if (gerir.verificarAvarias() == false) {
                                        System.err.println("\nNão há avarias para modificar!\n");
                                    }
                                }
                                break;
                            case 3:
                                if (gerir.getSizeAvarias() != 0) {
                                    consultarAvariaEquipamento(gerir);
                                } else {
                                    System.err.println("\nÉ necessario existir avarias!\n");
                                }
                                break;
                        }
                    } while (op2 != 0);
                    break;

                case 7:

                    do {
                        op2 = menuEstatisticas();
                        switch (op2) {
                            case 1:
                                System.out.println("\nPercentagem de Equipamentos com avarias no agrupamento " + gerir.percEquipAvariagrup() + "%\n");

                                break;
                            case 2:
                                System.out.println(gerir.AvariasRegistadasPorOrdemCrescenteTotal());
                                break;
                            case 3:

                        }
                    } while (op2 != 0);

                    break;
                case 0:
                    System.err.println("O programa terminou...");
                    System.exit(0);
            }
            Consola.sc.nextLine();
        } while (op != 0);
        //    gerir.gravarFicheiro();
    }

    public static void testes(Gestor gerir) {
        int pos, pos1;

        Calendar dataIventario = new GregorianCalendar();
        Date data = new Date();
        dataIventario.setTime(data);
        Calendar data2 = new GregorianCalendar();
        Calendar data3 = new GregorianCalendar();
        Calendar data4 = new GregorianCalendar();

        Escola E = new Escola("IPL", 10, "Morro do lena", 919145785, "sadassdads@gmal.com", dataIventario);
        gerir.adicionarEscola(E);
        Escola E1 = new Escola("EscolaMundo", 11, "Batalha", 915144245, "gdffhfh@gmal.com", dataIventario);
        gerir.adicionarEscola(E1);

        FuncionarioNaoDocente F = new FuncionarioNaoDocente("Ricardo", "Batalha", 1, "gamil@com", 556555, dataIventario, "4Ano", E, "tecnico");
        gerir.adicionarNaoDocente(F);
        E.adicionarFuncionario(F);
        FuncionarioNaoDocente F1 = new FuncionarioNaoDocente("Bruno", "Chao Das Pias", 2, "gamil@com", 556555, dataIventario, "2ºAno", E, "nao faz nada");
        gerir.adicionarNaoDocente(F1);
        E.adicionarFuncionario(F1);
        FuncionarioNaoDocente F2 = new FuncionarioNaoDocente("Tozé", "PortodeMos", 3, "gamil@com", 556555, dataIventario, "12Ano", E1, "tecnico");
        gerir.adicionarNaoDocente(F2);
        E1.adicionarFuncionario(F2);

        FuncionarioDocente F3 = new FuncionarioDocente("Maria", "Tailandia", 4, "gamil@com", 91452454, dataIventario, "Licenciatura", E1, "Eng.Eletrorecnica E de Computadores");
        gerir.adicionarDocente(F3);
        E1.adicionarFuncionario(F3);

        Laboratorio L = new Laboratorio("LAB-INFORMATICA", E, "Perto do chao");
        gerir.adicionarLaboratorio(L);
        E.adicionarLaboratorio(L);

        Laboratorio L1 = new Laboratorio("LAB-ELETRO", E, "No paraiso");
        gerir.adicionarLaboratorio(L1);
        E1.adicionarLaboratorio(L1);

        Laboratorio L2 = new Laboratorio("LAB-TESTE", E1, "No caralho");
        gerir.adicionarLaboratorio(L2);
        E1.adicionarLaboratorio(L2);

        TipoEquipamento TipoEQ = new TipoEquipamento("Eletronica");
        gerir.adicionarTipoEquipamento(TipoEQ);
        TipoEquipamento TipoEQ1 = new TipoEquipamento("Mecanica");
        gerir.adicionarTipoEquipamento(TipoEQ1);
        TipoEquipamento TipoEQ2 = new TipoEquipamento("Informatica");
        gerir.adicionarTipoEquipamento(TipoEQ2);

        Equipamento EQ = new Equipamento(dataIventario, "PC", 99999, TipoEQ, E, 52, F, 1);
        gerir.adicionarEquipamento(EQ);
        TipoEQ.adicionarEquipamento(EQ);

        Equipamento EQ1 = new Equipamento(dataIventario, "Impresora", 11111, TipoEQ1, E1, 12, F2, 1);
        gerir.adicionarEquipamento(EQ1);
        TipoEQ1.adicionarEquipamento(EQ);

        Equipamento EQ2 = new Equipamento(dataIventario, "rato", 5454, TipoEQ1, E1, 12, F2, 1);
        gerir.adicionarEquipamento(EQ2);
        TipoEQ1.adicionarEquipamento(EQ);

        Equipamento EQ3 = new Equipamento(dataIventario, "caneta", 11111, TipoEQ2, E, 12, F2, 1);
        gerir.adicionarEquipamento(EQ3);
        TipoEQ2.adicionarEquipamento(EQ);

        Equipamento EQ4 = new Equipamento(dataIventario, "telemovel", 11111, TipoEQ2, E1, 52, F2, 1);
        gerir.adicionarEquipamento(EQ4);
        TipoEQ2.adicionarEquipamento(EQ);

        data2.set(1, 2016);
        data3.set(1, 2018);
        data4.set(1, 2019);

        Avaria A = new Avaria(dataIventario, EQ, "avaria", F, 1, false);
        gerir.adicionarAvaria(A);
        AuxEst Aux;

        pos1 = gerir.pesquisarAvariaAno(A.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A.getDataAvaria());
            pos1 = gerir.pesquisarAvariaAno(A.getDataAvaria());
            gerir.adicionarauEst(Aux);
        } else {
            Aux = gerir.obteradicionarauEst(pos1);
        }

        Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
        Aux.setNumEquipAvarias(Aux.getNumEquipAvarias() + 1);
        EQ.adicionarAvaria(A);

        Avaria A1 = new Avaria(data2, EQ, "avaria1", F, 2, true);
        gerir.adicionarAvaria(A1);

        pos1 = gerir.pesquisarAvariaAno(A1.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A1.getDataAvaria());
            pos1 = gerir.pesquisarAvariaAno(A1.getDataAvaria());
            gerir.adicionarauEst(Aux);
        } else {
            Aux = gerir.obteradicionarauEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasReparadas() + 1);
        Aux.setNumEquipAvarias(Aux.getNumEquipAvarias() + 1);
        EQ.adicionarAvaria(A1);

        Avaria A2 = new Avaria(data3, EQ, "avaria2", F, 2, true);
        gerir.adicionarAvaria(A2);
        pos1 = gerir.pesquisarAvariaAno(A2.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A2.getDataAvaria());
            pos1 = gerir.pesquisarAvariaAno(A2.getDataAvaria());
            gerir.adicionarauEst(Aux);
        } else {
            Aux = gerir.obteradicionarauEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasReparadas() + 1);
        Aux.setNumEquipAvarias(Aux.getNumEquipAvarias() + 1);
        EQ.adicionarAvaria(A2);

        Avaria A3 = new Avaria(data4, EQ, "avaria3", F, 2, true);
        gerir.adicionarAvaria(A3);
        pos1 = gerir.pesquisarAvariaAno(A3.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A3.getDataAvaria());
            pos1 = gerir.pesquisarAvariaAno(A3.getDataAvaria());
            gerir.adicionarauEst(Aux);
        } else {
            Aux = gerir.obteradicionarauEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasReparadas() + 1);
        Aux.setNumEquipAvarias(Aux.getNumEquipAvarias() + 1);
        EQ.adicionarAvaria(A3);

        Avaria A4 = new Avaria(data2, EQ, "avaria4", F, 2, true);
        gerir.adicionarAvaria(A4);
        pos1 = gerir.pesquisarAvariaAno(A4.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A4.getDataAvaria());
            pos1 = gerir.pesquisarAvariaAno(A4.getDataAvaria());
            gerir.adicionarauEst(Aux);
        } else {
            Aux = gerir.obteradicionarauEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasReparadas() + 1);
        Aux.setNumEquipAvarias(Aux.getNumEquipAvarias() + 1);
        EQ.adicionarAvaria(A4);

        Avaria A5 = new Avaria(data3, EQ, "avaria5", F, 3, true);
        gerir.adicionarAvaria(A5);
        pos1 = gerir.pesquisarAvariaAno(A5.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A5.getDataAvaria());
            pos1 = gerir.pesquisarAvariaAno(A5.getDataAvaria());
            gerir.adicionarauEst(Aux);
        } else {
            Aux = gerir.obteradicionarauEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasIrreparaveis() + 1);
        Aux.setNumEquipAvarias(Aux.getNumEquipAvarias() + 1);
        EQ.adicionarAvaria(A5);

        Avaria A6 = new Avaria(data3, EQ, "avaria6", F, 3, true);
        gerir.adicionarAvaria(A6);
        pos1 = gerir.pesquisarAvariaAno(A6.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A6.getDataAvaria());
            pos1 = gerir.pesquisarAvariaAno(A6.getDataAvaria());
            gerir.adicionarauEst(Aux);
        } else {
            Aux = gerir.obteradicionarauEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasIrreparaveis() + 1);
        Aux.setNumEquipAvarias(Aux.getNumEquipAvarias() + 1);
        EQ.adicionarAvaria(A6);

        Calendar dataReparacao = Calendar.getInstance();
        Reparacao R = new Reparacao(A, dataReparacao, "reparação", 10, F);
        gerir.adicionarReparacao(R);
        EQ.adicionarReparacao(R);
    }

    public static void consultarAvariaEquipamento(Gestor gerir) {
        Equipamento EQ;
        Avaria A;
        int id;
        int pos;

        System.out.println(gerir.ListarEquipamentos());
        do {
            id = Consola.lerInt("Indique o ID do equipamento a consultar: ", 1, 999999999);
            pos = gerir.pesquisarIdEquipamento(id);
            if (pos == -1) {
                System.err.println("Equipamento não existe!");
            }
        } while (pos == -1);
        EQ = gerir.obterEquipamento(pos);

        System.out.println(EQ.ListarAvarias(EQ));

        if (EQ.avariasEQnotEmpty()) {
            do {
                id = Consola.lerInt("Indique o ID da avaria a consultar: ", 1, 999999999);
                pos = EQ.pesquisarAvariaEQ(id);

                if (pos == -1) {
                    System.err.println("Avaria não existe!");
                }
            } while (pos == -1);

            A = EQ.obterAvaria1(pos);

            System.out.println(A + "\n");
        } else {
            System.err.println("O equipamento não tem avarias registadas!\n");
        }
    }

    public static void alterarEstadoAvaria(Gestor gerir) {
        int id;
        int pos;
        Avaria A;
        Calendar dataReparacao = Calendar.getInstance();
        Reparacao R;
        int estado;
        int nif;
        Funcionario F;
        String descricao;
        int custo;
        AuxEst Aux;

        System.out.println(gerir.listarAvarias());

        do {
            id = Consola.lerInt("Qual o ID da avaria que deseja alterar: ", 1, 999999999);
            pos = gerir.pesquisarAvaria1(id);
            if (pos == -1) {
                System.err.println("Não existem avarias com este número de identificação ou já foram reparadas!");
            }
        } while (pos == -1);

        A = gerir.obterAvaria(pos);

        if (gerir.verificaNaoDocenteTecnicoEscola(A.getEQ().getE()) == false) {
            System.err.println("Não há funcionários técnicos nesta escola!\n");
            return;
        }

        System.out.print(A.getEQ().getE().listarFuncionariosEscola());

        //tem de ser revista
        do {

            nif = Consola.lerInt("Indique o NIF do funcionário que regista a avaria: ", 1, 999999999);
            pos = gerir.pesquisarNaoDocenteTecnico(nif, A.getEQ().getE()); //acho que funciona porque ele vai verificar o nif ao array principal de funcionarios
            //pos = EQ.getE().pesquisarFuncionarioNIFEscola(nif);

            if (pos == -1) {
                System.err.println("Não existe funcionário com esse NIF ou não tem como função TECNICO!");
            }
        } while (pos == -1);
        F = gerir.obterFuncionario(pos); //uma vez que aqui ele tmb vai buscar o F de posição pos no array principal

        System.out.println("1-POR REPARAR / 2- REPARADA / 3-IRREPARÁVEL");

        estado = Consola.lerInt("Indique o novo estado da avaria: ", 1, 3);

        A.setEstadoA(estado);
        A.getEQ().obterAvaria(A).setEstadoA(estado);
        System.out.println("\n------Alterado o estado com sucesso!------\n");

        pos = gerir.pesquisarAvariaAno(A.getDataAvaria());
        Aux = gerir.obteradicionarauEst(pos);

        if (estado != 1) {
            A.setAlterado(true);
            A.getEQ().obterAvaria(A).setAlterado(true);
        }

        if (estado == 1) {
            A.getEQ().setEstado(2);
        }

        if (estado == 2) {

            descricao = Consola.lerString("Coloque uma breve descrição da reparação: ");
            custo = Consola.lerInt("Custo da reparação em euros: ", 0, 999999999);

            R = new Reparacao(A, dataReparacao, descricao, custo, F);
            gerir.adicionarReparacao(R);
            A.getEQ().adicionarReparacao(R);
            A.getEQ().setEstado(1);
            System.out.println("\n------Registada a reparação com sucesso!------\n");
            System.out.println(R);

            Aux.setNumAvariasReparadas(Aux.getNumAvariasReparadas() + 1);
            Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + -1);

        }

        if (estado == 3) {

            A.getEQ().setEstado(3);
            if (A.getEQ().getLab() == null) {
                Laboratorio lab = new Laboratorio("Equipamento foi abatido, não tem laboratório", null, null);
                A.getEQ().setLab(lab);
            }
            A.getEQ().getLab().setDescricao("Equipamento foi abatido, não tem laboratório");
            A.getEQ().getLab().setEscolaLab(null);
            A.getEQ().getLab().setEscolaLoc(null);

            Aux.setNumAvariasIrreparaveis(Aux.getNumAvariasIrreparaveis() + 1);
            Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + - 1);

        }

    }

    public static void registarAvaria(Gestor gerir) {
        Equipamento EQ;
        Calendar dataAvaria = Calendar.getInstance();
        String descriçao;
        Funcionario F;
        Avaria A;
        int id;
        int pos;
        int nif;
        AuxEst Aux;

        System.out.println(gerir.ListarEquipamentos());
        do {
            id = Consola.lerInt("Indique qual o equipamento que pretende registar uma avaria: ", 1, 999999999);
            pos = gerir.pesquisarIdEquipamento(id);
            if (pos == -1) {
                System.err.println("Não existe equipamento com esse ID!");
            }
        } while (pos == -1);
        EQ = gerir.obterEquipamento(pos);

        if (gerir.verificaNaoDocenteTecnicoEscola(EQ.getE()) == false) {
            System.err.println("Não há funcionários técnicos nesta escola!\n");
            return;
        }

        if (EQ.getEstado() == 1) {
            //tem de ser revisto (qq funcionário)
            System.out.print(EQ.getE().listarFuncionariosEscola());
            do {

                nif = Consola.lerInt("Indique o NIF do funcionário que regista a avaria: ", 1, 999999999);
                pos = gerir.pesquisarNaoDocenteTecnico(nif, EQ.getE()); //acho que funciona porque ele vai verificar o nif ao array principal de funcionarios
                //pos = EQ.getE().pesquisarFuncionarioNIFEscola(nif);

                if (pos == -1) {
                    System.err.println("Não existe funcionário com esse NIF ou o funcionário não pertence à escola ou não tem como função TECNICO!");
                }
            } while (pos == -1);
            F = gerir.obterFuncionario(pos); //uma vez que aqui ele tmb vai buscar o F de posição pos no array principal

            descriçao = Consola.lerString("Coloque uma breve descrição da avaria: ");

            A = new Avaria(dataAvaria, EQ, descriçao, F, 1, false);
            gerir.adicionarAvaria(A);
            EQ.adicionarAvaria(A);

            int pos1;
            pos1 = gerir.pesquisarAvariaAno(dataAvaria);

            if (pos1 == -1) {
                Aux = new AuxEst(dataAvaria);
                pos1 = gerir.pesquisarAvariaAno(A.getDataAvaria());
                gerir.adicionarauEst(Aux);
            } else {
                Aux = gerir.obteradicionarauEst(pos1);
            }

            Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);

            Aux.setNumEquipAvarias(Aux.getNumEquipAvarias() + 1);

            System.out.println("\n------Registada Avaria com sucesso!------\n");

        } else if (EQ.getEstado() == 2) {
            System.err.println("Este equipamento já está avariado, é impossivel registar outra avaria!\n");
        } else if (EQ.getEstado() == 3) {
            System.err.println("Este equipamento já foi abatido, é impossivel registar avarias!\n");
        }
    }

    public static void registarEquipamento(Gestor gerir) {
        Equipamento EQ;
        Calendar dataIventario = Calendar.getInstance();

        String descricao;
        int numSerie;
        TipoEquipamento T;
        Escola E;
        FuncionarioNaoDocente ND;
        int custo;
        int pos;
        int idtipoEquipamento;
        int nif;

        System.out.println(gerir.listarEscolaNome());
        do {
            nif = Consola.lerInt("Indique o NIF da escola que possui o equipamento : ", 1, 999999999);
            pos = gerir.pesquisarEscolaNIF(nif);
            if (pos == -1) {
                System.err.println("Escola não existe!");
            }
        } while (pos == -1);
        E = gerir.obterEscola(pos);

        System.out.println(gerir.listarTecnicosEscola(E));
        do {
            nif = Consola.lerInt("Indique o NIF do funcionário da escola " + E.getNome() + " que está a registar equipamento: ", 1, 999999999);
            pos = gerir.pesquisarNaoDocenteTecnico(nif, E);
            if (pos == -1) {
                System.err.println("NIF não existe ou o funcionário não é tecnico da escola!");
            }
        } while (pos == -1);
        ND = gerir.obterFuncionarioNaoDocente(pos);

        descricao = Consola.lerString("\nDescrição do equipamento: ");
        numSerie = Consola.lerInt("Indique o número de série do equipamento: ", 0, 999999999);  /// Alterar min / max no fim

        System.out.println(gerir.listartiposEquipamento());
        do {
            idtipoEquipamento = Consola.lerInt("Indique o ID do tipo de equipamento para associar ao equipamento: ", 0, 999999999);
            pos = gerir.pesquisarIdTipoEquipamento(idtipoEquipamento);
            if (pos == -1) {
                System.err.println("Não existe esse tipo de equipamento!");
            }
        } while (pos == -1);
        T = gerir.obterTipoEquipamento(pos);

        custo = Consola.lerInt("Custo do equipamento em euros: ", 0, 999999999); //aidicionar a um var de custos totais

        EQ = new Equipamento(dataIventario, descricao, numSerie, T, E, custo, ND, 1);
        gerir.adicionarEquipamento(EQ);
        E.adicionarEquipamento(EQ);
        T.adicionarEquipamento(EQ);

        System.out.println("\n------Registado Equipamento com sucesso!------\n");

    }

    public static void associarLabEquipamento(Gestor gerir) {

        int id;
        int pos;
        Laboratorio L;
        Equipamento EQ;
        String descricao;

        System.out.println(gerir.ListarEquipamentos());
        do {
            id = Consola.lerInt("Indique o ID do equipamento o qual pretende associar ao laboratório: ", 0, 999999999);
            pos = gerir.pesquisarIdEquipamento(id);
            if (pos == -1) {
                System.err.println("Não existe equipamento com esse ID!");
            }
        } while (pos == -1);

        EQ = gerir.obterEquipamento(pos);

        if (EQ.getLab() != null) {
            System.err.println("Este equipamento já tem laboratório associado!\n");
            return;
        }

        System.out.println(gerir.listarLaboratorioEscola(EQ.getE()));
        do {
            descricao = Consola.lerString("Indique a descrição do laboratório ao qual pretende associar: ");
            pos = gerir.pesquisarLabDescEscola(descricao, EQ.getE());
            if (pos == -1) {
                System.err.println("Não existe laboratório com essa descrição na escola do equipamento!");
            }
        } while (pos == -1);

        L = gerir.obterLaboratorio(pos);

        EQ.setLab(L);
        L.adicionarEquipamento(EQ);

    }

    public static void consultarEquipamentoNumero(Gestor gerir) {

        Equipamento EQ;
        int id;
        int pos;

        System.out.println(gerir.ListarEquipamentos());
        do {
            id = Consola.lerInt("Indique o ID do equipamento a consultar: ", 1, 999999999);
            pos = gerir.pesquisarIdEquipamento(id);
            if (pos == -1) {
                System.err.println("Equipamento não existe!");
            }
        } while (pos == -1);
        EQ = gerir.obterEquipamento(pos);
        System.out.println(EQ);

    }

    public static void inserirTiposEquipamento(Gestor gerir) {

        String designacao;
        TipoEquipamento TE;

        designacao = Consola.lerString("\nIndique a designação do tipo de equipamento: ");
        TE = new TipoEquipamento(designacao);
        gerir.adicionarTipoEquipamento(TE);
        System.out.println("\n------Inserido tipo de equipamento com sucesso!------\n");

    }

    public static void consultarTiposEquipamentos(Gestor gerir) {
        int id;
        int pos;

        System.out.println(gerir.listartiposEquipamento());;

        do {
            id = Consola.lerInt("Indique o ID a consultar: ", 0, 999999999);
            pos = gerir.pesquisarIdTipoEquipamento(id);
            if (pos == -1) {
                System.err.println("Não existe tipo de equipamento com esse ID!");
            }
        } while (pos == -1);

        System.out.println(gerir.obterTipoEquipamento(pos) + "\n");

    }

    public static void inserirEscola(Gestor gerir) {
        Escola E;
        int pos;
        int nif;
        int telefone;
        int validarEmail;
        String nome;
        String morada;
        String email;
        int ano;
        Calendar dataInicioServico = new GregorianCalendar();

        do {
            nif = Consola.lerInt("\nIndique o NIF da escola a adicionar: ", 0, 999999999);
            pos = gerir.pesquisarEscolaNIF(nif);
            if (pos != -1) {
                System.err.println("Já existe uma escola com esse NIF!");
            }
        } while (pos != -1);

        do {
            nome = Consola.lerString("Indique o nome da escola: ");
            pos = gerir.pesquisarEscola(nome);
            if (pos != -1) {
                System.err.println("Já existe uma escola com esse nome!");
            }
        } while (pos != -1);

        morada = Consola.lerString("Indique a morada da escola: ");
        telefone = Consola.lerInt("Indique o número de telefone: ", 0, 999999999);

        do {
            email = Consola.lerString("Indique o email: ");
            validarEmail = gerir.validarEmail(email);
            if (validarEmail == -1) {
                System.err.println("O email tem de conter um @!");
            }
        } while (validarEmail == -1);

        ano = Consola.lerInt("Indique o ano de início de funcionamento da escola: ", 1, 2999);
        dataInicioServico.set(1, ano);

        E = new Escola(nome, nif, morada, telefone, email, dataInicioServico);
        gerir.adicionarEscola(E);
        System.out.println("\n------Inserida escola com sucesso!------");
        System.out.println(E);
    }

    public static void consulaEscolaNIF(Gestor gerir) {
        int nif;
        int pos;
        Escola E;

        do {
            nif = Consola.lerInt("\nIndique o NIF  a consultar: ", 0, 999999999);
            pos = gerir.pesquisarEscolaNIF(nif);
            if (pos == -1) {
                System.err.println("Não existe escola com esse NIF!");
            }
        } while (pos == -1);
        E = gerir.obterEscola(pos);
        System.out.println(E);
        System.out.print(E.listarFuncionariosEscola());

    }

    public static void inserirFuncionario(Gestor gerir) {
        FuncionarioDocente D;
        FuncionarioNaoDocente ND;
        int pos;
        int nif, nifE;
        int telefone;
        String nome;
        String morada;
        char docente;
        String opcoes = "SNsn";
        String email;
        int validarEmail;
        String habilitacoes;
        Escola escolaTrabalho;
        String dataNasc;
        int errodi;
        Calendar dataDeNascimento = new GregorianCalendar();
        String departamento;
        String funcao;
        int idade;

        do {
            nif = Consola.lerInt("\nIndique o NIF do funcionario a adicionar: ", 0, 999999999);
            pos = gerir.pesquisarFuncionarioNIF(nif);
            if (pos != -1) {
                System.err.println("Este NIF já foi registado, deve ser inserido outro!");
            }
        } while (pos != -1);

        nome = Consola.lerString("Indique o nome do funcionário: ");
        morada = Consola.lerString("Indique a morada do funcionário: ");
        telefone = Consola.lerInt("Indique o número de telefone: ", 0, 999999999);
        do {
            email = Consola.lerString("Indique o email: ");
            validarEmail = gerir.validarEmail(email);
            if (validarEmail == -1) {
                System.err.println("O email tem de conter um @!");
            }
        } while (validarEmail == -1);

        do {
            do {
                errodi = 0;
                try {
                    dataNasc = Consola.lerString("Data de nascimento do funcionário (dd-mm-yyyy): ");

                    dataDeNascimento.setTime(formato.parse(dataNasc));

                } catch (ParseException e) {
                    errodi = 1;
                    System.err.println("Data de nascimento do funcionário com formato inválido!");
                }
            } while (errodi == 1);

            Calendar dataHoje = Calendar.getInstance();
            idade = dataHoje.get(Calendar.YEAR) - dataDeNascimento.get(Calendar.YEAR);
            if (dataHoje.get(Calendar.DAY_OF_YEAR) < dataDeNascimento.get(Calendar.DAY_OF_YEAR)) {
                idade--;
            }
            if (idade < 18) {
                System.err.println("O funcionário tem de ter +18 anos!");
            }

        } while (idade < 18);

        habilitacoes = Consola.lerString("Indique as habilitações do funcionário: ");
        do {
            System.out.println(gerir.listarEscolaNome());
            nifE = Consola.lerInt("Indique NIF da escola onde o funcionário vai trabalhar: ", 1, 999999999);

            pos = gerir.pesquisarEscolaNIF(nifE);

            if (pos == -1) {
                System.err.println("Escola não existe!");
            }
        } while (pos == -1);

        escolaTrabalho = gerir.obterEscola(pos);

        docente = Consola.lerChar("O funcionário é docente Sim(S) ou Não(N)?: ", opcoes);
        if (docente == 's' || docente == 'S') {

            departamento = Consola.lerString("Indique o departamento do docente: ");
            D = new FuncionarioDocente(nome, morada, nif, email, telefone, dataDeNascimento, habilitacoes, escolaTrabalho, departamento);
            gerir.adicionarDocente(D);
            escolaTrabalho.adicionarFuncionario(D);

        } else {

            funcao = Consola.lerString("Indique a função do não docente: ");
            ND = new FuncionarioNaoDocente(nome, morada, nif, email, telefone, dataDeNascimento, habilitacoes, escolaTrabalho, funcao);
            gerir.adicionarNaoDocente(ND);
            escolaTrabalho.adicionarFuncionario(ND);
        }

        System.out.println("\n------Inserido funcionario com sucesso!------");
    }

    public static void alterarFuncionario(Gestor gerir) {
        int pos;
        int telefone;
        String morada;
        Funcionario func;

        pos = consultaFuncionarioNIF(gerir);
        func = gerir.obterFuncionario(pos);
        morada = Consola.lerString("Indique a morada do funcionário: ");
        telefone = Consola.lerInt("Indique o número de telefone: ", 0, 999999999);
        func.setMorada(morada);
        func.setTelefone(telefone);
        System.out.println("\nFuncionário alterado com sucesso!\n");
    }

    public static void eliminarFuncionarioNIF(Gestor gerir) {
        int pos;
        Funcionario func;
        int nif;
        char opcao = 0;

        System.out.println(gerir.listarFuncionarios());

        nif = Consola.lerInt("\nIndique o NIF  do funcionário a eliminar: ", 0, 999999999);
        pos = gerir.pesquisarFuncionarioNIF(nif);
        if (pos != -1) {
            System.out.println(gerir.obterFuncionario(pos));
            opcao = Consola.lerChar("Deseja mesmo eliminar o funcionário Sim(S) ou Não(N)?: ", "SsnN");
        }
        if (pos == -1) {
            System.err.println("Não existe funcionário com esse NIF!");
            System.err.println("Ou o funcionário já foi eliminado!\n");
        } else if (opcao == 'S' || opcao == 's') {
            func = gerir.obterFuncionario(pos);
            gerir.removerFuncionario(pos);
            func.getEscolaTrabalho().removerFuncionario(func);
            System.out.println("Funcionário removido com sucesso!\n");
        } else {
            System.out.println("Funcionário não foi removido!\n");
        }
    }

    public static int consultaFuncionarioNIF(Gestor gerir) {
        int nif;
        int pos;

        do {
            nif = Consola.lerInt("\nIndique o NIF  a consultar: ", 0, 999999999);
            pos = gerir.pesquisarFuncionarioNIF(nif);
            if (pos == -1) {
                System.err.println("Não existe funcionário com esse NIF!");
            }
        } while (pos == -1);
        System.out.println(gerir.obterFuncionario(pos));
        return pos;

    }

    public static void inserirLaboratorio(Gestor gerir) {
        Laboratorio L;
        String descricao;
        String escolaLoc;
        Escola escolaLab;
        int pos;
        int nifE;

        do {
            descricao = Consola.lerString("\nDescrição do laboratório: ");
            pos = gerir.pesquisarLabDesc(descricao);
            if (pos != -1) {
                System.err.println("A descrição tem de ser única por laboratório!");
            }
        } while (pos != -1);

        do {
            System.out.println(gerir.listarEscolaNome());
            nifE = Consola.lerInt("\nIndique o NIF da escola onde o laboratório irá ficar: ", 1, 999999999);

            pos = gerir.pesquisarEscolaNIF(nifE);

            if (pos == -1) {
                System.err.println("Escola não existe!");

            }
        } while (pos == -1);

        escolaLab = gerir.obterEscola(pos);

        escolaLoc = Consola.lerString("Localização do laboratório na escola: ");

        L = new Laboratorio(descricao, escolaLab, escolaLoc);
        gerir.adicionarLaboratorio(L);
        escolaLab.adicionarLaboratorio(L);

        System.out.println("\n------Inserido laboratório com sucesso!------\n");

    }

    public static void consultarLaboratorioEscola(Gestor gerir) {
        int nif;
        int pos;

        do {
            nif = Consola.lerInt("\nIndique o NIF  a consultar: ", 0, 999999999);
            pos = gerir.pesquisarEscolaNIF(nif);
            if (pos == -1) {
                System.err.println("Não existe escola com esse NIF!");
            } else {
                ///????
                System.out.println(gerir.obterLaboratorio(pos));
            }

        } while (pos == -1);

    }

    public static void consultarLaboratorioDescricao(Gestor gerir) {
        String descricao;
        int pos;

        do {
            descricao = Consola.lerString("\nIndique a descrição do laboratório a consultar: ");
            pos = gerir.pesquisarLabDesc(descricao);

            if (pos == -1) {
                System.err.println("Não existe nenhum laboratório com essa descrição!");
            } else {
                System.out.println(gerir.obterLaboratorio(pos));
            }

        } while (pos == -1);

    }

    public static int menuLabConsulta() {
        int opcao;
        System.out.println("1 - Consular laboratorios por designação");
        System.out.println("2 - Consular laboratorios por Escola");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 2);
        return opcao;
    }

    public static int menu() {
        int opcao;
        System.out.println("\n\t\t********Gestao de Equipamentos de Escolas********");
        System.out.println("Numero de Escolas: " + gerir.getSizeEscolas());
        System.out.println("Numero Funcionarios: " + gerir.getSizeFuncionarios());
        System.out.println("Numero Docentes: " + gerir.getSizeDocentes());
        System.out.println("Numero Nao Docentes " + gerir.getSizeNaoDocentes());
        System.out.println("\n1 - Gestão Escolas");
        System.out.println("2 - Gestão de Funcionarios");
        System.out.println("3 - Gestão de Laboratórios");
        System.out.println("4 - Gestão de Tipos de equipamento");
        System.out.println("5 - Gestão de Equipamentos");
        System.out.println("6 - Gestao de Avarias");
        System.out.println("7 - Estatísticas");
        System.out.println("0 - Sair");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 7);
        return opcao;
    }

    public static int menuEstatisticas() {
        int opcao;
        System.out.println("1 -  Percentagem de equipamentos com avarias no agrupamento.");
        System.out.println("2 -  Total de avarias registadas por estado num determinado ano");
        System.out.println("3 -  Total gasto por ano em equipamentos em cada escola");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 3);
        return opcao;
    }

    public static int gestaoAvarias() {
        int opcao;
        System.out.println("1 - Registar Avaria");
        System.out.println("2 - Alterar Estado da Avaria");
        System.out.println("3 - Consultar Avaria por numero de equipamento");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 3);
        return opcao;
    }

    public static int gestaoEquipamentos() {
        int opcao;
        System.out.println("1 - Registar Equipamento");
        System.out.println("2 - Associar Laboratório");
        System.out.println("3 - Consultar por Id");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 3);
        return opcao;
    }

    public static int gestaoTiposEquipamento() {
        int opcao;
        System.out.println("1 - Inserir tipo de equipamento");
        System.out.println("2 - Consultar tipos de equipamento");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 3);
        return opcao;
    }

    public static int gestaoLaboratorios() {
        int opcao;
        System.out.println("1 - Inserir laboratório");
        System.out.println("2 - Consultar informaçao de um laboratório");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 3);
        return opcao;
    }

    public static int gestaoFuncionarios() {
        int opcao;
        System.out.println("1 - Inserir Funcionario");
        System.out.println("2 - Alterar Funcionario");
        System.out.println("3 - Consultar Funcionarios");
        System.out.println("4 - Eliminar");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 4);
        return opcao;
    }

    public static int gestaoEscolas() {
        int opcao;
        System.out.println("1 - Inserir Escola");
        System.out.println("2 - Consultar por NIF");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 3);
        return opcao;
    }

}
