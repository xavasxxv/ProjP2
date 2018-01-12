/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Class proveniente de funcionario que define docente
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class FuncionarioDocente extends Funcionario implements Serializable {

    protected String departamento;
/**
 * Construtor Funcionario nao docente 
 * @param nome Recebe nome do funcionario da class Funcionario
 * @param morada Recebe morada do funcionario da class Funcionario
 * @param nif Recebe nif do funcionario da class Funcionario
 * @param email Recebe email do funcionario da class Funcionario
 * @param telefone Recebe telefone do funcionario da class Funcionario
 * @param dataNasc Recebe data nascimento do funcionario da class Funcionario
 * @param habilitacoes Recebe habilitaçoes do funcionario da class Funcionario
 * @param escolaTrabalho Recebe Escola onde trabalha o funcionario da class Funcionario
 * @param departamento  Recebe o departamento do funcionario 
 */
    public FuncionarioDocente(String nome, String morada, int nif, String email, int telefone, Calendar dataNasc, String habilitacoes, Escola escolaTrabalho, String departamento) {

        super(nome, morada, nif, email, telefone, dataNasc, habilitacoes, escolaTrabalho);
        this.departamento = departamento;

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Funcionário docente: ");
        str.append(super.toString());
        str.append("\n\tDepartamento: ").append(departamento).append("\n");
        return str.toString();
    }

}
