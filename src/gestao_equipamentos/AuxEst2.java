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
public class AuxEst2 implements Serializable, Comparable<AuxEst2> {

    private int totalGasto;
    private Calendar anoGastos = new GregorianCalendar();

    public AuxEst2(Calendar anoGastos) {

        this.anoGastos = anoGastos;
    }

    /**
     * @return the totalGasto
     */
    public int getTotalGasto() {
        return totalGasto;
    }

    /**
     * @param totalGasto the totalGasto to set
     */
    public void setTotalGasto(int totalGasto) {
        this.totalGasto = totalGasto;
    }

    /**
     * @return the anoGastos
     */
    public Calendar getAnoGastos() {
        return anoGastos;
    }

    /**
     * @param anoGastos the anoGastos to set
     */
    public void setAnoGastos(Calendar anoGastos) {
        this.anoGastos = anoGastos;
    }

    public void aumentaGastosAno(int gasto) {
        totalGasto += gasto;
    }

    @Override
    public int compareTo(AuxEst2 o) {

        if (totalGasto < o.getTotalGasto()) {
            return 1;
        }
        if (totalGasto > o.getTotalGasto()) {
            return -1;
        }
        return 0;

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(anoGastos.get(Calendar.YEAR)).append(" - ").append(totalGasto);

        return str.toString();
    }

}
