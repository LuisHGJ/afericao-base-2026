package application.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Entidade que representa um usuário do sistema")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Schema(
        description = "Nome de usuário para login",
        example = "joao123",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Column(name = "nome_de_usuario", nullable = false, unique = true)
    private String nomeDeUsuario;
    @Schema(
        description = "Senha do usuário",
        example = "senha123",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Column(nullable = false)
    private String senha;
}
