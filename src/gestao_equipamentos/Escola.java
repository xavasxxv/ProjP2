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

    public void aumentaGastosAno(int gasto, int pos) {

        gastosAno.get(pos).aumentaGastosAno(gasto);
        Collections.sort(gastosAno);

    }

    public boolean gastosAnoIsEmpty() {
        return gastosAno.isEmpty();
    }

    public int gastosAnoSize() {
        return gastosAno.size();
    }

    public void adicionarAnoGastos(AuxEst2 anoGastos) {
        gastosAno.add(anoGastos);
        Collections.sort(gastosAno);
    }

    public AuxEst2 obterAnoGastos(int pos) {
        return gastosAno.get(pos);
    }

    public Funcionario obterFuncionarioEscola(int pos) {
        return funcionarios.get(pos);
    }

    public int pesquisarFuncionarioNIFEscola(int nif) {

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNif() == nif) {
                return i;
            }
        }
        return -1;
    }

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

    public void removerFuncionario(Funcionario f) {
        funcionarios.remove(f);
    }

    public void adicionarEquipamento(Equipamento EQ) {

        equipamentos.add(EQ);
    }

    public void adicionarFuncionario(Funcionario F) {

        funcionarios.add(F);
    }

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
     * @return the gastosAno
     */
    public AuxEst2 getGastosAno(int i) {
        return gastosAno.get(i);
    }

    @Override
    public int compareTo(Escola o) {
        return nome.compareToIgnoreCase(o.getNome());
    }

}
