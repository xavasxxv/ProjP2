/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class que define cada tipo equipamento
 *
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class TipoEquipamento implements Serializable {

    private String designacao;
    private int numId;
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();

    /**
     * Adiciona um equipamento ao tipo de equipamento
     *
     * @param EQ recebe um equipamento
     */
    public void adicionarEquipamento(Equipamento EQ) {

        equipamentos.add(EQ);
    }

    /**
     * Construtor TipoEquipamento
     *
     * @param designacao recebe a designação do novo tipo de equipamento
     */
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
     * @return sizeOf equipamentos
     */
    public int getNumEq() {
        return equipamentos.size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Tipo de Equipamento (Id-Desginação-NumeroEquipamentos): ");
        str.append("\nId: ").append(numId);
        str.append("\nDesignação: ").append(designacao);
        str.append("\nNumero Equipamentos: ").append(equipamentos.size()).append("\n");

        return str.toString();
    }

}
