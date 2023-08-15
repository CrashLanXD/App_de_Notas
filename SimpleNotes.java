public class SimpleNotes implements Note {
    private String title;
    private String content;

    public SimpleNotes(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println(title + ':');
        System.out.println('\t' + content);
    }
}
