package cn.kilog.cap.securityOAuth2.controller;

import cn.kilog.cap.securityOAuth2.pojo.JwtAuthenticationRequest;
import cn.kilog.cap.securityOAuth2.pojo.JwtAuthenticationResponse;
import cn.kilog.cap.securityOAuth2.pojo.User;
import cn.kilog.cap.securityOAuth2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("auth")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@RequestBody User addedUser) throws Exception {
        return authService.register(addedUser);
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }
}
