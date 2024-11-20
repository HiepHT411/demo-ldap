package com.example.authenticatingldap.openldapdocker;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class AuthorizedController {
    @Operation(summary = "Get string from public endpoint")
    @GetMapping("/public")
    public String getPublicString() {
        return "It is public.";
    }

    @Operation(
            summary = "Get string from private/secured endpoint")
    @GetMapping("/private")
    public String getPrivateString(Principal principal) {
        return principal.getName() + ", it is private.";
    }
}
