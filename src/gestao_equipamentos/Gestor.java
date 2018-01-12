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
 * @author Ricardo Anastácio
 * @author Xavier Bento
 */
public class Gestor {

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
/**
 * Aumenta o numero de equipamentos avariados
 * @param EQ recebe um equipamento
 */
    public void adicionaNumEQAvariaTotal(Equipamento EQ) {
        if (EQ.avariasEQnotEmpty() == false) {
            numEquipAvariaTotal++;
        }
    }
/**
 * Mostra os gastos por ano das escolas
 * @return devolve a string dos gastos das escolas
 */
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
                        str.append("  " + escolas.get(i).getGastosAno(j).getAnoGastos().get(Calendar.YEAR)).append(" - ").append(escolas.get(i).getGastosAno(j).getTotalGasto()).append("\n");
                    }
                }

            }
        }

        str.append('\n');

        return str.toString();
    }
/**
 * Calcula a % de equipamentos avariados
 * @return devolve a % dos equipamentos avariados
 */
    public float percEquipAvariaAgrup() {
        float percEquipAvariagrup = 0;

        percEquipAvariagrup = ((float) numEquipAvariaTotal / equipamentos.size()) * 100;

        return percEquipAvariagrup;
    }
/**
 * Mostra e ordena as avarias registadas por ano
 * @return devolve a string que mostra as avarias registadas por ano
 */
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
/**
 * Pesquisa o ano de avarias
 * @param Data recebe a data de avaria
 * @return devolve a posiçao do ano das avarias
 */
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
/**
 * Pesquisa o ano de gastos da escola
 * @param E recebe a escola
 * @param Data recebe o ano dos gastos 
 * @return devolve a posiçao do ano de gastos
 */
    public int pesquisarAnoGastos(Escola E, Calendar Data) {

        if (E.gastosAnoIsEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < E.gastosAnoSize(); i++) {
                if (Data.get(Calendar.YEAR) == E.getGastosAno(i).getAnoGastos().get(Calendar.YEAR)) {
                    return i;
                }
            }
        }
        return -1;

    }

    /**
     * Adiciona o ano de avarias
     * @param Aux recebe o ano de avarias
     */
    public void adicionarAuxEst(AuxEst Aux) {
        auxEst.add(Aux);
    }
/**
 * Obter o ano de avarias
 * @param pos recebe a posiçao 
 * @return devolve o ano de avarias
 */
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
     * Obtem um funcionario a partir de um nao docente
     * @param ND recebe um nao docente
     * @return devolve um funcionario
     */
    public Funcionario obterFuncionario(FuncionarioNaoDocente ND) {

        return funcionarios.get(funcionarios.indexOf(ND));

    }
/**
 * Adiciona uma reparação
 * @param R recebe uma reparação
 */
    public void adicionarReparacao(Reparacao R) {
        if (reparacoes.isEmpty()) {
            R.setNumId(1);
        } else {
            R.setNumId(reparacoes.get(reparacoes.size() - 1).getNumId() + 1);
        }
        reparacoes.add(R);
    }
/**
 * obtem um tipo de equipamento
 * @param pos recebe a posiçao 
 * @return devolve um tipo de equipamento
 */
    public TipoEquipamento obterTipoEquipamento(int pos) {
        return tipoEquipamentos.get(pos);
    }
/**
 * Lista os funcionarios
 * @return devolve a string dos funcionarios
 */
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
/**
 * Lista os tecnicos de uma escola
 * @param E recebe a escola
 * @return devolve a string que lista os tecnicos de uma escola
 */
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
/**
 * Lista as escolas por ordem alfabetica
 * @return devolve a string que lista as escolas ordenadas
 */
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
/**
 * Lisa as avarias 
 * @return devolve a string das avarias registadas
 */
    public String listarAvarias() {
        StringBuilder str = new StringBuilder("");
        if (avarias.isEmpty()) {
            str.append("Não há Avarias registadas!");
        } else {
            str.append("Avarias registadas (ID-Descrição da avaria): \n");
            for (int i = 0; i < avarias.size(); i++) {
                if (avarias.get(i).isAlterado() == false) {
                    str.append("\t").append(avarias.get(i).getNumId() + "-");
                    str.append(avarias.get(i).getDescricao()).append("\n");
                }
            }

        }

        return str.toString();
    }
/**
 * Verifica se existem avarias por reparar
 * @return devolve a existencia de avarias por reparar
 */
    public boolean verificarAvarias() {

        boolean avariasValidas = false;

        for (int i = 0; i < avarias.size(); i++) {
            if (avarias.get(i).isAlterado() == false) {
                avariasValidas = true;
            }
        }

        return avariasValidas;
    }
/**
 * Verifica se existem nao docentes tecnicos
 * @return  devolve se existem não docentes tecnicos
 */
    public boolean verificaNaoDocenteTecnico() {

        boolean haNDTecnico = false;

        for (int i = 0; i < naoDocentes.size(); i++) {
            if ("tecnico".equalsIgnoreCase(naoDocentes.get(i).funcao)) {
                haNDTecnico = true;
            }
        }

        return haNDTecnico;
    }
/**
 * Verifica se existe nao docente tecnico numa escola
 * @param E recebe uma escola
 * @return devolve se existem nao docentes tecnicos numa escola
 */
    public boolean verificaNaoDocenteTecnicoEscola(Escola E) {

        boolean haNDTecnicoEscola = false;

        for (int i = 0; i < naoDocentes.size(); i++) {
            if ("tecnico".equalsIgnoreCase(naoDocentes.get(i).funcao) && naoDocentes.get(i).getEscolaTrabalho().equals(E)) {
                haNDTecnicoEscola = true;
            }
        }

        return haNDTecnicoEscola;
    }
/**
 * Lista laboratorios da escola
 * @param E recebe uma escola
 * @return devolve a lista 
 */
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
/**
 * lista os tipos de equipamento
 * @return devolve a lista dos tipos de equipamentos
 */
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
/**
 * lista os tipos de equipamentos e numero de equipamentos por tipo
 * @return devolve a lista
 */
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
/**
 * Lista os equipamentos
 * @return devolve a lista de equipamentos
 */
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
/**
 * Adiciona um tipo de equipamento
 * @param TE recebe um tipo de equipamento
 */
    public void adicionarTipoEquipamento(TipoEquipamento TE) {
        if (tipoEquipamentos.isEmpty()) {
            TE.setNumId(1);
        } else {
            TE.setNumId(tipoEquipamentos.get(tipoEquipamentos.size() - 1).getNumId() + 1);
        }
        tipoEquipamentos.add(TE);
    }
/**
 *Adiciona um equipamento 
 * @param EQ recebe um equipamento
 */
    public void adicionarEquipamento(Equipamento EQ) {
        if (equipamentos.isEmpty()) {
            EQ.setNumId(1);
        } else {
            EQ.setNumId(equipamentos.get(equipamentos.size() - 1).getNumId() + 1);
        }
        equipamentos.add(EQ);
        EQ.getND().setVerificaEliminar(true);
    }
/**
 * Adiciona um funcionarios docente
 * @param D recebe um funcionario docente
 */
    public void adicionarDocente(FuncionarioDocente D) {
        docentes.add(D);
        funcionarios.add(D);
    }
/**
 * Adiciona um laboratorio 
 * @param L recebe um laboratorio
 */
    public void adicionarLaboratorio(Laboratorio L) {
        laboratorios.add(L);
    }
/**
 * Adiciona um não docente
 * @param ND recebe um funcionario nao docente
 */
    public void adicionarNaoDocente(FuncionarioNaoDocente ND) {
        naoDocentes.add(ND);
        funcionarios.add(ND);
    }
/**
 * Remove um funcionario
 * @param pos recebe um posiçao
 */
    public void removerFuncionario(int pos) {

        Funcionario f = obterFuncionario(pos);
        docentes.remove(f);
        naoDocentes.remove(f);
        funcionarios.remove(f);
    }
/**
 * Adiciona uma escola
 * @param E recebe uma escola
 */
    public void adicionarEscola(Escola E) {
        escolas.add(E);

    }
/**
 * Obtem uma escola
 * @param pos recebe a posiçao da escola
 * @return devolve uma escola
 */
    public Escola obterEscola(int pos) {
        return escolas.get(pos);
    }
/**
 * Obtem um equipamento
 * @param pos recebe a posiçao
 * @return devolve um equipamento
 */
    public Equipamento obterEquipamento(int pos) {
        return equipamentos.get(pos);
    }
/**
 * Obtem um funcionario
 * @param pos recebe a posiçao
 * @return devolve um funcionario
 */
    public Funcionario obterFuncionario(int pos) {
        return funcionarios.get(pos);
    }
/**
 * Obtem um funcionario nao docente
 * @param pos recebe uma posiçao
 * @return devolve um funcionario nao docente
 */
    public FuncionarioNaoDocente obterFuncionarioNaoDocente(int pos) {
        return naoDocentes.get(pos);
    }
/**
 * obtem um laboratorio
 * @param pos recebe uma posiçao
 * @return devolve um laboratorio
 */
    public Laboratorio obterLaboratorio(int pos) {
        return laboratorios.get(pos);
    }
/**
 * Pesquisa um tipo de equipamento por id
 * @param id recebe um id
 * @return devolve a posiçao do tipo de equipamentos
 */
    public int pesquisarIdTipoEquipamento(int id) {
        for (int i = 0; i < tipoEquipamentos.size(); i++) {
            if (tipoEquipamentos.get(i).getNumId() == id) {
                return i;
            }
        }
        return -1;
    }
/**
 * Pesquisa um equipamento por id
 * @param id recebe um id
 * @return devolve a posiçao de um equipamento
 */
    public int pesquisarIdEquipamento(int id) {
        for (int i = 0; i < equipamentos.size(); i++) {
            if (equipamentos.get(i).getNumId() == id) {
                return i;
            }
        }
        return -1;
    }
/**
 * Pesquisa se uma avaria se nao foi alterada por id
 * @param id recebe o id 
 * @return devolve a posiçao da avaria
 */
    public int pesquisarAvariaNAlteradas(int id) {
        for (int i = 0; i < avarias.size(); i++) {
            if (avarias.get(i).getNumId() == id && avarias.get(i).isAlterado() == false) {
                return i;
            }
        }
        return -1;
    }
/**
 * Pesquisa uma escola por nif
 * @param nif recebe um nif
 * @return devolve a posiçao da escola
 */
    public int pesquisarEscolaNIF(int nif) {

        for (int i = 0; i < escolas.size(); i++) {
            if (escolas.get(i).getNif() == nif) {
                return i;
            }
        }
        return -1;

    }
/**
 * Pesquisa um funcionario por nif
 * @param nif recebe um nif
 * @return devolve a posiçao de um funcionario
 */
    public int pesquisarFuncionarioNIF(int nif) {

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNif() == nif) {
                return i;
            }
        }
        return -1;
    }
/**
 * pesquisa um nao docente tecnico por escola e nif
 * @param nif recebe nif
 * @param E recebe escola
 * @return devolve a posiçao
 */
    public int pesquisarNaoDocenteTecnico(int nif, Escola E) {
        for (int i = 0; i < naoDocentes.size(); i++) {
            if ("tecnico".equalsIgnoreCase(naoDocentes.get(i).funcao) && naoDocentes.get(i).getNif() == nif && naoDocentes.get(i).getEscolaTrabalho() == E) {
                return i;
            }
        }
        return -1;
    }
/**
 * Pesquisa laboratorio por descriçao
 * @param descricao recebe descriçao
 * @return devolve a posiçao do laboratorio
 */
    public int pesquisarLabDesc(String descricao) {
        for (int i = 0; i < laboratorios.size(); i++) {
            if (descricao.equalsIgnoreCase(laboratorios.get(i).getDescricao())) {
                return i;
            }
        }
        return -1;
    }
/**
 * Pesquisa um laboratorio por descriçao e escola
 * @param descricao recebe descriçao
 * @param E recebe escola
 * @return  devolve posiçao do laboratorio
 */
    public int pesquisarLabDescEscola(String descricao, Escola E) {
        for (int i = 0; i < laboratorios.size(); i++) {
            if (descricao.equalsIgnoreCase(laboratorios.get(i).getDescricao()) && laboratorios.get(i).getEscolaLab().equals(E)) {
                return i;
            }
        }
        return -1;
    }
/**
 * Pesquisa escola por nome
 * @param nome recebe o nome
 * @return devolve a posiçao da escola
 */
    public int pesquisarEscola(String nome) {
        for (int i = 0; i < escolas.size(); i++) {

            if (nome.equalsIgnoreCase(escolas.get(i).getNome())) {
                return i;
            }
        }
        return -1;
    }
/**
 * Valida o @ no email
 * @param email recebe o email 
 * @return devolve a validaçao
 */
    public int validarEmail(String email) {
        if (email.indexOf("@") == -1) {
            return -1;
        }
        return 0;
    }
/**
 * Numero de escolas
 * @return  devolve o numero de escolas
 */
    public int getSizeEscolas() {
        return escolas.size();
    }
/**
 * Numero de funcionarios
 * @return devolve o numero de funcionarios
 */
    public int getSizeFuncionarios() {
        return funcionarios.size();
    }
/**
 * Numero de docentes
 * @return devolve o numero de docentes
 */
    public int getSizeDocentes() {
        return docentes.size();
    }
/**
 * Numero de nao docentes
 * @return devolve o numero de nao docentes
 */
    public int getSizeNaoDocentes() {
        return naoDocentes.size();
    }
/**
 * Numero de tipos de equipamento
 * @return devolve o numero de tipo de equipamentos
 */
    public int getSizeTipoEquipamento() {
        return tipoEquipamentos.size();
    }
/**
 * Numero de laboratorios
 * @return devolve o numero de laboratorios
 */
    public int getSizeLaboratorio() {
        return laboratorios.size();
    }
/**
 * Numero de equipamentos
 * @return devolve o numero de equipamentos
 */
    public int getSizeEquipamento() {
        return equipamentos.size();
    }
/**
 * Numero de avarias
 * @return devolve o numero de avarias
 */
    public int getSizeAvarias() {
        return avarias.size();
    }
/**
 * Grava ficheiro
 */
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
/**
 * Lê ficheiro
 */
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

}
