package giuliaciampa.U5_W2_D3.services;

import giuliaciampa.U5_W2_D3.entities.Author;
import giuliaciampa.U5_W2_D3.exceptions.BadRequestException;
import giuliaciampa.U5_W2_D3.exceptions.NotFoundException;
import giuliaciampa.U5_W2_D3.payloads.AuthorPayload;
import giuliaciampa.U5_W2_D3.repositories.AuthorsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorsService {
    private final AuthorsRepository authorsRepository;

    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;

    }

    //METODI

    //1. metodo salva
    public Author saveAuthor(AuthorPayload payload) {
        Author autoreCreato = new Author(payload.getNome(), payload.getCognome(), payload.getEmail(), payload.getDataDiNascita());
        if (this.authorsRepository.existsByEmail(payload.getEmail())) {
            throw new BadRequestException("l'email inserita esiste già");
        }
        Author authorSaved = this.authorsRepository.save(autoreCreato);

        return authorSaved;
    }

    //2. metodo get all

    public Page<Author> getAll(int page, int size, String orderBy) {
        if (size > 50) size = 50;
        if (size < 0) size = 10;
        if (page < 0) page = 0;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return this.authorsRepository.findAll(pageable);
    }

    //3. metodo find by id

    public Author findById(UUID authorId) {
        return this.authorsRepository.findById(authorId).orElseThrow(() -> new NotFoundException("l'utente con id" + authorId + "non è stato trovato"));
    }

    //4. metodo findbyidAndUpdate

    public Author findByIdAndUpdate(UUID authorId, AuthorPayload payload) {
        Author autoreTrovato = findById(authorId);
        //La vecchia email memorizzata nel DB è DIVERSA dalla nuova email che l'utente ha scritto nel payloa
        if (!autoreTrovato.getEmail().equals(payload.getEmail()))
            //controllo nel DB se esiste già l'email del payload
            if (this.authorsRepository.existsByEmail(payload.getEmail()))
                throw new BadRequestException("l'email inserita" + payload.getEmail() + "esiste già");

        autoreTrovato.setNome(payload.getNome());
        autoreTrovato.setCognome(payload.getCognome());
        autoreTrovato.setEmail(payload.getEmail());
        autoreTrovato.setDataDiNascita(payload.getDataDiNascita());

        Author autoreAggiornato = this.authorsRepository.save(autoreTrovato);
        return autoreAggiornato;
    }

    //5. metodo findByIdAndDelete

    public void findByIdAndDelete(UUID authorId) {
        Author autoreTrovato = findById(authorId);
        this.authorsRepository.delete(autoreTrovato);
    }


}
