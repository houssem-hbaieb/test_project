package com.example.test.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {


    @GetMapping("/admin")
    @PreAuthorize("hasRole(' ROLE_ADMIN')")
    public String adminAccess() {
        return "✅ Hello Admin! This endpoint is protected.";
    }


    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String userAccess() {
        return "✅ Hello User! This endpoint is protected.";
    }

    @GetMapping("/public")
    public String publicAccess() {
        return "🌐 Hello World! This is public.";
    }

}
