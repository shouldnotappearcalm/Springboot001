package com.gzr.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ${description}
 * Created by GZR
 * 2017-07-01
 */

public interface UserRepository extends MongoRepository<User,Long>{

    User findByUsername(String username);
}
