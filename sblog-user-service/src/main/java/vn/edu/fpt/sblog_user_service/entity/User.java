package vn.edu.fpt.sblog_user_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Username")
    private String username;

    @Column(name = "HashedPassword")
    private String hashedPassword;
}
