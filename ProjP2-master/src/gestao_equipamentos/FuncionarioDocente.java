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
public class FuncionarioDocente extends Funcionario implements  Serializable {

    protected String departamento;

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
