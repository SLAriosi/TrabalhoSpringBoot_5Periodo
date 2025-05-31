package equipe.garotosdeprograma.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity

public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Paciente paciente;

    @FutureOrPresent(message = "Data e hora não podem ser no passado.")
    private LocalDateTime dataHora;


}