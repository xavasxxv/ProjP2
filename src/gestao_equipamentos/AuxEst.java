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
 * Class auxiliar para estatistica 2
 *
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class AuxEst implements Serializable, Comparable<AuxEst> {

    private int numAvariasReparadas;
    private int numAvariasPorReparar;
    private int numAvariasIrreparaveis;
    private Calendar dataAvaria = new GregorianCalendar();

    /**
     *
     * @param dataAvaria recebe data de avaria
     */
    public AuxEst(Calendar dataAvaria) {

        this.dataAvaria = dataAvaria;
    }

    /**
     * @return the numAvariasReparadas
     */
    public int getNumAvariasReparadas() {
        return numAvariasReparadas;
    }

    /**
     * @param numAvariasReparadas the numAvariasReparadas to set
     */
    public void setNumAvariasReparadas(int numAvariasReparadas) {
        this.numAvariasReparadas = numAvariasReparadas;
    }

    /**
     * @return the numAvariasPorReparar
     */
    public int getNumAvariasPorReparar() {
        return numAvariasPorReparar;
    }

    /**
     * @param numAvariasPorReparar the numAvariasPorReparar to set
     */
    public void setNumAvariasPorReparar(int numAvariasPorReparar) {
        this.numAvariasPorReparar = numAvariasPorReparar;
    }

    /**
     * @return the numAvariasIrreparaveis
     */
    public int getNumAvariasIrreparaveis() {
        return numAvariasIrreparaveis;
    }

    /**
     * @param numAvariasIrreparaveis the numAvariasIrreparaveis to set
     */
    public void setNumAvariasIrreparaveis(int numAvariasIrreparaveis) {
        this.numAvariasIrreparaveis = numAvariasIrreparaveis;
    }

    /**
     * @return the dataAvaria
     */
    public Calendar getDataAvaria() {
        return dataAvaria;
    }

    /**
     * @param dataAvaria the dataAvaria to set
     */
    public void setDataAvaria(Calendar dataAvaria) {
        this.dataAvaria = dataAvaria;
    }

    @Override
    public int compareTo(AuxEst o) {

        if (numAvariasPorReparar > o.getNumAvariasPorReparar()) {
            return 1;
        }
        if (numAvariasPorReparar < o.getNumAvariasPorReparar()) {
            return -1;
        }
        return 0;

    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append(dataAvaria.get(Calendar.YEAR)).append("-").append(numAvariasPorReparar).append("-")
                .append(numAvariasReparadas).append("-").append(numAvariasIrreparaveis).append("\n");

        return str.toString();
    }

}
