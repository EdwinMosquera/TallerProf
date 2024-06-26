package co.edu.poli.ces4.booking.clientFeign;


import co.edu.poli.ces4.booking.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user")
public interface UserClient {
    @GetMapping("/api/v1/poli/users/{id}")
    User getUserById(@PathVariable("id")Long id);
}
