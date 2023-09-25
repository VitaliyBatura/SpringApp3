package org.example.dao.impl;

import org.example.dao.TyreDao;
import org.example.model.entity.Tyre;

import java.sql.*;
import java.util.List;

public class TyreDaoImpl implements TyreDao {
    @Override
    public Tyre create(Tyre tyre) throws SQLException {
        return null;
    }

    @Override
    public Tyre readById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Tyre> readAll() throws SQLException {
        return null;
    }

    @Override
    public Tyre update(Tyre tyre) throws SQLException {
        return null;
    }

    @Override
    public void deleteById(int id) throws SQLException {

    }

//    private ConnectionPool connectionPool;
//
//    private ConnectionImpl connectionImpl;
//    public TyreDaoImpl(ConnectionPool connectionPool) {
//        this.connectionPool = connectionPool;
//    }
//
//    @Override
//    public Tyre create(@NotNull Tyre tyre) throws SQLException {
//
//        Connection connection = connectionImpl.getConnections();
//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tyre " +
//                "(name, season) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
//        preparedStatement.setString(1, tyre.getName());
//        preparedStatement.setString(2, tyre.getSeason());
//        preparedStatement.executeUpdate();
//        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//        if(generatedKeys.next()) {
//            tyre.setId(generatedKeys.getInt("id"));
//        }
//        //connectionPool.releaseConnection(connection);
//        return tyre;
//    }
//
//    @Override
//    public Tyre readById(int id) throws SQLException {
//
//        Tyre tyre = new Tyre();
//        Set<Vehicle> vehicles = new LinkedHashSet<>();
//        Connection connection = connectionImpl.getConnections();
//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tyre WHERE id = ?");
//        preparedStatement.setInt(1, id);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            tyre.setId(resultSet.getInt("id"));
//            tyre.setName(resultSet.getString("name"));
//            tyre.setSeason(resultSet.getString("season"));
//            tyre.setVehicles(vehicles);
//        }
//
//        preparedStatement = connection.prepareStatement("SELECT * FROM vehicle JOIN vehicle_tyre vt on " +
//                "vehicle.id = vt.vehicle_id WHERE tyre_id = ?");
//        preparedStatement.setInt(1, tyre.getId());
//        resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            Vehicle vehicle = new Vehicle();
//            vehicle.setId(resultSet.getInt("id"));
//            vehicle.setType(resultSet.getString("type"));
//            vehicle.setModel(resultSet.getString("model"));
//            vehicles.add(vehicle);
//        }
//        //connectionPool.releaseConnection(connection);
//        return tyre;
//    }
//
//    @Override
//    public List<Tyre> readAll() throws SQLException {
//
//        Connection connection = connectionImpl.getConnections();
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM tyre");
//        List<Tyre> tyres = new ArrayList<>();
//        while (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            Tyre tyre = readById(id);
//            tyres.add(tyre);
//        }
//        //connectionPool.releaseConnection(connection);
//        return tyres;
//    }
//
//    @Override
//    public Tyre update(Tyre tyre) throws SQLException {
//
//        Connection connection = connectionImpl.getConnections();
//        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tyre SET name = ?, " +
//                "season = ? WHERE id = ?");
//        preparedStatement.setString(1, tyre.getName());
//        preparedStatement.setString(2, tyre.getSeason());
//        preparedStatement.setInt(3, tyre.getId());
//        preparedStatement.execute();
//        //connectionPool.releaseConnection(connection);
//        return tyre;
//    }
//
//    @Override
//    public void deleteById(int id) throws SQLException {
//
//        Connection connection = connectionImpl.getConnections();
//        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM tyre WHERE id = ?");
//        deleteStatement.setInt(1, id);
//        deleteStatement.execute();
//        //connectionPool.releaseConnection(connection);
//    }
//
//    private TyreDaoImpl() {
//    }
//
//    private static class TyreDoaImplHolder {
//        private final static TyreDaoImpl instance = new TyreDaoImpl();
//    }
//
//    public static TyreDaoImpl getInstance() {
//        return TyreDoaImplHolder.instance;
//    }
}