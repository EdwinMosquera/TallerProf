package co.edu.poli.ces4.userservice.controller;


import co.edu.poli.ces4.userservice.helper.Response;
import co.edu.poli.ces4.userservice.helper.ResponseBuild;
import co.edu.poli.ces4.userservice.persistence.entity.User;
import co.edu.poli.ces4.userservice.service.DTO.UserDTO;
import co.edu.poli.ces4.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ResponseBuild responseBuild;


    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setLast_name(userDTO.getLast_name());
        return user;
    }

    @PostMapping
    public Response save(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<Map<String, String>> errors = format(result);
            return this.responseBuild.failed(errors);
        }
        User user = convertToEntity(userDTO);
        userService.save(user);
        return responseBuild.success(user);
    }

    @GetMapping
    public Response findAll() {
        List<User> usuarios = this.userService.findAll();
        return this.responseBuild.success(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getMovieById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    private List<Map<String, String>> format(BindingResult result) {
        return result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> newError = new HashMap<>();
                    newError.put(error.getField(), error.getDefaultMessage());
                    return newError;
                }).collect(Collectors.toList());
    }
}


