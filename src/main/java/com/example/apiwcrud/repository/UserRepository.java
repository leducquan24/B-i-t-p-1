package com.example.apiwcrud.repository;

import com.example.apiwcrud.model.UserssEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
        extends JpaRepository<UserssEntity, Integer> {
    List<UserssEntity> findAllByName(String name);
    List<UserssEntity> findAllByNameContainsIgnoreCase(String name);
    List<UserssEntity> findAllByNameAndEmail(String name, String email);
    List<UserssEntity> findAllByNameOrderByEmailAsc(String name);
}
