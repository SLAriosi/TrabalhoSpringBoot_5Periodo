package equipe.garotosdeprograma.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;

    @Past(message = "A data de nascimento deve ser anterior à data atual.")
    private LocalDate dataNascimento;
    private String telefone;
}