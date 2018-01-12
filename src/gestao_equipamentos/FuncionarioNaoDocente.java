/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Class proveniente de funcionario que define não docente
 *
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class FuncionarioNaoDocente extends Funcionario implements Serializable {

    protected String funcao;

    /**
     * Construtor Funcionario nao docente
     *
     * @param nome Recebe nome do funcionario da class Funcionario
     * @param morada Recebe morada do funcionario da class Funcionario
     * @param nif Recebe nif do funcionario da class Funcionario
     * @param email Recebe email do funcionario da class Funcionario
     * @param telefone Recebe telefone do funcionario da class Funcionario
     * @param dataNasc Recebe data nascimento do funcionario da class
     * Funcionario
     * @param habilitacoes Recebe habilitaçoes do funcionario da class
     * Funcionario
     * @param escolaTrabalho Recebe Escola onde trabalha o funcionario da class
     * Funcionario
     * @param funcao Recebe a função do funcionario
     */
    public FuncionarioNaoDocente(String nome, String morada, int nif, String email, int telefone, Calendar dataNasc, String habilitacoes, Escola escolaTrabalho, String funcao) {

        super(nome, morada, nif, email, telefone, dataNasc, habilitacoes, escolaTrabalho);
        this.funcao = funcao;

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Funcionário não docente: ");
        str.append(super.toString());
        str.append("\n\tFunção: ").append(funcao).append("\n");
        return str.toString();
    }

}
