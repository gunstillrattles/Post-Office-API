package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.feign.ClientFeign;
import kz.dar.academy.backend.feign.PostFeign;
import kz.dar.academy.backend.model.ClientModel;
import kz.dar.academy.backend.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post-office")
public class PostOfficeController {
    @Autowired
    Environment env;

    @Autowired
    private PostFeign postFeign;

    @Autowired
    private ClientFeign clientFeign;

    @GetMapping("/check")
    public String checkPostOffice() {
        return "post-office-api is working at " + env.getProperty("local.server.port");
    }

    @GetMapping("/post/check")
    public String checkPost() {
        return "post-core-api is working at " + env.getProperty("local.server.port");
    }

    @GetMapping("/post/all")
    public List<PostModel> getAllPosts() {
        return postFeign.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postFeign.getPostById(postId);
    }

    @GetMapping("/client/check")
    public String checkClient() {
        return "client-core-api is working at " + env.getProperty("local.server.port");
    }

    @GetMapping("/client/all")
    public List<ClientModel> getAllClients() {
        return clientFeign.getAllClients();
    }

    @GetMapping("/client/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId) {
        return clientFeign.getClientById(clientId);
    }

    @GetMapping("/post/details")
    public PostModel getPostDetails(@PathVariable String postId) {
        return postFeign.getPostById(postId);
    }
}