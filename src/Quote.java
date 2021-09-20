public class Quote { // class declaration

    int quoteIndex;
    String quoteContent;
    String quoteAuthor;

    // getters
    public int getIndex() {
        return quoteIndex;
    }

    public String getContent() {
        return quoteContent;
    }

    public String getAuthor() {
        return quoteAuthor;
    }


    // setters
    public void setIndex(int index) {
        quoteIndex = index;
    }

    public void setContent(String content) {
        quoteContent = content;
    }

    public void setAuthor(String author) {
        quoteAuthor = author;
    }

    // constructors (i dont know what to do with these yet)
    public Quote() {
    }

    public Quote(int index) {
        this.setIndex(index);
    }

    public Quote(String content) {
        this.setContent(content);
    }

    public Quote(int index, String content, String author) {
        this.setIndex(index);
        this.setContent(content);
        this.setAuthor(author);
    }
}
