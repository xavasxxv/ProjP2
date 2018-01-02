/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao_equipamentos;

import java.util.Comparator;

/**
 *
 * @author ricar
 */
public class ComparadorTotalAvarias implements Comparator<AuxEst> {

    @Override
    public int compare(AuxEst t, AuxEst t1) {

        if (t.getNumEquipAvarias() < t1.getNumEquipAvarias()) {
            return 1;
        }
        if (t.getNumEquipAvarias() > t1.getNumEquipAvarias()) {
            return -1;
        }
        return 0;
    }

}
