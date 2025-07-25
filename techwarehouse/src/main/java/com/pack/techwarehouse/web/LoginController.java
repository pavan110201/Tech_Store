package com.pack.techwarehouse.web;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pack.techwarehouse.domain.AccountCredentials;
import com.pack.techwarehouse.service.JwtService;
import java.util.Map;
@RestController
public class LoginController 
{
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) 
    {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) 
    {
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password());
        Authentication auth = authenticationManager.authenticate(creds);
        String jwt = jwtService.getToken(auth.getName());
        return ResponseEntity.ok()
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
            .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
            .body(Map.of("token", "Bearer " + jwt)); 
    }
}