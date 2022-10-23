package kz.dar.academy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {
    private String postId;
    private ClientModel client;
    private ClientModel receiver;
    private String postItem;
    private String status;
}