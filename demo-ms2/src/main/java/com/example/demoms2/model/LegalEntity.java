package com.example.demoms2.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "legal_entity")
public class LegalEntity {
    @Id @GeneratedValue
    private Long id;
    @NotBlank
    private String companyName;
    @OneToOne
    private LicenseDetails licenseDetails;
}
