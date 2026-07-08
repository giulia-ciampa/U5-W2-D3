package giuliaciampa.U5_W2_D3.services;

import giuliaciampa.U5_W2_D3.entities.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsService {
    private List<Post> postDB = new ArrayList<>();

    //METODI

//    public Post findByIdAndUpdate(long postId, PostPayload payload) {
//        Post postTrovato = findSinglePost(postId);
//        postTrovato.setCategoriaPost(payload.getCategoriaPost());
//        postTrovato.setTitolo(payload.getTitolo());
//        postTrovato.setContenuto(payload.getContenuto());
//        postTrovato.setTempoDiLettura(payload.getTempoDiLettura());
//
//        return postTrovato;
//    }
//
//    public void findByIdAndDelete(long postId) {
//        Post postTrovato = findSinglePost(postId);
//        this.postDB.remove(postTrovato);
//    }
//
//    public List<Post> findAll() {
//        return this.postDB;
//    }
//
//    public Post findSinglePost(long postId) {
//        Post postTrovato = null;
//
//        for (Post post : postDB) //Per ogni oggetto di tipo Post (che decido di chiamare temporaneamente post) presente dentro la lista this.postDB
//        {
//            if (post.getId() == postId) {
//                postTrovato = post;
//            }
//        }
//
//        if (postTrovato == null) {
//            throw new NotFoundException("il post con id " + postId + " non è stato trovato");
//        }
//
//        return postTrovato;
//    }
//
//    public Post savePost(PostPayload payload) {
//        Post newPost = new Post(payload.getCategoriaPost(), payload.getTitolo(), payload.getContenuto(), payload.getTempoDiLettura());
//        this.postDB.add(newPost);
//        return newPost;
//    }

}
