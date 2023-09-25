package org.example.dao.impl;

import jakarta.persistence.EntityManagerFactory;
import org.example.dao.PersonDao;
import org.example.model.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    private SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

    @Override
    public Person create(Person person) {

        Session session = sessionFactory.getCurrentSession();
        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        session.saveOrUpdate(person);
        return person;
    }

    @Override
    public Person readById(long id) {

        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        return person;
    }

    @Override
    public List<Person> readAll() {

        Session session = sessionFactory.getCurrentSession();
        List<Person> persons = session.createQuery("from Person", Person.class).getResultList();
        return persons;
    }

    @Override
    public Person update(Person person) {

        Session session = sessionFactory.getCurrentSession();
        session.update(Person.class);
        return person;
    }

    @Override
    public void deleteById(long id) {

        Session session = sessionFactory.getCurrentSession();
        Query<Person> query = session.createQuery("delete from Person where id = :personId");
        query.setParameter("personId", id);
        query.executeUpdate();

    }


//    //private ConnectionPool connectionPool;
//
////    private ConnectionImpl connectionImpl;
////
////    public PersonDaoImpl(ConnectionPool connectionPool) {
////        this.connectionPool = connectionPool;
////    }
//
////    public PersonDaoImpl(ConnectionImpl connectionImpl) {
////        this.connectionImpl = connectionImpl;
////    }
//
//    @Override
//    public Person create(@NotNull Person person) throws SQLException {
//
//        Connection connection = connectionImpl.getConnections();
//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person " +
//                "(first_name, last_name) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
//        preparedStatement.setString(1, person.getFirstName());
//        preparedStatement.setString(2, person.getLastName());
//        preparedStatement.executeUpdate();
//        //connectionPool.releaseConnection(connection);
//        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//        if(generatedKeys.next()) {
//            person.setId(generatedKeys.getInt("id"));
//        }
//        return person;
//    }
//
//    @Override
//    public Person readById(int id) throws SQLException {
//
//        Person person = new Person();
//        Connection connection = connectionImpl.getConnections();
//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
//        preparedStatement.setInt(1, id);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        List<Vehicle> vehicles = new ArrayList<>();
//        while (resultSet.next()) {
//            person.setId(id);
//            person.setFirstName(resultSet.getString("first_name"));
//            person.setLastName(resultSet.getString("last_name"));
//            person.setVehicles(vehicles);
//        }
//
//        preparedStatement = connection.prepareStatement("SELECT * FROM vehicle WHERE person_id = ?");
//        preparedStatement.setInt(1, person.getId());
//        resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            Vehicle vehicle = new Vehicle();
//            vehicle.setId(resultSet.getInt("id"));
//            vehicle.setType(resultSet.getString("type"));
//            vehicle.setModel(resultSet.getString("model"));
//            vehicles.add(vehicle);
//        }
//        //connectionPool.releaseConnection(connection);
//        return person;
//    }
//
//    @Override
//    public List<Person> readAll() {
//
//        Session session = sessionFactory.getCurrentSession();
//        List<Person> persons = session.createQuery("from Person", Person.class).getResultList();
//
////        Connection connection = connectionImpl.getConnections();
////        Statement statement = connection.createStatement();
////        ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
////        while (resultSet.next()) {
////            Person person = new Person();
////            List<Vehicle> vehicles = new ArrayList<>();
////            person.setId(resultSet.getInt("id"));
////            person.setFirstName(resultSet.getString("first_name"));
////            person.setLastName(resultSet.getString("last_name"));
////            person.setVehicles(vehicles);
////
////            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicle " +
////                    "WHERE person_id = ?");
////            preparedStatement.setInt(1, person.getId());
////            ResultSet vehiclesResultSet = preparedStatement.executeQuery();
////            while (vehiclesResultSet.next()) {
////                Vehicle vehicle = new Vehicle();
////                vehicle.setId(vehiclesResultSet.getInt("id"));
////                vehicle.setType(vehiclesResultSet.getString("type"));
////                vehicle.setModel(vehiclesResultSet.getString("model"));
////                vehicles.add(vehicle);
////            }
////            persons.add(person);
////        }
////       // connectionPool.releaseConnection(connection);
//        return persons;
//    }
//
//    @Override
//    public Person update(Person person) throws SQLException {
//
//        Connection connection = connectionImpl.getConnections();
//        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE person " +
//                "SET first_name = ?, last_name = ? WHERE id = ?");
//        preparedStatement.setString(1, person.getFirstName());
//        preparedStatement.setString(2, person.getLastName());
//        preparedStatement.setInt(3, person.getId());
//        preparedStatement.execute();
//        //connectionPool.releaseConnection(connection);
//        return person;
//    }
//
//    @Override
//    public void deleteById(int id) throws SQLException {
//
//        Connection connection = connectionImpl.getConnections();
//        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM vehicle " +
//                "WHERE person_id = ?");
//        deleteStatement.setInt(1, id);
//        deleteStatement.executeUpdate();
//
//        deleteStatement = connection.prepareStatement("DELETE FROM person WHERE id = ?");
//        deleteStatement.setInt(1, id);
//        deleteStatement.executeUpdate();
//        //connectionPool.releaseConnection(connection);
//    }
//
//    private PersonDaoImpl() {
//    }
//
//    private static class PersonDoaImplHolder {
//        private final static PersonDaoImpl instance = new PersonDaoImpl();
//    }
//
//    public static PersonDaoImpl getInstance() {
//        return PersonDoaImplHolder.instance;
//    }
}