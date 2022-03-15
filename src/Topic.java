public final class Topic {

    private final long id;
    private final String description;
    private boolean done;

    public Topic(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }
}