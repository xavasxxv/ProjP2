/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 *  * @author RicardoAnastácio
 */
public class Laboratorio implements Serializable {

    private String descricao;
    private Escola escolaLab;
    private String escolaLoc;
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();

    public Laboratorio(String descricao, Escola escolaLab, String escolaLoc) {

        this.descricao = descricao;
        this.escolaLab = escolaLab;
        this.escolaLoc = escolaLoc;

    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the escolaLab
     */
    public Escola getEscolaLab() {
        return escolaLab;
    }

    /**
     * @return the escolaLoc
     */
    public String getEscolaLoc() {
        return escolaLoc;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (escolaLoc == null) {
            str.append("\nO equipamento foi abatido, já não tem laboratório!").append("\n");
        } else {
            str.append("\nLaboratório: ");
            str.append("\nDescrição: ").append(descricao);
            str.append("\nEscola onde se encontra: ").append(escolaLab.getNome());
            str.append("\nLocalização na escola: ").append(escolaLoc).append("\n");
        }
        return str.toString();
    }

    public void adicionarEquipamento(Equipamento E) {
        equipamentos.add(E);
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param escolaLab the escolaLab to set
     */
    public void setEscolaLab(Escola escolaLab) {
        this.escolaLab = escolaLab;
    }

    /**
     * @param escolaLoc the escolaLoc to set
     */
    public void setEscolaLoc(String escolaLoc) {
        this.escolaLoc = escolaLoc;
    }

}
