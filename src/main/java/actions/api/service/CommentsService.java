package actions.api.service;

import actions.api.CommentsModel.CommentModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class CommentsService {

    private ArrayList<CommentModel> commentModelArrayList;
    private final String API_BASE_URL = "https://63a0714124d74f9fe8385cd2.mockapi.io/Comments";
    private RestTemplate restTemplate = new RestTemplate();

    public CommentsService() throws JsonProcessingException {
        generateCommentsFromApi();
    }

    public void generateCommentsFromApi() throws JsonProcessingException {
        commentModelArrayList = new ArrayList<>();
        ResponseEntity<String> response = restTemplate.getForEntity(API_BASE_URL, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());

        for (int i = 0; i < root.size(); i++) {
            JsonNode id = root.get(i).path("id");
            JsonNode comment = root.get(i).path("comment");
            commentModelArrayList.add(new CommentModel(id.asInt(), comment.asText()));
        }
    }

    public String[] getAllComments() {
        String[] commentList = new String[3];

        for (int i = 0; i < commentModelArrayList.size(); i++) {
            commentList[i] = commentModelArrayList.get(i).getComment();
        }
        return commentList;
    }
}
