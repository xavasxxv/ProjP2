/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class que define Avaria
 *
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class Avaria implements Serializable {

    private int numId;
    private Calendar dataAvaria = new GregorianCalendar();
    private Equipamento EQ;
    private String descricao;
    private Funcionario F;
    private int estadoA;
    private boolean alterado;

    public Avaria(Calendar dataAvaria, Equipamento E, String descricao, Funcionario F, int estadoA, boolean alterado) {

        this.dataAvaria = dataAvaria;
        this.EQ = E;
        this.descricao = descricao;
        this.F = F;
        this.EQ = E;
        this.estadoA = estadoA;
        this.alterado = alterado;

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Avaria: ");
        str.append("\nNúmero de Identificação: ").append(numId);
        str.append("\nDescrição: ").append(descricao);
        str.append("\nEstado: ");
        if (estadoA == 1) {
            str.append("POR REPARAR");
        }
        if (estadoA == 2) {
            str.append("REPARADA");
        }
        if (estadoA == 3) {
            str.append("IRREPARAVEL");
        }
        str.append("\nFuncionário que registou: ").append(F.getNome());
        str.append("\nData de registo da avaria: ").append(dataAvaria.get(Calendar.DATE)).append("/");
        str.append((dataAvaria.get(Calendar.MONTH) + 1)).append("/");
        str.append(dataAvaria.get(Calendar.YEAR)).append("\n");

        return str.toString();
    }

    /**
     * @return the numId
     */
    public int getNumId() {
        return numId;
    }

    /**
     * @param numId the numId to set
     */
    public void setNumId(int numId) {
        this.numId = numId;
    }

    /**
     * @return the dataAvaria
     */
    public Calendar getDataAvaria() {
        return dataAvaria;
    }

    /**
     * @return the EQ
     */
    public Equipamento getEQ() {
        return EQ;
    }

    /**
     * @return the descriçao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the F
     */
    public Funcionario getF() {
        return F;
    }

    /**
     * @return the estadoA
     */
    public int getEstadoA() {
        return estadoA;
    }

    /**
     * @param estadoA the estadoA to set
     */
    public void setEstadoA(int estadoA) {
        this.estadoA = estadoA;
    }

    /**
     * @return the alterado
     */
    public boolean isAlterado() {
        return alterado;
    }

    /**
     * @param alterado the alterado to set
     */
    public void setAlterado(boolean alterado) {
        this.alterado = alterado;
    }

}
