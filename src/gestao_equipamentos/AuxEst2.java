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
 *
 * @author ricar
 */
public class AuxEst2 implements Serializable {

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

}
