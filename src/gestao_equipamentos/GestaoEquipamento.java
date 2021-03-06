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
 * Classe Gestão de Equipamentos, exibe e recebe dados do utilizador
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class GestaoEquipamento {

    public static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    public static Gestor gerir = new Gestor();

    /**
     * Método main, classe pricipal
     *
     * @param args
     */
    public static void main(String[] args) {

        gerir.lerFicheiro();
        //testes(gerir);
        //testes1(gerir, 0);
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
                                if (gerir.getSizeFuncionarios() != 0) {
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
                            case 4:
                                if (gerir.getSizeEquipamento() != 0 && gerir.getSizeLaboratorio() != 0) {
                                    consultarEquipamentoLab(gerir);
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
                                System.out.println("\nPercentagem de Equipamentos com avarias no agrupamento " + gerir.percEquipAvariaAgrup() + "%\n");
                                break;
                            case 2:
                                System.out.println(gerir.avariasRegistadasPorOrdemCrescenteTotal());
                                break;
                            case 3:
                                System.out.println(gerir.totalGastoAnoEqEscola());
                                break;
                        }
                    } while (op2 != 0);

                    break;
                case 0:
                    gerir.gravarFicheiro();
                    System.err.println("O programa terminou...");
                    System.exit(0);
            }
            Consola.sc.nextLine();
        } while (op != 0);
    }

    /**
     * Método para testes, adicionava objetos aos arrays de modo a ser mais
     * fácil o debug
     *
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
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

        FuncionarioDocente F4 = new FuncionarioDocente("Manuel", "Cona da tia", 5, "@com", 9145, dataIventario, "Mestrado", E, "EEC");
        gerir.adicionarDocente(F4);
        E.adicionarFuncionario(F4);

        FuncionarioNaoDocente F5 = new FuncionarioNaoDocente("Duarte", "morada", 6, "gmail@com", 91, dataIventario, "12", E, "tecnico");
        gerir.adicionarNaoDocente(F5);
        E.adicionarFuncionario(F5);

        Laboratorio L = new Laboratorio("LAB-INFORMATICA", E, "Perto do chao");
        gerir.adicionarLaboratorio(L);
        E.adicionarLaboratorio(L);

        Laboratorio L1 = new Laboratorio("LAB-ELETRO", E, "No paraiso");
        gerir.adicionarLaboratorio(L1);
        E.adicionarLaboratorio(L1);

        Laboratorio L2 = new Laboratorio("LAB-TESTE", E1, "No caralho");
        gerir.adicionarLaboratorio(L2);
        E1.adicionarLaboratorio(L2);

        TipoEquipamento TipoEQ = new TipoEquipamento("Eletronica");
        gerir.adicionarTipoEquipamento(TipoEQ);
        TipoEquipamento TipoEQ1 = new TipoEquipamento("Mecanica");
        gerir.adicionarTipoEquipamento(TipoEQ1);
        TipoEquipamento TipoEQ2 = new TipoEquipamento("Informatica");
        gerir.adicionarTipoEquipamento(TipoEQ2);

        data2.set(1, 2016);
        data3.set(1, 2017);
        data4.set(1, 2019);

        AuxEst2 auxGastos;

        Equipamento EQ = new Equipamento(dataIventario, "PC", 99999, TipoEQ, E, 52, F, 1);
        gerir.adicionarEquipamento(EQ);
        TipoEQ.adicionarEquipamento(EQ);

        pos = gerir.pesquisarAnoGastos(E, EQ.getDataIventario());
        if (pos == -1) {
            auxGastos = new AuxEst2(EQ.getDataIventario());
            EQ.getE().adicionarAnoGastos(auxGastos);
        } else {
            auxGastos = EQ.getE().obterAnoGastos(pos);
        }

        auxGastos.aumentaGastosAno(52);

        Equipamento EQ1 = new Equipamento(dataIventario, "Impresora", 11111, TipoEQ1, E1, 12, F2, 1);
        gerir.adicionarEquipamento(EQ1);
        TipoEQ1.adicionarEquipamento(EQ);

        pos = gerir.pesquisarAnoGastos(E1, EQ1.getDataIventario());
        if (pos == -1) {
            auxGastos = new AuxEst2(EQ1.getDataIventario());
            EQ1.getE().adicionarAnoGastos(auxGastos);
        } else {
            auxGastos = EQ1.getE().obterAnoGastos(pos);
        }

        auxGastos.aumentaGastosAno(12);

        Equipamento EQ2 = new Equipamento(dataIventario, "rato", 5454, TipoEQ1, E1, 12, F2, 1);
        gerir.adicionarEquipamento(EQ2);
        TipoEQ1.adicionarEquipamento(EQ);

        pos = gerir.pesquisarAnoGastos(E1, EQ2.getDataIventario());
        if (pos == -1) {
            auxGastos = new AuxEst2(EQ2.getDataIventario());
            EQ2.getE().adicionarAnoGastos(auxGastos);
        } else {
            auxGastos = EQ2.getE().obterAnoGastos(pos);
        }

        auxGastos.aumentaGastosAno(12);

        Equipamento EQ3 = new Equipamento(dataIventario, "caneta", 11111, TipoEQ2, E, 12, F2, 1);
        gerir.adicionarEquipamento(EQ3);
        TipoEQ2.adicionarEquipamento(EQ);

        pos = gerir.pesquisarAnoGastos(E, EQ3.getDataIventario());
        if (pos == -1) {
            auxGastos = new AuxEst2(EQ3.getDataIventario());
            EQ3.getE().adicionarAnoGastos(auxGastos);
        } else {
            auxGastos = EQ3.getE().obterAnoGastos(pos);
        }

        auxGastos.aumentaGastosAno(12);

        Equipamento EQ4 = new Equipamento(dataIventario, "telemovel", 11111, TipoEQ2, E1, 52, F2, 1);
        gerir.adicionarEquipamento(EQ4);
        TipoEQ2.adicionarEquipamento(EQ);

        pos = gerir.pesquisarAnoGastos(E1, EQ4.getDataIventario());
        if (pos == -1) {
            auxGastos = new AuxEst2(EQ4.getDataIventario());
            EQ1.getE().adicionarAnoGastos(auxGastos);
        } else {
            auxGastos = EQ4.getE().obterAnoGastos(pos);
        }

        auxGastos.aumentaGastosAno(12);

        AuxEst Aux;

        Avaria A = new Avaria(dataIventario, EQ, "avaria", F, 1, false);
        gerir.adicionarAvaria(A);

        pos1 = gerir.pesquisarAvariaAno(A.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A.getDataAvaria());
            //pos1 = gerir.pesquisarAvariaAno(A.getDataAvaria());
            gerir.adicionarAuxEst(Aux);
        } else {
            Aux = gerir.obterAuxEst(pos1);
        }

        Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
        gerir.adicionaNumEQAvariaTotal(EQ);
        EQ.adicionarAvaria(A);

        Avaria A1 = new Avaria(data2, EQ, "avaria1", F, 2, true);
        gerir.adicionarAvaria(A1);

        pos1 = gerir.pesquisarAvariaAno(A1.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A1.getDataAvaria());
            gerir.adicionarAuxEst(Aux);
        } else {
            Aux = gerir.obterAuxEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
        Aux.setNumAvariasReparadas(Aux.getNumAvariasReparadas() + 1);
        gerir.adicionaNumEQAvariaTotal(EQ);
        EQ.adicionarAvaria(A1);
        Reparacao R = new Reparacao(A1, data2, "reparação", 10, F);
        gerir.adicionarReparacao(R);
        EQ.adicionarReparacao(R);
        pos = gerir.pesquisarAnoGastos(E, data2);
        if (pos == -1) {
            auxGastos = new AuxEst2(data2);
            E.adicionarAnoGastos(auxGastos);
        } else {
            auxGastos = E.obterAnoGastos(pos);
        }

        auxGastos.aumentaGastosAno(10);

        Avaria A2 = new Avaria(data3, EQ, "avaria2", F, 2, true);
        gerir.adicionarAvaria(A2);
        pos1 = gerir.pesquisarAvariaAno(A2.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A2.getDataAvaria());
            gerir.adicionarAuxEst(Aux);
        } else {
            Aux = gerir.obterAuxEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
        Aux.setNumAvariasReparadas(Aux.getNumAvariasReparadas() + 1);
        gerir.adicionaNumEQAvariaTotal(EQ);
        EQ.adicionarAvaria(A2);
        R = new Reparacao(A2, data3, "reparação", 10, F);
        gerir.adicionarReparacao(R);
        EQ.adicionarReparacao(R);
        pos = gerir.pesquisarAnoGastos(E, data3);
        if (pos == -1) {
            auxGastos = new AuxEst2(data3);
            E.adicionarAnoGastos(auxGastos);
        } else {
            auxGastos = E.obterAnoGastos(pos);
        }

        auxGastos.aumentaGastosAno(10);

        Avaria A3 = new Avaria(data4, EQ, "avaria3", F, 2, true);
        gerir.adicionarAvaria(A3);
        pos1 = gerir.pesquisarAvariaAno(A3.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A3.getDataAvaria());
            gerir.adicionarAuxEst(Aux);
        } else {
            Aux = gerir.obterAuxEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
        Aux.setNumAvariasReparadas(Aux.getNumAvariasReparadas() + 1);
        gerir.adicionaNumEQAvariaTotal(EQ);
        EQ.adicionarAvaria(A3);
        R = new Reparacao(A3, data4, "reparação", 10, F);
        gerir.adicionarReparacao(R);
        EQ.adicionarReparacao(R);
        pos = gerir.pesquisarAnoGastos(E, data4);
        if (pos == -1) {
            auxGastos = new AuxEst2(data4);
            E.adicionarAnoGastos(auxGastos);
        } else {
            auxGastos = E.obterAnoGastos(pos);
        }

        auxGastos.aumentaGastosAno(10);

        Avaria A4 = new Avaria(data2, EQ, "avaria4", F, 2, true);
        gerir.adicionarAvaria(A4);
        pos1 = gerir.pesquisarAvariaAno(A4.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A4.getDataAvaria());
            gerir.adicionarAuxEst(Aux);
        } else {
            Aux = gerir.obterAuxEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
        Aux.setNumAvariasReparadas(Aux.getNumAvariasReparadas() + 1);
        gerir.adicionaNumEQAvariaTotal(EQ);
        EQ.adicionarAvaria(A4);
        R = new Reparacao(A4, data2, "reparação", 10, F);
        gerir.adicionarReparacao(R);
        EQ.adicionarReparacao(R);
        pos = gerir.pesquisarAnoGastos(E, data2);
        if (pos == -1) {
            auxGastos = new AuxEst2(data2);
            E.adicionarAnoGastos(auxGastos);
        } else {
            auxGastos = E.obterAnoGastos(pos);
        }

        auxGastos.aumentaGastosAno(10);

        Avaria A5 = new Avaria(data3, EQ, "avaria5", F, 3, true);
        gerir.adicionarAvaria(A5);
        pos1 = gerir.pesquisarAvariaAno(A5.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A5.getDataAvaria());
            gerir.adicionarAuxEst(Aux);
        } else {
            Aux = gerir.obterAuxEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
        Aux.setNumAvariasIrreparaveis(Aux.getNumAvariasIrreparaveis() + 1);
        gerir.adicionaNumEQAvariaTotal(EQ);
        EQ.adicionarAvaria(A5);

        Avaria A6 = new Avaria(data3, EQ, "avaria6", F, 3, true);
        gerir.adicionarAvaria(A6);
        pos1 = gerir.pesquisarAvariaAno(A6.getDataAvaria());
        if (pos1 == -1) {
            Aux = new AuxEst(A6.getDataAvaria());
            gerir.adicionarAuxEst(Aux);
        } else {
            Aux = gerir.obterAuxEst(pos1);
        }
        Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
        Aux.setNumAvariasIrreparaveis(Aux.getNumAvariasIrreparaveis() + 1);
        gerir.adicionaNumEQAvariaTotal(EQ);
        EQ.adicionarAvaria(A6);

        Reparacao R1 = new Reparacao(A6, data2, "reparação", 10, F);
        gerir.adicionarReparacao(R1);
        EQ.adicionarReparacao(R1);
    }

    /**
     * Método para testes, adicionava objetos aos arrays de modo a ser mais
     * fácil o debug
     *
     * @param gerir
     * @param nrAvariasAdicionar
     */
    public static void testes1(Gestor gerir, int nrAvariasAdicionar) {

        Equipamento EQ1, EQ2, EQ3, EQ4;

        AuxEst2 auxGastos;
        AuxEst Aux;

        Equipamento passaEQ;

        Calendar passaData;
        Calendar data = new GregorianCalendar();
        data.set(1, 1990);
        Calendar data1 = new GregorianCalendar();
        data1.set(1, 2016);
        Calendar data2 = new GregorianCalendar();
        data2.set(1, 2017);
        Calendar data3 = new GregorianCalendar();
        data3.set(1, 2018);
        Calendar data4 = new GregorianCalendar();
        data4.set(1, 2019);

        TipoEquipamento T1 = new TipoEquipamento("tipo 1");
        TipoEquipamento T2 = new TipoEquipamento("tipo 2");
        TipoEquipamento T3 = new TipoEquipamento("tipo 3");
        TipoEquipamento T4 = new TipoEquipamento("tipo 4");

        String descricao = "teste";

        FuncionarioNaoDocente ND;

        int custo1 = 20, custo2 = 40, custo3 = 50, custo4 = 30;
        int nif, pos;
        StringBuilder str = new StringBuilder("");
        String nome;

        gerir.adicionarTipoEquipamento(T1);
        gerir.adicionarTipoEquipamento(T2);
        gerir.adicionarTipoEquipamento(T3);
        gerir.adicionarTipoEquipamento(T4);

        Escola E1 = new Escola("E1", 1, "a", 1, "@", data);
        gerir.adicionarEscola(E1);
        Escola E2 = new Escola("E2", 2, "a", 1, "@", data);
        gerir.adicionarEscola(E2);
        Escola E3 = new Escola("E3", 3, "a", 1, "@", data);
        gerir.adicionarEscola(E3);
        Escola E4 = new Escola("E4", 4, "a", 1, "@", data);
        gerir.adicionarEscola(E4);

        nif = 1;
        for (int i = 0; i < gerir.getSizeEscolas(); i++) {
            Escola E = gerir.obterEscola(i);
            nome = str.append("aa").append(i).toString();
            FuncionarioDocente D1 = new FuncionarioDocente(nome, "a", nif, "@", 1, data, "12ano", E, "departamento");
            gerir.adicionarDocente(D1);
            E.adicionarFuncionario(D1);
            nif++;

            str = new StringBuilder("");
            nome = str.append("ab").append(i).toString();
            FuncionarioDocente D2 = new FuncionarioDocente(nome, "a", nif, "@", 1, data, "12ano", E, "departamento");
            gerir.adicionarDocente(D2);
            E.adicionarFuncionario(D2);
            nif++;

            str = new StringBuilder("");
            nome = str.append("ac").append(i).toString();
            FuncionarioDocente D3 = new FuncionarioDocente(nome, "a", nif, "@", 1, data, "12ano", E, "departamento");
            gerir.adicionarDocente(D3);
            E.adicionarFuncionario(D3);
            nif++;

            str = new StringBuilder("");
            nome = str.append("ad").append(i).toString();
            FuncionarioDocente D4 = new FuncionarioDocente(nome, "a", nif, "@", 1, data, "12ano", E, "departamento");
            gerir.adicionarDocente(D4);
            E.adicionarFuncionario(D4);
            nif++;

            str = new StringBuilder("");
            nome = str.append("ae").append(i).toString();
            FuncionarioNaoDocente ND1 = new FuncionarioNaoDocente(nome, "a", nif, "@", 1, data, "12ano", E, "tecnico");
            gerir.adicionarNaoDocente(ND1);
            E.adicionarFuncionario(ND1);
            nif++;

            str = new StringBuilder("");
            nome = str.append("af").append(i).toString();
            FuncionarioNaoDocente ND2 = new FuncionarioNaoDocente(nome, "a", nif, "@", 1, data, "12ano", E, "tecnico");
            gerir.adicionarNaoDocente(ND2);
            E.adicionarFuncionario(ND2);
            nif++;

            str = new StringBuilder("");
            nome = str.append("ag").append(i).toString();
            FuncionarioNaoDocente ND3 = new FuncionarioNaoDocente(nome, "a", nif, "@", 1, data, "12ano", E, "tecnico");
            gerir.adicionarNaoDocente(ND3);
            E.adicionarFuncionario(ND3);
            nif++;

            str = new StringBuilder("");
            nome = str.append("ah").append(i).toString();
            FuncionarioNaoDocente ND4 = new FuncionarioNaoDocente(nome, "a", nif, "@", 1, data, "12ano", E, "tecnico");
            gerir.adicionarNaoDocente(ND4);
            E.adicionarFuncionario(ND4);
            nif++;

            str = new StringBuilder("");
            nome = str.append("ai").append(i).toString();
            FuncionarioNaoDocente ND5 = new FuncionarioNaoDocente(nome, "a", nif, "@", 1, data, "12ano", E, "limpa");
            gerir.adicionarNaoDocente(ND5);
            E.adicionarFuncionario(ND5);
            nif++;

            str = new StringBuilder("");
            nome = str.append("aj").append(i).toString();
            FuncionarioNaoDocente ND6 = new FuncionarioNaoDocente(nome, "a", nif, "@", 1, data, "12ano", E, "limpa");
            gerir.adicionarNaoDocente(ND6);
            E.adicionarFuncionario(ND6);
            nif++;

            str = new StringBuilder("");
            nome = str.append("lab1").append(" - ").append(E.getNome()).toString();
            Laboratorio L1 = new Laboratorio(nome, E, "loc1");
            gerir.adicionarLaboratorio(L1);
            E.adicionarLaboratorio(L1);

            str = new StringBuilder("");
            nome = str.append("lab2").append(" - ").append(E.getNome()).toString();
            Laboratorio L2 = new Laboratorio(nome, E, "loc2");
            gerir.adicionarLaboratorio(L2);
            E.adicionarLaboratorio(L2);

            str = new StringBuilder("");
            nome = str.append("lab3").append(" - ").append(E.getNome()).toString();
            Laboratorio L3 = new Laboratorio(nome, E, "loc3");
            gerir.adicionarLaboratorio(L3);
            E.adicionarLaboratorio(L3);

            str = new StringBuilder("");
            nome = str.append("lab4").append(" - ").append(E.getNome()).toString();
            Laboratorio L4 = new Laboratorio(nome, E, "loc4");
            gerir.adicionarLaboratorio(L4);
            E.adicionarLaboratorio(L4);

        }

        for (int i = 0; i < gerir.getSizeEscolas(); i++) {
            nif = 0;
            Escola E = gerir.obterEscola(i);
            do {
                nif++;
                pos = gerir.pesquisarNaoDocenteTecnico(nif, E);
            } while (pos == -1);
            ND = gerir.obterFuncionarioNaoDocente(pos);
            EQ1 = new Equipamento(data1, descricao, 1, T1, E, custo1, ND, 1);
            E.adicionarEquipamento(EQ1);
            gerir.adicionarEquipamento(EQ1);
            T1.adicionarEquipamento(EQ1);
            passaData = data1;
            passaEQ = EQ1;
            pos = gerir.pesquisarAnoGastos(E, data1);
            if (pos == -1) {
                auxGastos = new AuxEst2(data1);
                auxGastos.aumentaGastosAno(custo1);
                E.adicionarAnoGastos(auxGastos);
            } else {
                E.aumentaGastosAno(custo1, pos);
            }
            for (int k = 0; k < nrAvariasAdicionar; k++) {
                Avaria A = new Avaria(passaData, passaEQ, "avaria", ND, 1, false);
                gerir.adicionarAvaria(A);
                pos = gerir.pesquisarAvariaAno(passaData);
                if (pos == -1) {
                    Aux = new AuxEst(passaData);
                    gerir.adicionarAuxEst(Aux);
                } else {
                    Aux = gerir.obterAuxEst(pos);
                }
                Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
                gerir.adicionaNumEQAvariaTotal(passaEQ);
                passaEQ.adicionarAvaria(A);
            }

            nif = 0;
            E = gerir.obterEscola(i);
            do {
                nif++;
                pos = gerir.pesquisarNaoDocenteTecnico(nif, E);
            } while (pos == -1);
            ND = gerir.obterFuncionarioNaoDocente(pos);
            EQ2 = new Equipamento(data2, descricao, 1, T2, E, custo2, ND, 1);
            E.adicionarEquipamento(EQ2);
            gerir.adicionarEquipamento(EQ2);
            T2.adicionarEquipamento(EQ2);
            passaData = data2;
            passaEQ = EQ2;
            pos = gerir.pesquisarAnoGastos(E, data2);
            if (pos == -1) {
                auxGastos = new AuxEst2(data2);
                auxGastos.aumentaGastosAno(custo2);
                E.adicionarAnoGastos(auxGastos);
            } else {
                E.aumentaGastosAno(custo2, pos);
            }
            for (int k = 0; k < nrAvariasAdicionar; k++) {
                Avaria A = new Avaria(passaData, passaEQ, "avaria", ND, 1, false);
                gerir.adicionarAvaria(A);
                pos = gerir.pesquisarAvariaAno(passaData);
                if (pos == -1) {
                    Aux = new AuxEst(passaData);
                    gerir.adicionarAuxEst(Aux);
                } else {
                    Aux = gerir.obterAuxEst(pos);
                }
                Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
                gerir.adicionaNumEQAvariaTotal(passaEQ);
                passaEQ.adicionarAvaria(A);
            }

            nif = 0;
            E = gerir.obterEscola(i);
            do {
                nif++;
                pos = gerir.pesquisarNaoDocenteTecnico(nif, E);
            } while (pos == -1);
            ND = gerir.obterFuncionarioNaoDocente(pos);
            EQ3 = new Equipamento(data3, descricao, 1, T3, E, custo3, ND, 1);
            E.adicionarEquipamento(EQ3);
            gerir.adicionarEquipamento(EQ3);
            T3.adicionarEquipamento(EQ3);
            passaData = data3;
            passaEQ = EQ3;
            pos = gerir.pesquisarAnoGastos(E, data3);
            if (pos == -1) {
                auxGastos = new AuxEst2(data3);
                auxGastos.aumentaGastosAno(custo3);
                E.adicionarAnoGastos(auxGastos);
            } else {
                E.aumentaGastosAno(custo3, pos);
            }
            for (int k = 0; k < nrAvariasAdicionar; k++) {
                Avaria A = new Avaria(passaData, passaEQ, "avaria", ND, 1, false);
                gerir.adicionarAvaria(A);
                pos = gerir.pesquisarAvariaAno(passaData);
                if (pos == -1) {
                    Aux = new AuxEst(passaData);
                    gerir.adicionarAuxEst(Aux);
                } else {
                    Aux = gerir.obterAuxEst(pos);
                }
                Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
                gerir.adicionaNumEQAvariaTotal(passaEQ);
                passaEQ.adicionarAvaria(A);
            }

            nif = 0;
            E = gerir.obterEscola(i);
            do {
                nif++;
                pos = gerir.pesquisarNaoDocenteTecnico(nif, E);
            } while (pos == -1);
            ND = gerir.obterFuncionarioNaoDocente(pos);
            EQ4 = new Equipamento(data4, descricao, 1, T4, E, custo4, ND, 1);
            E.adicionarEquipamento(EQ4);
            gerir.adicionarEquipamento(EQ4);
            T4.adicionarEquipamento(EQ4);
            passaData = data4;
            passaEQ = EQ4;
            pos = gerir.pesquisarAnoGastos(E, data4);
            if (pos == -1) {
                auxGastos = new AuxEst2(data4);
                auxGastos.aumentaGastosAno(custo4);
                E.adicionarAnoGastos(auxGastos);
            } else {
                E.aumentaGastosAno(custo4, pos);
            }
            for (int k = 0; k < nrAvariasAdicionar; k++) {
                Avaria A = new Avaria(passaData, passaEQ, "avaria", ND, 1, false);
                gerir.adicionarAvaria(A);
                pos = gerir.pesquisarAvariaAno(passaData);
                if (pos == -1) {
                    Aux = new AuxEst(passaData);
                    gerir.adicionarAuxEst(Aux);
                } else {
                    Aux = gerir.obterAuxEst(pos);
                }
                Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);
                gerir.adicionaNumEQAvariaTotal(passaEQ);
                passaEQ.adicionarAvaria(A);
            }

        }
    }

    /**
     * Método para consultar todas as avarias de um equipamento
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void consultarAvariaEquipamento(Gestor gerir) {
        Equipamento EQ;
        Avaria A;
        int id;
        int pos;

        System.out.println(gerir.listarEquipamentos());
        do {
            id = Consola.lerInt("Indique o ID do equipamento a consultar: ", 1, 999999999);
            pos = gerir.pesquisarIdEquipamento(id);
            if (pos == -1) {
                System.err.println("Equipamento não existe!");
            }
        } while (pos == -1);
        EQ = gerir.obterEquipamento(pos);

        System.out.println(EQ.listarAvarias(EQ));

        if (EQ.avariasEQnotEmpty()) {
            do {
                id = Consola.lerInt("Indique o ID da avaria a consultar: ", 1, 999999999);
                pos = EQ.pesquisarAvariaEQ(id);

                if (pos == -1) {
                    System.err.println("Avaria não existe!");
                }
            } while (pos == -1);

            A = EQ.obterAvaria(pos);

            System.out.println(A + "\n");
        } else {
            System.err.println("O equipamento não tem avarias registadas!\n");
        }
    }

    /**
     * Método para alterar o estado das avarias e registar reparações quando aplicável
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void alterarEstadoAvaria(Gestor gerir) {
        int id;
        int pos;
        Avaria A;
        Calendar dataAtual = Calendar.getInstance();
        Reparacao R;
        int estado;
        int nif;
        Funcionario F;
        String descricao;
        int custo;
        AuxEst Aux;
        AuxEst2 auxGastos;

        System.out.println(gerir.listarAvarias());

        do {
            id = Consola.lerInt("Qual o ID da avaria que deseja alterar: ", 1, 999999999);
            pos = gerir.pesquisarAvariaNAlteradas(id);
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

        do {

            nif = Consola.lerInt("Indique o NIF do funcionário que regista a avaria: ", 1, 999999999);
            pos = gerir.pesquisarNaoDocenteTecnico(nif, A.getEQ().getE());

            if (pos == -1) {
                System.err.println("Não existe funcionário com esse NIF ou não tem como função TECNICO!");
            }
        } while (pos == -1);
        F = gerir.obterFuncionario(gerir.obterFuncionarioNaoDocente(pos));

        System.out.println("1-POR REPARAR / 2- REPARADA / 3-IRREPARÁVEL");

        estado = Consola.lerInt("Indique o novo estado da avaria: ", 1, 3);

        A.setEstadoA(estado);
        A.getEQ().obterAvaria(A).setEstadoA(estado);
        System.out.println("\n------Alterado o estado com sucesso!------\n");

        pos = gerir.pesquisarAvariaAno(dataAtual);
        Aux = gerir.obterAuxEst(pos);

        if (estado != 1) {
            A.setAlterado(true);
            A.getEQ().obterAvaria(A).setAlterado(true);
            A.getF().setVerificaEliminar(true);
        }

        if (estado == 1) {
            A.getEQ().setEstado(2);
        }

        if (estado == 2) {

            descricao = Consola.lerString("Coloque uma breve descrição da reparação: ");
            custo = Consola.lerInt("Custo da reparação em euros: ", 0, 999999999);

            R = new Reparacao(A, dataAtual, descricao, custo, F);
            gerir.adicionarReparacao(R);
            A.getEQ().adicionarReparacao(R);
            A.getEQ().setEstado(1);
            System.out.println("\n------Registada a reparação com sucesso!------\n");
            System.out.println(R);

            Aux.setNumAvariasReparadas(Aux.getNumAvariasReparadas() + 1);

            pos = gerir.pesquisarAnoGastos(A.getEQ().getE(), dataAtual);
            if (pos == -1) {
                auxGastos = new AuxEst2(dataAtual);
                auxGastos.aumentaGastosAno(custo);
                A.getEQ().getE().adicionarAnoGastos(auxGastos);
            } else {
                A.getEQ().getE().aumentaGastosAno(custo, pos);
            }

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

        }

    }

    /**
     * Método para registar novas avarias de equipamento
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void registarAvaria(Gestor gerir) {
        Equipamento EQ;
        Calendar dataAvaria = Calendar.getInstance();
        String descricao;
        Funcionario F;
        Avaria A;
        int id;
        int pos;
        int nif;
        AuxEst Aux;

        System.out.println(gerir.listarEquipamentos());
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

        switch (EQ.getEstado()) {
            case 1:
                System.out.print(EQ.getE().listarFuncionariosEscola());
                do {

                    nif = Consola.lerInt("Indique o NIF do funcionário que regista a avaria: ", 1, 999999999);
                    pos = EQ.getE().pesquisarFuncionarioNIFEscola(nif);

                    if (pos == -1) {
                        System.err.println("Não existe funcionário com esse NIF ou o funcionário não pertence à escola ou não tem como função TECNICO!");
                    }
                } while (pos == -1);

                F = EQ.getE().obterFuncionarioEscola(pos);

                descricao = Consola.lerString("Coloque uma breve descrição da avaria: ");

                gerir.adicionaNumEQAvariaTotal(EQ);

                A = new Avaria(dataAvaria, EQ, descricao, F, 1, false);
                gerir.adicionarAvaria(A);
                EQ.adicionarAvaria(A);

                int pos1;
                pos1 = gerir.pesquisarAvariaAno(dataAvaria);

                if (pos1 == -1) {
                    Aux = new AuxEst(dataAvaria);
                    gerir.adicionarAuxEst(Aux);
                } else {
                    Aux = gerir.obterAuxEst(pos1);
                }

                Aux.setNumAvariasPorReparar(Aux.getNumAvariasPorReparar() + 1);

                System.out.println("\n------Registada Avaria com sucesso!------\n");
                break;
            case 2:
                System.err.println("Este equipamento já está avariado, é impossivel registar outra avaria!\n");
                break;
            case 3:
                System.err.println("Este equipamento já foi abatido, é impossivel registar avarias!\n");
                break;

        }
    }

    /**
     * Método para registar um novo equipamento
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
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
        AuxEst2 auxGastos;

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
        numSerie = Consola.lerInt("Indique o número de série do equipamento: ", 0, 999999999);

        System.out.println(gerir.listarTiposEquipamento());
        do {
            idtipoEquipamento = Consola.lerInt("Indique o ID do tipo de equipamento para associar ao equipamento: ", 0, 999999999);
            pos = gerir.pesquisarIdTipoEquipamento(idtipoEquipamento);
            if (pos == -1) {
                System.err.println("Não existe esse tipo de equipamento!");
            }
        } while (pos == -1);
        T = gerir.obterTipoEquipamento(pos);

        custo = Consola.lerInt("Custo do equipamento em euros: ", 0, 999999999);

        EQ = new Equipamento(dataIventario, descricao, numSerie, T, E, custo, ND, 1);
        gerir.adicionarEquipamento(EQ);
        E.adicionarEquipamento(EQ);
        T.adicionarEquipamento(EQ);

        pos = gerir.pesquisarAnoGastos(E, dataIventario);
        if (pos == -1) {
            auxGastos = new AuxEst2(dataIventario);
            auxGastos.aumentaGastosAno(custo);
            E.adicionarAnoGastos(auxGastos);
        } else {
            E.aumentaGastosAno(custo, pos);
        }

        System.out.println("\n------Registado Equipamento com sucesso!------\n");

    }

    /**
     * Método para associar um laboratório a um laboratório
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void associarLabEquipamento(Gestor gerir) {

        int id;
        int pos;
        Laboratorio L, labAntigo;
        Equipamento EQ;
        String descricao;

        System.out.println(gerir.listarEquipamentos());
        do {
            id = Consola.lerInt("Indique o ID do equipamento o qual pretende associar ao laboratório: ", 0, 999999999);
            pos = gerir.pesquisarIdEquipamento(id);
            if (pos == -1) {
                System.err.println("Não existe equipamento com esse ID!");
            }
        } while (pos == -1);

        EQ = gerir.obterEquipamento(pos);
        labAntigo = EQ.getLab();

        if (EQ.getEstado() == 3) {
            System.err.println("Este equipamento foi abatido, não pode ser associado a um laborátório!");
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
        if (labAntigo != null) {
            labAntigo.removerEquipamento(EQ);
        }
        L.adicionarEquipamento(EQ);

    }

    /**
     * Método para consultar equipamentos por ID
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void consultarEquipamentoNumero(Gestor gerir) {

        Equipamento EQ;
        int id;
        int pos;

        System.out.println(gerir.listarEquipamentos());
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

    /**
     * Método para consulta de equipamentos por laboratório
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void consultarEquipamentoLab(Gestor gerir) {

        int pos;
        String descricao;

        do {
            descricao = Consola.lerString("\nIndique a descrição do laboratório a consultar: ");
            pos = gerir.pesquisarLabDesc(descricao);

            if (pos == -1) {
                System.err.println("Não existe nenhum laboratório com essa descrição!");
            }

        } while (pos == -1);

        System.out.println(gerir.obterLaboratorio(pos).listarEQLab());

    }

    /**
     * Método para inserir um novo tipo de equipamento
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void inserirTiposEquipamento(Gestor gerir) {

        String designacao;
        TipoEquipamento TE;

        designacao = Consola.lerString("\nIndique a designação do tipo de equipamento: ");
        TE = new TipoEquipamento(designacao);
        gerir.adicionarTipoEquipamento(TE);
        System.out.println("\n------Inserido tipo de equipamento com sucesso!------\n");

    }

    /**
     * Método para consulta de tipos de equipamento
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void consultarTiposEquipamentos(Gestor gerir) {
        int id;
        int pos;

        System.out.println(gerir.listarTiposEquipamento());

        do {
            id = Consola.lerInt("Indique o ID a consultar: ", 0, 999999999);
            pos = gerir.pesquisarIdTipoEquipamento(id);
            if (pos == -1) {
                System.err.println("Não existe tipo de equipamento com esse ID!");
            }
        } while (pos == -1);

        System.out.println(gerir.obterTipoEquipamento(pos) + "\n");

    }

    /**
     * Método para inserir uma nova escola
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
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

    /**
     * Método para consultar uma escola por NIF, mostra os seus funcionários e laboratórios
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
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

    /**
     * Método para inserir um novo funcionário
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
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

    /**
     * Métodp para alterar as informações de um funcionário
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void alterarFuncionario(Gestor gerir) {
        int pos;
        int nif;
        int telefone;
        String morada;
        Funcionario func;

        do {
            nif = Consola.lerInt("\nIndique o NIF do funcionário a alterar: ", 0, 999999999);
            pos = gerir.pesquisarFuncionarioNIF(nif);
            if (pos == -1) {
                System.err.println("Não existe funcionário com esse NIF!");
            }
        } while (pos == -1);
        func = gerir.obterFuncionario(pos);
        morada = Consola.lerString("Indique a morada do funcionário: ");
        telefone = Consola.lerInt("Indique o número de telefone: ", 0, 999999999);
        func.setMorada(morada);
        func.setTelefone(telefone);
        System.out.println("\nFuncionário alterado com sucesso!\n");
    }

    /**
     * Método para eliminar um funcionário
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
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
            if (func.isVerificaEliminar() == false) {
                gerir.removerFuncionario(pos);
                func.getEscolaTrabalho().removerFuncionario(func);
                System.out.println("Funcionário removido com sucesso!\n");
            } else {
                System.err.println("O funcionário está associado a um equipamento, avaria ou reparação!");
            }
        } else {
            System.out.println("Funcionário não foi removido!\n");
        }
    }

    /**
     * Método para consulta de um funcionário a partir de um NIF
     *
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void consultaFuncionarioNIF(Gestor gerir) {
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
    }

    /**
     * Método para inserir um novo laboratório
     *
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
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
            nifE = Consola.lerInt("Indique o NIF da escola onde o laboratório irá ficar: ", 1, 999999999);

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

    /**
     * Método par aconsulta de laboratórios por escola
     *
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
    public static void consultarLaboratorioEscola(Gestor gerir) {
        int nif;
        int pos;

        do {
            nif = Consola.lerInt("\nIndique o NIF da escola a consultar: ", 0, 999999999);
            pos = gerir.pesquisarEscolaNIF(nif);
            if (pos == -1) {
                System.err.println("Não existe escola com esse NIF!");
            }

        } while (pos == -1);

        System.out.println(gerir.obterEscola(pos).listarLaboratoriosEscola());

    }

    /**
     * Método para consulta de laboratórios por descrição
     *
     * @param gerir recebe o objeto de gestão com todos os arrays e variáveis
     */
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

    /**
     * Menu para a consulta de laboratórios
     *
     * @return devolve a opção selecionada
     */
    public static int menuLabConsulta() {
        int opcao;
        System.out.println("1 - Consular laboratorios por designação");
        System.out.println("2 - Consular laboratorios por Escola");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 2);
        return opcao;
    }

    /**
     * Menu principal
     *
     * @return devolve a opção selecionada
     */
    public static int menu() {
        int opcao;
        System.out.println("\n\t\t********Gestao de Equipamentos de Escolas********");
        System.out.println("Numero de Escolas: " + gerir.getSizeEscolas());
        System.out.println("Numero Funcionarios: " + gerir.getSizeFuncionarios());
        System.out.println("Numero Docentes: " + gerir.getSizeDocentes());
        System.out.println("Numero Nao Docentes " + gerir.getSizeNaoDocentes());
        System.out.println(gerir.listarTiposEquipamentoMenu());
        System.out.println("1 - Gestão de Escolas");
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

    /**
     * Menu para a exibição de estatísticas
     *
     * @return devolve a opção selecionada
     */
    public static int menuEstatisticas() {
        int opcao;
        System.out.println("1 -  Percentagem de equipamentos com avarias no agrupamento.");
        System.out.println("2 -  Total de avarias registadas por estado num determinado ano");
        System.out.println("3 -  Total gasto por ano em equipamentos em cada escola");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 3);
        return opcao;
    }

    /**
     * Menu para a gestão de avarias e reparações
     *
     * @return devolve a opção selecionada
     */
    public static int gestaoAvarias() {
        int opcao;
        System.out.println("1 - Registar Avaria");
        System.out.println("2 - Alterar Estado da Avaria");
        System.out.println("3 - Consultar Avaria por numero de equipamento");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 3);
        return opcao;
    }

    /**
     * Menu para a gestão de equipamentos
     *
     * @return devolve a opção selecionada
     */
    public static int gestaoEquipamentos() {
        int opcao;
        System.out.println("1 - Registar Equipamento");
        System.out.println("2 - Associar Laboratório");
        System.out.println("3 - Consultar por Id");
        System.out.println("4 - Consultar por laboratório");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 4);
        return opcao;
    }

    /**
     * Menu para a gestão de tipos de equipamentos
     *
     * @return devolve a opção selecionada
     */
    public static int gestaoTiposEquipamento() {
        int opcao;
        System.out.println("1 - Inserir tipo de equipamento");
        System.out.println("2 - Consultar tipos de equipamento");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 3);
        return opcao;
    }

    /**
     * Menu para a gestão de laboratórios
     *
     * @return devolve a opção selecionada
     */
    public static int gestaoLaboratorios() {
        int opcao;
        System.out.println("1 - Inserir laboratório");
        System.out.println("2 - Consultar informaçao de um laboratório");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 2);
        return opcao;
    }

    /**
     * Menu para a gestão de funcionários
     *
     * @return devolve a opção selecionada
     */
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

    /**
     * Menu para a gestão de escolas
     *
     * @return devolve a opção selecionada
     */
    public static int gestaoEscolas() {
        int opcao;
        System.out.println("1 - Inserir Escola");
        System.out.println("2 - Consultar por NIF");
        System.out.println("0 - Voltar ao menu anterior");
        opcao = Consola.lerInt("Indique uma opção: ", 0, 3);
        return opcao;
    }

}
