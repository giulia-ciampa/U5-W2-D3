package giuliaciampa.U5_W2_D3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "posts")
@NoArgsConstructor
public class Post {
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "posts_autori", // Nome della tabella di giunzione
            joinColumns = @JoinColumn(name = "post_id"), // Chiave esterna verso Post
            inverseJoinColumns = @JoinColumn(name = "autore_id") // Chiave esterna verso Author
    )
    List<Author> authors = new ArrayList<>();
    //ATTRIBUTI
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaPost categoriaPost;
    @Column(nullable = false)
    private String titolo;
    @Column(nullable = false)
    private String cover;
    @Column(nullable = false)
    private String contenuto;
    @Column(name = "tempo_di_lettura")
    private int tempoDiLettura;
    @Column(name = "data_ora_creazione")
    private LocalDateTime createdAt;

    //COSTRUTTORE
    public Post(CategoriaPost categoriaPost, String titolo, String contenuto, int tempoDiLettura) {
        Random random = new Random();
        this.categoriaPost = categoriaPost;
        this.titolo = titolo;
        this.cover = "https://picsum.photos/200/300";
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.createdAt = LocalDateTime.now();
    }
}
