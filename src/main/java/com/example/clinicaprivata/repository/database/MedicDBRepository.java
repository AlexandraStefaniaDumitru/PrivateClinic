package com.example.clinicaprivata.repository.database;

import com.example.clinicaprivata.domain.Medic;
import com.example.clinicaprivata.domain.Sectie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicDBRepository extends AbstractDBRepository<Integer, Medic> {
    @Override
    protected PreparedStatement getSaveStatement(Connection connection, Medic entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getRemoveStatement(Connection connection, Integer integer) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection connection, Medic entity, Medic newEntity) throws SQLException {
        return null;
    }

    @Override
    protected String getTable() {
        return "medici";
    }

    @Override
    protected Medic createEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer sectie = resultSet.getInt("sectie");
        String nume = resultSet.getString("nume");
        Integer vechime = resultSet.getInt("vechime");
        Boolean rezident = resultSet.getBoolean("rezident");
        Medic medic = new Medic(id,sectie, nume, vechime, rezident);
        medic.setId(id);
        return medic;
    }
}