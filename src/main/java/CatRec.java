import com.fasterxml.jackson.annotation.JsonProperty;

public class CatRec {
    private String id;
    private String fact;
    private String type;
    private String publisher;
    private int upvotes;

    public CatRec(
            @JsonProperty("id") String id,
            @JsonProperty("text") String fact,
            @JsonProperty("type") String type,
            @JsonProperty("user") String publisher,
            @JsonProperty("upvotes") int upvotes) {
        this.id = id;
        this.fact = fact;
        this.type = type;
        this.publisher = publisher;
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return ("Факт <%s> из категории <%s>%n" +
                "от пользователя '%s':%n" +
                "%s%n" +
                "(голосов: %d)%n")
                .formatted(id, type, publisher, fact, upvotes);
    }

    public String getId() {
        return id;
    }

    public String getFact() {
        return fact;
    }

    public String getType() {
        return type;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getUpvotes() {
        return upvotes;
    }
}
