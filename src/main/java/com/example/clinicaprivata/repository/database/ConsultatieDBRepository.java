package com.example.clinicaprivata.repository.database;

import com.example.clinicaprivata.domain.Consultatie;
import com.example.clinicaprivata.domain.Medic;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultatieDBRepository extends AbstractDBRepository<Integer, Consultatie> {
    @Override
    protected PreparedStatement getSaveStatement(Connection connection, Consultatie entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO consultatii (id, medic, cnp, nume, datta, ora) VALUES (?,?,?,?,?,?)");
        statement.setInt(1, Math.toIntExact(entity.getId()));
        statement.setInt(2, Math.toIntExact(entity.getMedic()));
        statement.setInt(3, Math.toIntExact(entity.getCnp()));
        statement.setString(4, entity.getNume());
        statement.setDate(5, Date.valueOf(entity.getDatta()));
        statement.setTime(6, Time.valueOf(entity.getOra()));
        return statement;
    }

    @Override
    protected PreparedStatement getRemoveStatement(Connection connection, Integer integer) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection connection, Consultatie entity, Consultatie newEntity) throws SQLException {
        return null;
    }

    @Override
    protected String getTable() {
        return "consultatii";
    }

    @Override
    protected Consultatie createEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer medic = resultSet.getInt("medic");
        Integer cnp = resultSet.getInt("cnp");
        String nume = resultSet.getString("nume");
        LocalDate datta = resultSet.getDate("datta").toLocalDate();
        LocalTime ora = resultSet.getTime("ora").toLocalTime();
        Consultatie consultatie = new Consultatie(id,medic,cnp,nume,datta,ora);
        consultatie.setId(id);
        return consultatie;
    }
}