package com.example.springbootunittest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
@TypeAlias("capability-model")
public class Capability extends RepresentationModel<Capability> {
    @Id
    private String id;

    @NotBlank(message = "Technology Stack cannot be blank")
    @NotNull(message = "Technology Stack cannot be null")
    private String techStack;
    private Integer numOfDevelopers = 0;
    private Integer numOfAvailableDevelopers = 0;
}
