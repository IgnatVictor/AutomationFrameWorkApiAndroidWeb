package actions.api.commentsModel;

public class CommentModel {

    private int id;
    private String comment;

    public CommentModel(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public CommentModel(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
