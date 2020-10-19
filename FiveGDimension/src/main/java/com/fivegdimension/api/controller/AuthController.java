package com.fivegdimension.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fivegdimension.api.entity.AuthRequest;
import com.fivegdimension.api.util.JWTUtil;


@RestController
@RequestMapping("/api")
public class AuthController {

    private final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JWTUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;

	@GetMapping("/hello")
	public String welcome() {
		System.out.println("welcome ******************************* ");
		return "Welcome to my app";
	}
	
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
    	System.out.println("java ******************************* ");
    	try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
    	System.out.println("authenticate ******************************* ");
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}

