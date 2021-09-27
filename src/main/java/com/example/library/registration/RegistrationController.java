package com.example.library.registration;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public void register(@RequestBody RegistrationRequest request) {
        registrationService.register(request);
    }

}