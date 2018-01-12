/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * Class Gestor que gere todo o Agrupamento
 *
 * @author RicardoAnastácio & Xavier Bento
 */
public class Gestor {

    /**
     * Lista de Escolas
     */
    private ArrayList<Escola> escolas = new ArrayList<>();
    private ArrayList<FuncionarioDocente> docentes = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<FuncionarioNaoDocente> naoDocentes = new ArrayList<>();
    private ArrayList<TipoEquipamento> tipoEquipamentos = new ArrayList<>();
    private ArrayList<Laboratorio> laboratorios = new ArrayList<>();
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
    private ArrayList<Avaria> avarias = new ArrayList<>();
    private ArrayList<Reparacao> reparacoes = new ArrayList<>();
    private ArrayList<AuxEst> auxEst = new ArrayList<>();
    private int numEquipAvariaTotal;

    public void adicionaNumEQAvariaTotal(Equipamento EQ) {
        if (EQ.avariasEQnotEmpty() == false) {
            numEquipAvariaTotal++;
        }
    }

    public String totalGastoAnoEqEscola() {
        StringBuilder str = new StringBuilder();
        Collections.sort(escolas);

        if (equipamentos.isEmpty()) {
            str.append("\nNão é possivel consultar esta estatística, não há equipamentos registados nem avarias");
        } else {
            str.append("\nTotal gasto por ano por escola em equipamentos");
            str.append("\nEscola\n  Ano - Gasto\n\n");
            for (int i = 0; i < escolas.size(); i++) {
                str.append(escolas.get(i).getNome()).append("\n");
                if (escolas.get(i).gastosAnoIsEmpty()) {
                    str.append("  Esta escola não teve gastos!");
                } else {
                    for (int j = 0; j < escolas.get(i).gastosAnoSize(); j++) {
                        str.append("  " + escolas.get(i).getGastosAno().get(j).getAnoGastos().get(Calendar.YEAR)).append(" - ").append(escolas.get(i).getGastosAno().get(j).getTotalGasto()).append("\n");
                    }
                }

            }
        }

        str.append('\n');

        return str.toString();
    }

    public float percEquipAvariaAgrup() {
        float percEquipAvariagrup = 0;

        percEquipAvariagrup = ((float) numEquipAvariaTotal / equipamentos.size()) * 100;

        return percEquipAvariagrup;
    }

    public String avariasRegistadasPorOrdemCrescenteTotal() {
        StringBuilder str = new StringBuilder();
        Collections.sort(auxEst);

        if (auxEst.isEmpty()) {
            str.append("\nNão é possivel consultar esta estatística não há avarias");
        } else {
            str.append("\nTotal de avarias resgitadas por estado num determinado ano");
            str.append("\nAno-AvariasPorReparar-AvariasReparadas-AvariasInrreparaveis\n");
            for (int i = 0; i < auxEst.size(); i++) {
                str.append(auxEst.get(i));
            }
        }

        return str.toString();
    }

    public int pesquisarAvariaAno(Calendar Data) {

        if (auxEst.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < auxEst.size(); i++) {
                if (Data.get(Calendar.YEAR) == auxEst.get(i).getDataAvaria().get(Calendar.YEAR)) {
                    return i;
                }
            }
        }
        return -1;

    }

    public int pesquisarAnoGastos(Escola E, Calendar Data) {

        if (E.gastosAnoIsEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < E.gastosAnoSize(); i++) {
                if (Data.get(Calendar.YEAR) == E.getGastosAno().get(i).getAnoGastos().get(Calendar.YEAR)) {
                    return i;
                }
            }
        }
        return -1;

    }
/**
 * 
 * @param Aux recebe 
 */
    public void adicionarAuxEst(AuxEst Aux) {
        auxEst.add(Aux);

    }

    public AuxEst obterAuxEst(int pos) {

        return auxEst.get(pos);
    }

    /**
     * Metodo para adicionar uma Avaria
     *
     * @param A Recebe uma Avaria
     */
    public void adicionarAvaria(Avaria A) {
        if (avarias.isEmpty()) {
            A.setNumId(1);
        } else {
            A.setNumId(avarias.get(avarias.size() - 1).getNumId() + 1);
        }
        avarias.add(A);
        A.getF().setVerificaEliminar(true);
    }

    /**
     * Método para obter uma Avaria de uma determinada posição
     *
     * @param pos posiçao
     * @return devolve uma avaria
     */
    public Avaria obterAvaria(int pos) {

        return avarias.get(pos);
    }
/**
 * 
 * @param ND recebe um nao docente 
 * @return devolve um funcionario
 */
    public Funcionario obterFuncionario(FuncionarioNaoDocente ND) {

        return funcionarios.get(funcionarios.indexOf(ND));

    }

    public void adicionarReparacao(Reparacao R) {
        if (reparacoes.isEmpty()) {
            R.setNumId(1);
        } else {
            R.setNumId(reparacoes.get(reparacoes.size() - 1).getNumId() + 1);
        }
        reparacoes.add(R);
    }

    public TipoEquipamento obterTipoEquipamento(int pos) {
        return tipoEquipamentos.get(pos);
    }

    public String listarFuncionarios() {
        StringBuilder str = new StringBuilder("");
        if (funcionarios.isEmpty()) {
            str.append("\nNão há funcionários!");
        } else {
            str.append("\nFuncionários do agrupamento (NIF-Nome-Escola): \n");
            for (int i = 0; i < funcionarios.size(); i++) {
                str.append("\t").append(funcionarios.get(i).getNif() + "-");
                str.append(funcionarios.get(i).getNome() + "-");
                str.append(funcionarios.get(i).getEscolaTrabalho().getNome()).append("\n");
            }
        }
        return str.toString();
    }

    public String listarTecnicosEscola(Escola E) {
        StringBuilder str = new StringBuilder("");
        if (verificaNaoDocenteTecnicoEscola(E) == false) {
            str.append("\nNão há funcionários técnicos na escola!");
        } else {

            str.append("\nFuncionários técnicos da escola (NIF-Nome): \n");
            for (int i = 0; i < naoDocentes.size(); i++) {
                if ("tecnico".equalsIgnoreCase(naoDocentes.get(i).funcao) && naoDocentes.get(i).getEscolaTrabalho().equals(E)) {
                    str.append("\t").append(naoDocentes.get(i).getNif() + "-");
                    str.append(naoDocentes.get(i).getNome()).append("\n");
                }
            }
        }
        return str.toString();
    }

    public String listarNaoDocentes() {
        StringBuilder str = new StringBuilder("");
        if (naoDocentes.isEmpty()) {
            str.append("\nNão há funcionários não docentes!");
        } else {
            str.append("\nFuncionários não docentes do agrupamento (NIF-Nome-Escola-Função): \n");
            for (int i = 0; i < naoDocentes.size(); i++) {
                str.append("\t").append(naoDocentes.get(i).getNif() + "-");
                str.append(naoDocentes.get(i).getNome() + "-");
                str.append(naoDocentes.get(i).getEscolaTrabalho().getNome() + "-");
                str.append(naoDocentes.get(i).funcao).append("\n");
            }
        }
        return str.toString();
    }

    public String listarEscolaNome() {
        StringBuilder str = new StringBuilder("");
        if (escolas.isEmpty()) {
            str.append("Não há escolas inseridas!");
        } else {
            str.append("Escolas listadas (NIF-Nome): \n");
            for (int i = 0; i < escolas.size(); i++) {
                str.append("\t").append(escolas.get(i).getNif() + "-");
                str.append(escolas.get(i).getNome()).append("\n");
            }
        }
        return str.toString();
    }

    public String listarAvarias() {
        StringBuilder str = new StringBuilder("");
        if (avarias.isEmpty()) {
            str.append("Não há Avarias registadas!");
        } else {
            str.append("Avarias registadas (ID-Descrição da avaria): \n");
            for (int i = 0; i < avarias.size(); i++) {
                if (avarias.get(i).isAlterado() == false) {
                    str.append("\t").append(avarias.get(i).getNumId() + "-");
                    str.append(avarias.get(i).getDescriçao()).append("\n");
                }
            }

        }

        return str.toString();
    }

    public boolean verificarAvarias() {

        boolean avariasValidas = false;

        for (int i = 0; i < avarias.size(); i++) {
            if (avarias.get(i).isAlterado() == false) {
                avariasValidas = true;
            }
        }

        return avariasValidas;
    }

    public boolean verificaNaoDocenteTecnico() {

        boolean haNDTecnico = false;

        for (int i = 0; i < naoDocentes.size(); i++) {
            if ("tecnico".equalsIgnoreCase(naoDocentes.get(i).funcao)) {
                haNDTecnico = true;
            }
        }

        return haNDTecnico;
    }

    public boolean verificaNaoDocenteTecnicoEscola(Escola E) {

        boolean haNDTecnicoEscola = false;

        for (int i = 0; i < naoDocentes.size(); i++) {
            if ("tecnico".equalsIgnoreCase(naoDocentes.get(i).funcao) && naoDocentes.get(i).getEscolaTrabalho().equals(E)) {
                haNDTecnicoEscola = true;
            }
        }

        return haNDTecnicoEscola;
    }

    public String listarLaboratorioEscola(Escola E) {
        StringBuilder str = new StringBuilder("");
        if (laboratorios.isEmpty()) {
            str.append("Não há laboratórios inseridos!");
        } else {
            str.append("Laboratórios listados (Descrição - Escola): \n");
            for (int i = 0; i < laboratorios.size(); i++) {
                if (laboratorios.get(i).getEscolaLab().equals(E)) {
                    str.append("\t").append(laboratorios.get(i).getDescricao() + " - ");
                    str.append(laboratorios.get(i).getEscolaLab().getNome()).append("\n");
                }
            }
        }
        return str.toString();
    }

    public String listarTiposEquipamento() {

        StringBuilder str = new StringBuilder("");
        if (tipoEquipamentos.isEmpty()) {
            str.append("Não há tipos de equipamento registados!");
        } else {
            str.append("Tipos de equipamento listados (ID-Designação): \n");
            for (int i = 0; i < tipoEquipamentos.size(); i++) {
                str.append("\t").append(tipoEquipamentos.get(i).getNumId() + "-");
                str.append(tipoEquipamentos.get(i).getDesignacao()).append("\n");
            }
        }
        return str.toString();
    }

    public String listarTiposEquipamentoMenu() {

        StringBuilder str = new StringBuilder("");
        if (tipoEquipamentos.isEmpty()) {
            str.append("Não há tipos de equipamento registados!");
        } else {
            str.append("Nr. de equipamentos por tipo (Designação-Nr. de Eq.): \n");
            for (int i = 0; i < tipoEquipamentos.size(); i++) {
                str.append("\t").append(tipoEquipamentos.get(i).getDesignacao() + "-");
                str.append(tipoEquipamentos.get(i).getNumEq()).append("\n");
            }
        }
        return str.toString();
    }

    public String listarEquipamentos() {
        StringBuilder str = new StringBuilder("");
        if (equipamentos.isEmpty()) {
            str.append("Não há equipamentos registados!");
        } else {
            str.append("Equipamento listados (ID-Descrição-Escola-NumSerie-TipoEquipamento): \n");
            for (int i = 0; i < equipamentos.size(); i++) {
                str.append("\t").append(equipamentos.get(i).getNumId() + "-");
                str.append(equipamentos.get(i).getDescricao() + "-");
                str.append(equipamentos.get(i).getE().getNome() + "-");
                str.append(equipamentos.get(i).getNumSerie() + "-");
                str.append(equipamentos.get(i).getT().getDesignacao()).append("\n");
            }
        }
        return str.toString();
    }

    public void adicionarTipoEquipamento(TipoEquipamento TE) {
        if (tipoEquipamentos.isEmpty()) {
            TE.setNumId(1);
        } else {
            TE.setNumId(tipoEquipamentos.get(tipoEquipamentos.size() - 1).getNumId() + 1);
        }
        tipoEquipamentos.add(TE);
    }

    public void adicionarEquipamento(Equipamento EQ) {
        if (equipamentos.isEmpty()) {
            EQ.setNumId(1);
        } else {
            EQ.setNumId(equipamentos.get(equipamentos.size() - 1).getNumId() + 1);
        }
        equipamentos.add(EQ);
        EQ.getND().setVerificaEliminar(true);
    }

    public void adicionarDocente(FuncionarioDocente D) {
        docentes.add(D);
        funcionarios.add(D);
    }

    public void adicionarLaboratorio(Laboratorio L) {
        laboratorios.add(L);
    }

    public void adicionarNaoDocente(FuncionarioNaoDocente ND) {
        naoDocentes.add(ND);
        funcionarios.add(ND);
    }

    public void removerFuncionario(int pos) {

        Funcionario f = obterFuncionario(pos);
        docentes.remove(f);
        naoDocentes.remove(f);
        funcionarios.remove(f);
    }

    public void adicionarEscola(Escola E) {
        escolas.add(E);

    }

    public Escola obterEscola(int pos) {
        return escolas.get(pos);
    }

    public Equipamento obterEquipamento(int pos) {
        return equipamentos.get(pos);
    }

    public Funcionario obterFuncionario(int pos) {
        return funcionarios.get(pos);
    }

    public FuncionarioNaoDocente obterFuncionarioNaoDocente(int pos) {
        return naoDocentes.get(pos);
    }

    public Laboratorio obterLaboratorio(int pos) {
        return laboratorios.get(pos);
    }

    public int pesquisarIdTipoEquipamento(int id) {
        for (int i = 0; i < tipoEquipamentos.size(); i++) {
            if (tipoEquipamentos.get(i).getNumId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int pesquisarIdEquipamento(int id) {
        for (int i = 0; i < equipamentos.size(); i++) {
            if (equipamentos.get(i).getNumId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int pesquisarAvaria(int id) {
        for (int i = 0; i < avarias.size(); i++) {
            if (avarias.get(i).getNumId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int pesquisarAvariaNAlteradas(int id) {
        for (int i = 0; i < avarias.size(); i++) {
            if (avarias.get(i).getNumId() == id && avarias.get(i).isAlterado() == false) {
                return i;
            }
        }
        return -1;
    }

    public int pesquisarEscolaNIF(int nif) {

        for (int i = 0; i < escolas.size(); i++) {
            if (escolas.get(i).getNif() == nif) {
                return i;
            }
        }
        return -1;

    }

    public int pesquisarFuncionarioNIF(int nif) {

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNif() == nif) {
                return i;
            }
        }
        return -1;
    }

    public int pesquisarNaoDocenteTecnico(int nif, Escola E) {
        for (int i = 0; i < naoDocentes.size(); i++) {
            if ("tecnico".equalsIgnoreCase(naoDocentes.get(i).funcao) && naoDocentes.get(i).getNif() == nif && naoDocentes.get(i).getEscolaTrabalho() == E) {
                return i;
            }
        }
        return -1;
    }

    public int pesquisarLabDesc(String descricao) {
        for (int i = 0; i < laboratorios.size(); i++) {
            if (descricao.equalsIgnoreCase(laboratorios.get(i).getDescricao())) {
                return i;
            }
        }
        return -1;
    }

    public int pesquisarLabDescEscola(String descricao, Escola E) {
        for (int i = 0; i < laboratorios.size(); i++) {
            if (descricao.equalsIgnoreCase(laboratorios.get(i).getDescricao()) && laboratorios.get(i).getEscolaLab().equals(E)) {
                return i;
            }
        }
        return -1;
    }

    public int pesquisarEscola(String nome) {
        for (int i = 0; i < escolas.size(); i++) {

            if (nome.equalsIgnoreCase(escolas.get(i).getNome())) {
                return i;
            }
        }
        return -1;
    }

    public int validarEmail(String email) {
        if (email.indexOf("@") == -1) {
            return -1;
        }
        return 0;
    }

    public int getSizeEscolas() {
        return escolas.size();
    }

    public int getSizeFuncionarios() {
        return funcionarios.size();
    }

    public int getSizeDocentes() {
        return docentes.size();
    }

    public int getSizeNaoDocentes() {
        return naoDocentes.size();
    }

    public int getSizeTipoEquipamento() {
        return tipoEquipamentos.size();
    }

    public int getSizeLaboratorio() {
        return laboratorios.size();
    }

    public int getSizeEquipamento() {
        return equipamentos.size();
    }

    public int getSizeAvarias() {
        return avarias.size();
    }

    public void gravarFicheiro() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dados_projeto.dat"));
            out.writeObject(escolas);
            out.writeObject(docentes);
            out.writeObject(funcionarios);
            out.writeObject(naoDocentes);
            out.writeObject(tipoEquipamentos);
            out.writeObject(laboratorios);
            out.writeObject(equipamentos);
            out.writeObject(avarias);
            out.writeObject(reparacoes);
            out.writeObject(auxEst);
            out.writeInt(numEquipAvariaTotal);
            // gravar/ler variaveis usadas para estatisticas no fim do projeto
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void lerFicheiro() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("dados_projeto.dat"));
            escolas = (ArrayList<Escola>) in.readObject();
            docentes = (ArrayList<FuncionarioDocente>) in.readObject();
            funcionarios = (ArrayList<Funcionario>) in.readObject();
            naoDocentes = (ArrayList<FuncionarioNaoDocente>) in.readObject();
            tipoEquipamentos = (ArrayList<TipoEquipamento>) in.readObject();
            laboratorios = (ArrayList<Laboratorio>) in.readObject();
            equipamentos = (ArrayList<Equipamento>) in.readObject();
            avarias = (ArrayList<Avaria>) in.readObject();
            reparacoes = (ArrayList<Reparacao>) in.readObject();
            auxEst = (ArrayList<AuxEst>) in.readObject();
            numEquipAvariaTotal = in.readInt();
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @return the numEquipAvariaTotal
     */
    public int getNumEquipAvariaTotal() {
        return numEquipAvariaTotal;
    }

    /**
     * @param numEquipAvariaTotal the numEquipAvariaTotal to set
     */
    public void setNumEquipAvariaTotal(int numEquipAvariaTotal) {
        this.numEquipAvariaTotal = numEquipAvariaTotal;
    }

}
