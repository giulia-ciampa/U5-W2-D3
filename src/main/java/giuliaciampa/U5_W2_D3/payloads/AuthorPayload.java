package giuliaciampa.U5_W2_D3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@ToString
@AllArgsConstructor
public class AuthorPayload {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
}
