package actions.api.user;

public class CommentsApi {

    public String[] getAllComments(String[] listOfAllCommentsFromService) {
        String[] listOfComments = new String[3];

        for (int i = 0; i < listOfAllCommentsFromService.length; i++) {
            listOfComments[i] = listOfAllCommentsFromService[i];
        }
        return listOfComments;
    }
}
