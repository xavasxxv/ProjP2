/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class que define laboratorio
 *
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class Laboratorio implements Serializable {

    private String descricao;
    private Escola escolaLab;
    private String escolaLoc;
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();

    /**
     *
     * @param descricao recebe descricao do laboratorio
     * @param escolaLab recebe escola a qual pertence laboratorio
     * @param escolaLoc recebe a localização do laboratorio na escola
     */
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (escolaLoc == null) {
            str.append("\nO equipamento foi abatido, já não tem laboratório!").append("\n");
        } else {
            str.append("\nLaboratório: ");
            str.append("\nDescrição: ").append(descricao);
            str.append("\nEscola onde se encontra: ").append(escolaLab.getNome());
            str.append("\nLocalização na escola: ").append(escolaLoc);
            str.append("\nNumero de equipamentos instalados: ").append(equipamentos.size()).append("\n");
        }
        return str.toString();
    }

    public void adicionarEquipamento(Equipamento E) {
        equipamentos.add(E);
    }

    public void removerEquipamento(Equipamento E) {
        equipamentos.remove(E);
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

    public String listarEQLab() {

        StringBuilder str = new StringBuilder("");
        if (equipamentos.isEmpty()) {
            str.append("Não há equipamentos neste laboratório!");
        } else {
            str.append("Equipamento listados (ID-Descrição-Escola-NumSerie-TipoEquipamento-Nr de avarias): \n");
            for (int i = 0; i < equipamentos.size(); i++) {
                str.append("\t").append(equipamentos.get(i).getNumId() + "-");
                str.append(equipamentos.get(i).getDescricao() + "-");
                str.append(equipamentos.get(i).getE().getNome() + "-");
                str.append(equipamentos.get(i).getNumSerie() + "-");
                str.append(equipamentos.get(i).getT().getDesignacao() + "-");
                str.append(equipamentos.get(i).getAvarias().size()).append("\n");
            }
        }
        return str.toString();

    }

}
