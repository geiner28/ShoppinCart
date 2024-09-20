package com.services.ms.shoppingCart.app.infrastructure.adapters;


import com.services.ms.shoppingCart.app.aplication.ports.input.UserServicePort;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.mapper.UserRestMapper;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.request.UserCreateRequest;
import com.services.ms.shoppingCart.app.infrasture.adapters.input.rest.model.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestAdapter {

    private final UserServicePort userServicePort;
    private final UserRestMapper userRestMapper;

    @GetMapping("/v1/api")
    public List<UserResponse> finAll(){
        return userRestMapper.toUserResponses(userServicePort.findAllUsers());
    }
@GetMapping("/test")
public ResponseEntity<String> test() {
    return ResponseEntity.ok("Endpoint is working");
}




    @GetMapping("/v1/api/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return userRestMapper.toUserResponse(userServicePort.findUserById(id));

}

@PostMapping("/v1/api")
@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserCreateRequest request ) {
return  ResponseEntity.status(HttpStatus.CREATED)
        .body(userRestMapper.toUserResponse(
                userServicePort.saveUser(userRestMapper.toUser(request))
        ));

}



@PutMapping("/v1/api/{id}")
public UserResponse update(@PathVariable Long id,@Valid @RequestBody UserCreateRequest request ) {
        return userRestMapper.toUserResponse(
                userServicePort.updateUser(id, userRestMapper.toUser(request))
        );
}



@DeleteMapping("/v1/api/{id}")
    public void delete(@PathVariable Long id) {
        userServicePort.deleteUser(id);
}

}
