package com.packetprep.system.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long userId;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Password is required")
    private String password;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    @ManyToOne(fetch = LAZY)
    private Role role;
    @ManyToMany(fetch = LAZY, mappedBy = "user")
    private List<Day> day;
    @ManyToOne(fetch = LAZY)
    private Batch batch;
    private Instant created;
    private boolean enabled;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Image image;

    @NotBlank
    private String surname;
    @NotBlank
    private String status;
    @NotBlank
    private String collegeName;
    @NotBlank
    private String universityName;
    @NotBlank
    private String state;
    @NotBlank
    private String city;
    @NotBlank
    private String birthDate;
    @NotBlank
    private String tenthMarks;
    @NotBlank
    private String twelfthMarks;
    @NotBlank
    private String graduationMarks;
    @NotBlank
    private String yearOfPassing;
    @NotBlank
    private String number;
    @NotBlank
    private String gender;
    @NotBlank
    private String graduation;
    @NotBlank
    private String graduationBranch;
}
