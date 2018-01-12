/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * Class que define escola
 *
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class Escola implements Serializable, Comparable<Escola> {

    private String nome;
    private String morada;
    private int nif;
    private int telefone;
    private String email;
    private Calendar dataInicioServico;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Laboratorio> laboratorios = new ArrayList<>();
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
    private ArrayList<AuxEst2> gastosAno = new ArrayList<>();

    /**
     * Construtor de uma Escola
     *
     * @param nome recebe nome da escola
     * @param nif recebe nif da escola
     * @param morada recebe morada da escola
     * @param telefone recebe telefone da escola
     * @param email recebe email da escola
     * @param dataInicioServico recebe ano de inicio da escola
     */
    public Escola(String nome, int nif, String morada, int telefone, String email, Calendar dataInicioServico) {

        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.telefone = telefone;
        this.email = email;
        this.dataInicioServico = dataInicioServico;
    }

    /**
     * Aumenta o gasto de um determinado ano e ordena por gasto
     *
     * @param gasto recebe o gasto adicional
     * @param pos recebe a posiçao do ano de gastos
     */
    public void aumentaGastosAno(int gasto, int pos) {

        gastosAno.get(pos).aumentaGastosAno(gasto);
        Collections.sort(gastosAno);

    }

    /**
     * Verifica se a escola ja registou gastos
     *
     * @return devolve se exitem anos de gastos
     */
    public boolean gastosAnoIsEmpty() {
        return gastosAno.isEmpty();
    }

    /**
     * Devolve o numero de anos de gastos
     *
     * @return devolve o numero de anos de gastos
     */
    public int gastosAnoSize() {
        return gastosAno.size();
    }

    /**
     * Adiciona um novo ano de gastos e ordena
     *
     * @param anoGastos recebe um novo anoGastos
     */
    public void adicionarAnoGastos(AuxEst2 anoGastos) {
        gastosAno.add(anoGastos);
        Collections.sort(gastosAno);
    }

    /**
     * Obtem um ano de gastos
     *
     * @param pos recebe a posiçao do ano
     * @return devolve o ano de gastos
     */
    public AuxEst2 obterAnoGastos(int pos) {
        return gastosAno.get(pos);
    }

    /**
     * Obtem um funcionario
     *
     * @param pos recebe a posiçao
     * @return devolve um funcionario
     */
    public Funcionario obterFuncionarioEscola(int pos) {
        return funcionarios.get(pos);
    }

    /**
     * Pesquisa a posiçao de um funcionario por nif
     *
     * @param nif recebe o nif do funcionario
     * @return devolve a posiçao do funcionario
     */
    public int pesquisarFuncionarioNIFEscola(int nif) {

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNif() == nif) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Lista os funcionarios da escola
     *
     * @return devolve a string dos funcionarios da escola
     */
    public String listarFuncionariosEscola() {
        StringBuilder str = new StringBuilder("");
        if (funcionarios.isEmpty()) {
            str.append("Não há funcionários na escola!");
        } else {
            str.append("Funcionários da escola (NIF-Nome): ");
            for (int i = 0; i < funcionarios.size(); i++) {
                str.append("\n\t").append(funcionarios.get(i).getNif() + "-");
                str.append(funcionarios.get(i).getNome());
            }
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * Lista os laboratorios da escola
     *
     * @return devolve a string dos laboratorios da escola
     */
    public String listarLaboratoriosEscola() {
        StringBuilder str = new StringBuilder("");
        if (laboratorios.isEmpty()) {
            str.append("Não há laboratórios na escola!");
        } else {
            str.append("Laboratórios da escola: \n");
            for (int i = 0; i < laboratorios.size(); i++) {
                str.append(laboratorios.get(i));
            }
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * Remover um funcionario
     *
     * @param f recebe um funcionario
     */
    public void removerFuncionario(Funcionario f) {
        funcionarios.remove(f);
    }

    /**
     * Adiciona um equipamento a escola
     *
     * @param EQ recebe um equipamento
     */
    public void adicionarEquipamento(Equipamento EQ) {

        equipamentos.add(EQ);
    }

    /**
     * Adiciona um funcionario a escola
     *
     * @param F recebe um funcionario
     */
    public void adicionarFuncionario(Funcionario F) {

        funcionarios.add(F);
    }

    /**
     * Adiciona um laboratorio a escola
     *
     * @param L recebe um laboratorio
     */
    public void adicionarLaboratorio(Laboratorio L) {

        laboratorios.add(L);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Escola: ");
        str.append("\nNome: ").append(nome);
        str.append("\nMorada: ").append(morada);
        str.append("\nTelefone: ").append(telefone);
        str.append("\nNIF: ").append(nif);
        str.append("\nEmail: ").append(email);
        str.append("\nAno de entrada em serviço: ").append(dataInicioServico.get(Calendar.YEAR));
        if (gastosAnoIsEmpty()) {
            str.append("\nEsta escola não tem gastos registados!\n");
        } else {
            Collections.sort(gastosAno);
            str.append("\nGastos por ano (Ano - Despesa)");
            for (int i = 0; i < gastosAno.size(); i++) {
                str.append("\n\t").append(gastosAno.get(i));
            }
            str.append("\n");
        }

        return str.toString();
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the nif
     */
    public int getNif() {
        return nif;
    }

    /**
     * Procurar um ano de gastos
     *
     * @param i recebe a posiçao do ano de gastos
     * @return devolve um ano de gastos
     */
    public AuxEst2 getGastosAno(int i) {
        return gastosAno.get(i);
    }

    @Override
    public int compareTo(Escola o) {
        return nome.compareToIgnoreCase(o.getNome());
    }

}
