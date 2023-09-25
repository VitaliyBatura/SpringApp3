package org.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.dao.PersonDao;
import org.example.model.entity.Person;
import org.example.service.PersonService;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public Person create(Person person) {
        return personDao.create(person);
    }

    @Override
    @Transactional
    public Person readById(long id) {
        return personDao.readById(id);
    }

    @Override
    @Transactional
    public List<Person> readAll() {
        return personDao.readAll();
    }

    @Override
    @Transactional
    public Person update(Person person) {
        return personDao.update(person);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        personDao.deleteById(id);
    }


//    private ObjectMapper objectMapper = new ObjectMapper();
//    private PersonDaoImpl personDao;
//    PersonMapper personMapper = new PersonMapper();
//    public PersonServiceImpl() {
//    }
//
//    public PersonServiceImpl(PersonDaoImpl personDao) {
//        this.personDao = personDao;
//    }
//
//    public PersonServiceImpl(PersonDaoImpl personDao, PersonMapper personMapper) {
//        this.personDao = personDao;
//        this.personMapper = personMapper;
//    }
//
//    public Optional<String> handleGetRequest(String parameter) throws SQLException {
//
//        if (parameter == null) {
//            List<PersonDto> persons = personDao.readAll().stream().map(person ->
//                    personMapper.convertToPersonDto(person)).collect(Collectors.toList());
//            try {
//                return Optional.ofNullable(objectMapper.writeValueAsString(persons));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        } else {
//            int id = Integer.parseInt(parameter);
//            Person person = personDao.readById(id);
//            PersonDto personDto = new PersonDto();
//            if(person != null) {
//                personDto = personMapper.convertToPersonDto(person);
//            }
//            try {
//                return Optional.ofNullable(objectMapper.writeValueAsString(personDto));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//        return Optional.empty();
//    }
//
//    public Person handlePostRequest(Person person) throws SQLException {
//
//            personDao.create(person);
//            return person;
//    }
//
//    public void handlePutRequest(Person person) throws SQLException {
//
//        personDao.update(person);
//    }
//
//    public void handleDeleteRequest(int personId) throws SQLException {
//
//        personDao.deleteById(personId);
//    }
//
//    private static class PersonServiceHolder {
//        private final static PersonServiceImpl instance = new PersonServiceImpl();
//    }
//
//    public static PersonServiceImpl getInstance() {
//        return PersonServiceHolder.instance;
//    }
}