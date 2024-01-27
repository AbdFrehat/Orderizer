package com.selling.system.auth.shared.module.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

import static com.selling.system.auth.shared.module.constants.Validator.PROFILE_NAME_VALIDATOR_MESSAGE;

@Data
public class ProfileInsertRequest {

    @NotBlank(message = PROFILE_NAME_VALIDATOR_MESSAGE)
    private String profileName;

    private Set<String> authorities;

}