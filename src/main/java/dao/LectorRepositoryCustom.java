package dao;

import model.Lector;

import java.util.List;

public interface LectorRepositoryCustom {

    List<Lector> searchBy(String line);

}
