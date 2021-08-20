import com.fasterxml.jackson.annotation.JsonProperty;

public class CatRec {
    private final String id;
    private final String fact;
    private final String type;
    private final String publisher;
    private final int upvotes;

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

    public int getUpvotes() {
        return upvotes;
    }
}
