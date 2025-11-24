package org.example.lab4_trs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_group")
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "product_group_parameter_group",
            joinColumns = @JoinColumn(name = "product_group_id"),
            inverseJoinColumns = @JoinColumn(name = "parameter_group_id")
    )
    private Set<ParameterGroup> parameterGroups;


}