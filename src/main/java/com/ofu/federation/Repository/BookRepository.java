package com.ofu.federation.Repository;

import com.ofu.federation.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {

}
