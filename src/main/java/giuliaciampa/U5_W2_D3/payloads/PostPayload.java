package giuliaciampa.U5_W2_D3.payloads;

import giuliaciampa.U5_W2_D3.entities.CategoriaPost;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostPayload {
    //ATTRIBUTI
    private CategoriaPost categoriaPost;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
}
