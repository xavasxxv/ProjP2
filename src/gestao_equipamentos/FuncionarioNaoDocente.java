/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author RicardoAnastácio
 */
public class FuncionarioNaoDocente extends Funcionario implements  Serializable {

    protected String funcao;

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

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }


}