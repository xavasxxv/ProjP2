/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class que define Equipamento
 *
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class Equipamento implements Serializable {

    private int numId;
    private Calendar dataIventario = new GregorianCalendar();
    private String descricao;
    private int numSerie;
    private TipoEquipamento T;
    private Laboratorio lab;
    private Escola E;
    private int estado;
    private FuncionarioNaoDocente ND;
    private int custo;

    private ArrayList<Avaria> avarias = new ArrayList<>();
    private ArrayList<Reparacao> reparacoes = new ArrayList<>();

    /**
     * Construtor Equipamento
     *
     * @param dataIventario Recebe a data em que é registado o equipamento
     * @param descricao Recebe uma descriçao do equipamento
     * @param numSerie Recebe o numero de serie do equipamento
     * @param T Recebe o tipo de equipamento do equipamento
     * @param E Recebe a escola onde vai estar o equipamento
     * @param custo Recebe o custo do equipamento
     * @param ND Recebe o funcionario não docente tecnico que regista o
     * equipamento
     * @param estado Recebe/atualiza o estado do equipamento para Disponivel
     */
    public Equipamento(Calendar dataIventario, String descricao, int numSerie, TipoEquipamento T, Escola E, int custo, FuncionarioNaoDocente ND, int estado) {

        this.dataIventario = dataIventario;
        this.descricao = descricao;
        this.numSerie = numSerie;
        this.T = T;
        this.E = E;
        this.estado = estado;
        this.ND = ND;
        this.custo = custo;
        this.lab = null;

    }

    /**
     * Lista avarias do equipamento
     *
     * @param EQ recebe um equipamento
     * @return a string das avarias do equipamento
     */
    public String listarAvarias(Equipamento EQ) {
        StringBuilder str = new StringBuilder("");
        if (EQ.avarias.isEmpty()) {
            str.append("Não há avarias registadas!");
        } else {
            str.append("Equipamento: " + EQ.numId + " - Avarias (IdAvaria-Descrição): \n");
            for (int i = 0; i < EQ.avarias.size(); i++) {

                str.append(EQ.avarias.get(i).getNumId() + " - ");
                str.append(EQ.avarias.get(i).getDescricao()).append("\n");

            }
        }
        return str.toString();
    }

    /**
     * Pesquisa avaria de um equipamento
     *
     * @param id recebe o numero de identificação da avaria
     * @return devolve a posição da avaria
     */
    public int pesquisarAvariaEQ(int id) {
        for (int i = 0; i < avarias.size(); i++) {
            if (avarias.get(i).getNumId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adiciona uma avaria e define o estado do equipamento para indisponivel
     *
     * @param A recebe uma avaria
     */
    public void adicionarAvaria(Avaria A) {

        avarias.add(A);
        setEstado(2); //passa automatiocamente a indisponivel
    }

    /**
     * Adiciona uma reparação ao equipamento
     *
     * @param R recebe uma reparação
     */
    public void adicionarReparacao(Reparacao R) {

        reparacoes.add(R);
    }

    /**
     * Obtem a posição da avaria
     *
     * @param A recebe uma avaria
     * @return devolve a posiçao da avaria
     */
    public Avaria obterAvaria(Avaria A) {

        return avarias.get(avarias.indexOf(A));

    }

    /**
     * Método para obter uma Avaria de uma determinada posição
     *
     * @param pos posição
     * @return Devolve uma avaria
     */
    public Avaria obterAvaria(int pos) {

        return avarias.get(pos);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Equipamento: ");
        str.append("\nNúmero de Identificação: ").append(numId);
        str.append("\nDescrição: ").append(descricao);
        str.append("\nNúmero de Série: ").append(numSerie);
        str.append("\nTipo de Equipamento: ").append(T.getDesignacao());
        str.append("\nEscola: ").append(E.getNome());
        if (lab == null) {
            str.append("\nLaboratório: Não associado\n");
        } else {
            str.append(lab); //toString Laboratorio
        }
        str.append("Número de avarias: ").append(avarias.size());
        str.append("\nNúmero de reparações: ").append(reparacoes.size());
        str.append("\nCusto: ").append(custo).append(" €").append("\nEstado: ");
        if (estado == 1) {
            str.append("DISPONÍVEL");
        }
        if (estado == 2) {
            str.append("INDISPONÍVEL");
        }
        if (estado == 3) {
            str.append("ABATIDO");
        }
        str.append("\nTécnico que registou: ").append(ND.getNome());
        str.append("\nNumero de Avarias do equipamento: ").append(avarias.size());
        str.append("\nData de inventário: ").append(dataIventario.get(Calendar.DATE)).append("/");
        str.append((dataIventario.get(Calendar.MONTH) + 1)).append("/");
        str.append(dataIventario.get(Calendar.YEAR)).append("\n");

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the numSerie
     */
    public int getNumSerie() {
        return numSerie;
    }

    /**
     * @return the T
     */
    public TipoEquipamento getT() {
        return T;
    }

    /**
     * @return the E
     */
    public Escola getE() {
        return E;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @param lab the lab to set
     */
    public void setLab(Laboratorio lab) {
        this.lab = lab;
    }

    /**
     * @return the lab
     */
    public Laboratorio getLab() {
        return lab;
    }

    /**
     * Verifica se existem avarias no equipamento
     *
     * @return Devolve true se existirem avarias no equipamento
     */
    public boolean avariasEQnotEmpty() {
        return !avarias.isEmpty();
    }

    /**
     * @return the dataIventario
     */
    public Calendar getDataIventario() {
        return dataIventario;
    }

    /**
     * @return the ND
     */
    public FuncionarioNaoDocente getND() {
        return ND;
    }

    /**
     * @return the avarias
     */
    public int getAvariasSize() {
        return avarias.size();
    }

}
