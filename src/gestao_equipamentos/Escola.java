/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author RicardoAnastácio
 */
public class Escola implements Serializable {

    private String nome;
    private String morada;
    private int nif;
    private int telefone;
    private String email;
    private Calendar dataInicioServico;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Laboratorio> laboratorios = new ArrayList<>();
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();

    public Escola(String nome, int nif, String morada, int telefone, String email, Calendar dataInicioServico) {

        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.telefone = telefone;
        this.email = email;
        this.dataInicioServico = dataInicioServico;
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
            str.append("Funcionários da escola " + "(NIF-Nome): \n");
            for (int i = 0; i < funcionarios.size(); i++) {
                str.append(funcionarios.get(i).getNif() + "-");
                str.append(funcionarios.get(i).getNome()).append("\n");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public int getSizeFuncionarios() {
        return funcionarios.size();
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
        str.append("\nAno de entrada em serviço: ").append(dataInicioServico.get(Calendar.YEAR)).append("\n");

        return str.toString();
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * @return the nif
     */
    public int getNif() {
        return nif;
    }

    /**
     * @return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the dataInicioServico
     */
    public Calendar getDataInicioServico() {
        return dataInicioServico;
    }

}
