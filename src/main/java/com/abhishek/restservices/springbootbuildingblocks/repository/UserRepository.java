package com.abhishek.restservices.springbootbuildingblocks.repository;

import com.abhishek.restservices.springbootbuildingblocks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
