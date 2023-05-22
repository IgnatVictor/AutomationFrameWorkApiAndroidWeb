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

    public ArrayList<String[]> getAllComments() {
        int id= 0;
        int comment =1;

        ArrayList<String[]> commentList =  new ArrayList<>();

        for(CommentModel commentModel:commentModelArrayList ){
            String[] commentDetails =  new String[2];

            commentDetails[id] = String.valueOf(commentModel.getId());
            commentDetails[comment] = String.valueOf(commentModel.getComment());

            commentList.add(commentDetails);
        }

        return  commentList;
    }




}
