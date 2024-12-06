package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import app.dto.UserDTO;
import app.entities.User;
import app.repositories.UserRepository;

@Component
public class UserComponent {
    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User createdUser = userRepository.save(user);
        return convertToDTO(createdUser);
    }

    public Optional<UserDTO> getUser(int IDNumber) {
        return userRepository.findByIdNumber(IDNumber).map(this::convertToDTO);
    }
    
 // Add the authenticateUser method here
    public User authenticateUser(int IDNumber, String password) {
        Optional<User> user = userRepository.findByIdNumber(IDNumber);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setIdNumber(user.getIDNumber());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setIDNumber(userDTO.getIdNumber());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        return user;
    }
}