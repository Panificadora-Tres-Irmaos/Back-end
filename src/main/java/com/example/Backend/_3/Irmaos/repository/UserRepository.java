package com.example.Backend._3.Irmaos.repository;

import com.example.Backend._3.Irmaos.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
