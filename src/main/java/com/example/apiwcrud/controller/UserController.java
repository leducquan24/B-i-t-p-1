package com.example.apiwcrud.controller;

import com.example.apiwcrud.model.UserssEntity;
import com.example.apiwcrud.service.UserService;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController

public class UserController {
    @Autowired
            @Id
    UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseEntity<List<UserssEntity>> findAllUser() {
        List<UserssEntity> lsUser = userService.findAll();
        if(lsUser.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserssEntity>>(lsUser, HttpStatus.OK);
    }

    //userbyname?name=oanh
    @RequestMapping(value = "userbyname", method = RequestMethod.GET)
    public ResponseEntity<List<UserssEntity>> findAllUser(@PathParam("name") String name) {
        List<UserssEntity> lsUser = userService.findAllByName(name);
        if(lsUser.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserssEntity>>(lsUser, HttpStatus.OK);
    }


    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public ResponseEntity<UserssEntity> saveNewUser(@RequestBody UserssEntity u) {
        userService.saveUser(u);
        return new ResponseEntity<UserssEntity>(u, HttpStatus.OK);
    }

    //http://localhost:8080/updateUser?id=1
    @RequestMapping(value = "updateUser", method = RequestMethod.PUT)
    public ResponseEntity<UserssEntity> updateUser(
            @PathParam("id") Integer id,
            @RequestBody UserssEntity u) {
        UserssEntity oldUser = userService.findById(id);
        oldUser.setEmail(u.getEmail());
        oldUser.setName(u.getName());
        oldUser.setPhone(u.getPhone());
        userService.saveUser(oldUser);
        return new ResponseEntity<UserssEntity>(oldUser, HttpStatus.OK);
    }

    @RequestMapping(value = "updateUser2/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserssEntity> updateUser2(
            @PathVariable(value = "id") Integer id,
            @RequestBody UserssEntity u) {
        UserssEntity oldUser = userService.findById(id);
        oldUser.setEmail(u.getEmail());
        oldUser.setName(u.getName());
        oldUser.setPhone(u.getPhone());
        userService.saveUser(oldUser);
        return new ResponseEntity<UserssEntity>(oldUser, HttpStatus.OK);
    }

    @RequestMapping(value = "deleteuser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserssEntity> deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
