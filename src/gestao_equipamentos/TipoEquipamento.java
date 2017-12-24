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
public class TipoEquipamento implements Serializable {
    
    private String designacao;
    private int numId;
    private int numTotal;
    
    public TipoEquipamento(String designacao) {
        this.designacao = designacao;
    }

    /**
     * @return the designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * @param designacao the designacao to set
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
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
     * @return the numTotal
     */
    public int getNumTotal() {
        return numTotal;
    }

    /**
     * @param numTotal the numTotal to set
     */
    public void setNumTotal(int numTotal) {
        this.numTotal = numTotal;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Tipo de Equipamento (Id-Desginação): ");
        str.append("\nId: ").append(numId);
        str.append("\nDesignação: ").append(designacao).append("\n");
        
        return str.toString();
    }
    
}
