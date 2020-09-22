package com.ca.springfileexample.service;

import com.ca.springfileexample.entity.Person;
import com.ca.springfileexample.fileoperation.ExcelDownload;
import com.ca.springfileexample.fileoperation.ExcelUpload;
import com.ca.springfileexample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public ByteArrayInputStream excelOutput() {
        List<Person> users = personRepository.findAll();

        ByteArrayInputStream in = ExcelDownload.personsToExcel(users);
        return in;
    }

    @Override
    public void excelInput(MultipartFile file) {
        try {
            List<Person> persons = ExcelUpload.excelToPersons(file.getInputStream());
            personRepository.saveAll(persons);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}
