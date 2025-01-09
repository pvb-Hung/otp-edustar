package com.example.ttcn2etest.model.etity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Proxy;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Builder
@Proxy(lazy = false)
@Table(name = "class_user")
public class ClassUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "class_id", nullable = false)
    private String classId;

    @JoinColumn(name = "id_user", nullable = false)
    private Long idUser;


}