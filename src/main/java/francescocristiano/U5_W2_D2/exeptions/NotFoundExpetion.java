package francescocristiano.U5_W2_D2.exeptions;

public class NotFoundExpetion extends RuntimeException {

    public NotFoundExpetion(int blogPostId) {
        super("BlogPost with id " + blogPostId + " not found");
    }
}
