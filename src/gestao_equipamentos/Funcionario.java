/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.Calendar;

/**
 *Class que define dados base do funcionario
 * @author RicardoAnastácio & Xavier Bento
 */
public class Funcionario implements Serializable {

    private String nome;
    private String morada;
    private int nif;
    private String email;
    private int telefone;
    private Calendar dataNasc;
    private String habilitacoes;
    private Escola escolaTrabalho;
    private boolean verificaEliminar;

    /**
     * 
     * @param nome recebe nome do funcionario
     * @param morada recebe morada do funcionario
     * @param nif recebe nif do funcionario
     * @param email recebe email do funcionario
     * @param telefone recebe telefone do funcionario
     * @param dataNasc recebe data de nascimento do funcionario
     * @param habilitacoes recebe habilitações do funcionario
     * @param escolaTrabalho recebe escola onde trabalha o funcionario
     */
    public Funcionario(String nome, String morada, int nif, String email, int telefone, Calendar dataNasc, String habilitacoes, Escola escolaTrabalho) {

        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.habilitacoes = habilitacoes;
        this.escolaTrabalho = escolaTrabalho;

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n\tNIF: ").append(nif);
        str.append("\n\tNome: ").append(nome);
        str.append("\n\tMorada: ").append(morada);
        str.append("\n\tTelefone: ").append(telefone);
        str.append("\n\tEmail: ").append(email);
        str.append("\n\tData de Nascimento: ").append(dataNasc.get(Calendar.DATE)).append("/");
        str.append((dataNasc.get(Calendar.MONTH) + 1)).append("/");
        str.append(dataNasc.get(Calendar.YEAR));
        str.append("\n\tEscola: ").append(escolaTrabalho.getNome());
        str.append("\n\tHabilitações: ").append(habilitacoes);

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
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * @return the nif
     */
    public int getNif() {
        return nif;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the escolaTrabalho
     */
    public Escola getEscolaTrabalho() {
        return escolaTrabalho;
    }

    /**
     * @return the verificaEliminar
     */
    public boolean isVerificaEliminar() {
        return verificaEliminar;
    }

    /**
     * @param verificaEliminar the verificaEliminar to set
     */
    public void setVerificaEliminar(boolean verificaEliminar) {
        this.verificaEliminar = verificaEliminar;
    }

}
