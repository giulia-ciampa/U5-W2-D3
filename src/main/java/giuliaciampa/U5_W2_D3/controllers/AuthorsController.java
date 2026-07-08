package giuliaciampa.U5_W2_D3.controllers;

import giuliaciampa.U5_W2_D3.entities.Author;
import giuliaciampa.U5_W2_D3.payloads.AuthorPayload;
import giuliaciampa.U5_W2_D3.services.AuthorsService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorPayload saveAuthor(@RequestBody AuthorPayload payload) {
        Author saved = this.authorsService.saveAuthor(payload);

        return new AuthorPayload(saved.getNome(), saved.getCognome(), saved.getEmail(), saved.getDataDiNascita());


    }

    //GET --> GETALL

    @GetMapping
    public Page<Author> autoriTrovati(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "cognome") String orderBy) {
        return this.authorsService.getAll(page, size, orderBy);
    }

    //GET --> FIND BY ID
    @GetMapping("/{authorId}")
    public Author findByID(@PathVariable UUID authorId) {
        return this.authorsService.findById(authorId);
    }

    //PUT --> FIND BY ID AND UPDATE

    @PutMapping("/{authorId}")
    public Author findByIdAndUpdate(@PathVariable UUID authorId, @RequestBody AuthorPayload payload) {
        return this.authorsService.findByIdAndUpdate(authorId, payload);
    }

    //DELETE --> FIND BY ID AND DELETE
    @DeleteMapping("/{authorId}")
    public void findByIdAndDelete(@PathVariable UUID authorId) {
        this.authorsService.findByIdAndDelete(authorId);
    }

}
