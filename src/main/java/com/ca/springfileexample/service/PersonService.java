package com.ca.springfileexample.service;

import com.ca.springfileexample.entity.Person;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface PersonService {
    List<Person> getAll();

    ByteArrayInputStream excelOutput();

    void excelInput(MultipartFile file);
}
