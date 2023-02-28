package com.example.clinicaprivata.repository.database;

import com.example.clinicaprivata.domain.Sectie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SectieDBRepository extends AbstractDBRepository<Integer, Sectie> {
    @Override
    protected PreparedStatement getSaveStatement(Connection connection, Sectie entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getRemoveStatement(Connection connection, Integer integer) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection connection, Sectie entity, Sectie newEntity) throws SQLException {
        return null;
    }

    @Override
    protected String getTable() {
        return "sectii";
    }

    @Override
    protected Sectie createEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String nume = resultSet.getString("nume");
        Integer sef = resultSet.getInt("sef");
        Integer pret = resultSet.getInt("pret");
        Integer durata = resultSet.getInt("durata");
        Sectie sectie = new Sectie(id, nume, sef, pret, durata);
        sectie.setId(id);
        return sectie;
    }
}