package com.example.demoms2.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "legal_entities")
public class LegalEntity {
    @Id @GeneratedValue
    private Long id;
    @NotBlank
    private String name;
    @OneToOne
    private LicenseDetails licenseDetails;
}
