package ek.app.social.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "TB_ROLES")
@Getter
@Setter
@RequiredArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles")
    private Long idRoles;
    private String roleName;

    public enum Values{
        ADMIN(1L),
        BASIC(2L);
        long idRoles;

        Values(long idRoles){
            this.idRoles = idRoles;
        }

        public long getIdRoles() {
            return idRoles;
        }
    }
}
