package com.Idat.AppApuestas.Services;
import com.Idat.AppApuestas.DTO.UserDTO;
import com.Idat.AppApuestas.Models.bet;
import com.Idat.AppApuestas.Models.user;
import com.Idat.AppApuestas.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BetService betService;

    public List<user> getAllUsers() {
        return this.userRepository.findAll();
    }

    public user addUser(UserDTO userDTO) {

        user User = new user(
                userDTO.getName(),
                userDTO.getLastName(),
                userDTO.getDocument(),
                userDTO.getDateNac(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getPhone(),
                userDTO.getAddress(),
                userDTO.getCity(),
                userDTO.getCard(),
                userDTO.getDateCard(),
                userDTO.getCodCard(),
                userDTO.getCash(),
                userDTO.getRole()
        );
        return this.userRepository.save(User);
    }

    public Optional<user> buscarUserId(Long id) {
        return this.userRepository.findById(id);
    }

    public boolean deleteUserById(Long id) {
        try {
            this.userRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    @Transactional
    public user updateUser(Long id,UserDTO userDTO) {

        Optional<user> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            user UserDB = userOptional.get();
            if(userDTO.getName() != null) {
                UserDB.setName(userDTO.getName());
            }if(userDTO.getLastName() != null) {
                UserDB.setLastName(userDTO.getLastName());
            }if(userDTO.getDocument() != null) {
                UserDB.setDocument(userDTO.getDocument());
            }if(userDTO.getDateNac() != null) {
                UserDB.setDateNac(userDTO.getDateNac());
            }if(userDTO.getEmail() != null) {
                UserDB.setEmail(userDTO.getEmail());
            }if(userDTO.getPassword() != null) {
                UserDB.setPassword(userDTO.getPassword());
            }if(userDTO.getPhone() != null) {
                UserDB.setPhone(userDTO.getPhone());
            }if(userDTO.getAddress() != null) {
                UserDB.setAddress(userDTO.getAddress());
            }if(userDTO.getCity() != null) {
                UserDB.setCity(userDTO.getCity());
            }if(userDTO.getCard() != null) {
                UserDB.setCard(userDTO.getCard());
            }if(userDTO.getDateCard() != null) {
                UserDB.setDateCard(userDTO.getDateCard());
            }if(userDTO.getCodCard() != null) {
                UserDB.setCodCard(userDTO.getCodCard());
            }if(userDTO.getCash() != null) {
                UserDB.setCash(userDTO.getCash());
            }if(userDTO.getRole() != null) {
                UserDB.setRole(userDTO.getRole());
            }
            return userRepository.save(UserDB);
        }else{
            return null;
        }
    }
}
