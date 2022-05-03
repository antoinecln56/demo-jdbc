package org.diginamic.fr.dao;

import java.util.List;


/**
 * Idao est une interface Générique pour toutes les futures classes de type Idao
 * @param <T>
 */
public interface Idao<T> {

    List<T> extraire();
    void insert(T data);
    int update(T ancienNom ,T nouveauNom);
    boolean delete(T data);

}
