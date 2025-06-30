package net.fullStack.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.fullStack.journalApp.entity.User;
import net.fullStack.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j

@Component
public class UserService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    private UserRepository userRepository;//dependancy injection


    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("User"));
        userRepository.save(user);

    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){

        return userRepository.findAll();
    }

public Optional<User> findById(ObjectId id){

        return userRepository.findById(id);
}

public void deleteById(ObjectId id){

        userRepository.deleteById(id);
}

public User findByUserName(String username){
        return  userRepository.findByUserName(username);
}



}
