package devlava.springsecurity6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_MEMBER")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @Column(length = 50)
    private String skid;

    @Column(length = 50)
    private String username;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Token token;
}