package com.lms.services;

import com.lms.dao.LmsRepository;
import com.lms.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class LmsService {

    @Autowired
    LmsRepository lmsRepository;

    public Collection<Book> findAllBooks(){
        List<Book> books = new ArrayList<Book>();
        for(Book book : lmsRepository.findAll()){
            books.add(book);
        }
        return books;
    }
}
