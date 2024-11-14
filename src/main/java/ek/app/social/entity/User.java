package ek.app.social.entity;

import ek.app.social.dto.ReqLoginDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER) //Cascade: em modelo transacional, o cascade faz com que tudo que seja atribuido aquele usuário, seja dropado, realizando assim um processo em cascata, por isso o nome cascade.
    @JoinTable(name = "tb_users_role", joinColumns = @JoinColumn (name = "user_id"), inverseJoinColumns = @JoinColumn(name = "id_roles")) //Join: cria uma tabela intermediária, na qual é populada com as duas chaves principais das tabelas subsequentes informadas, gerando assim uma unica tabela na qual tem atrelado um usuário e uma role.
    private Set<Role> roles;


    public boolean isPasswordCorrect(ReqLoginDto loginDto, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginDto.password(), this.password);
    }
}
