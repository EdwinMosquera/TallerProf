package co.edu.poli.ces4.userservice.controller;

import co.edu.poli.ces4.userservice.helper.Response;
import co.edu.poli.ces4.userservice.helper.ResponseBuild;
import co.edu.poli.ces4.userservice.persistence.entity.User;
import co.edu.poli.ces4.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserContrller {

    private final UserService service;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(format(result));
        }
        service.save(user);
        return build.success(user);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        User user = service.findById(id);
        service.delete(user);
        return build.success(user);
    }

    @GetMapping
    public Response findAll() {
        return build.success(service.findAll());
    }


    public Response findById(@PathVariable("id") Long id) {
        return build.success(service.findById(id));
    }

    private List<Map<String, String>> format(BindingResult result) {
        return result.getFieldErrors()
                .stream().map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
    }
}
