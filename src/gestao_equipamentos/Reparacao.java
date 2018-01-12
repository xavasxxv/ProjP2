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
 *Class que define cada Reparação 
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class Reparacao implements Serializable {

    private int numId;
    private Avaria A;
    private Calendar dataReparacao = new GregorianCalendar();
    private String descricao;
    private int custoReparacao;
    private Funcionario F;
/**
 * Construtor Reparacao
 * @param A recebe avaria
 * @param dataReparacao recebe data da reparaçao
 * @param descricao recebe descricao da reparaçao
 * @param custoReparacao recebe custo da reparaçao
 * @param F  recebe o funcionario que regista a reparação
 */
    public Reparacao(Avaria A, Calendar dataReparacao, String descricao, int custoReparacao, Funcionario F) {

        this.A = A;
        this.dataReparacao = dataReparacao;
        this.descricao = descricao;
        this.custoReparacao = custoReparacao;
        this.F = F;

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Dados da reparação: ");
        str.append("\nNúmero de identificação: ").append(numId);
        str.append("\nDescrição: ").append(descricao);
        str.append("\nCusto em euros: ").append(custoReparacao);
        str.append("\nFuncionário que reparou: ").append(F.getNome());
        str.append("\nData de reparação: ").append(dataReparacao.get(Calendar.DATE)).append("/");
        str.append((dataReparacao.get(Calendar.MONTH) + 1)).append("/");
        str.append(dataReparacao.get(Calendar.YEAR)).append("\n");

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
     * @return the A
     */
    public Avaria getA() {
        return A;
    }

    /**
     * @param A the A to set
     */
    public void setA(Avaria A) {
        this.A = A;
    }

    /**
     * @return the dataReparacao
     */
    public Calendar getDataReparacao() {
        return dataReparacao;
    }

    /**
     * @param dataReparacao the dataReparacao to set
     */
    public void setDataReparacao(Calendar dataReparacao) {
        this.dataReparacao = dataReparacao;
    }

    /**
     * @return the descriçao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descriçao the descriçao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the custoReparacao
     */
    public int getCustoReparacao() {
        return custoReparacao;
    }

    /**
     * @param custoReparacao the custoReparacao to set
     */
    public void setCustoReparacao(int custoReparacao) {
        this.custoReparacao = custoReparacao;
    }

    /**
     * @return the F
     */
    public Funcionario getF() {
        return F;
    }

    /**
     * @param F the F to set
     */
    public void setF(Funcionario F) {
        this.F = F;
    }

}
