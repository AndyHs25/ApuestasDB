package com.Idat.AppApuestas.Controllers;


import com.Idat.AppApuestas.DTO.UserDTO;
import com.Idat.AppApuestas.Models.user;
import com.Idat.AppApuestas.Services.MatchService;
import com.Idat.AppApuestas.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<user> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public user addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping("/{id}")
    public Optional<user> getUserById(@PathVariable Long id) {
        return userService.buscarUserId(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<user> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        user user = userService.updateUser(id,userDTO);
        if(user != null) {
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }


}

