package cn.element.memento.draft;

/**
 * 备忘录角色类
 */
public class ArticleMemento {

    private final String title;
    private final String content;
    private final String images;

    public ArticleMemento(String title, String content, String images) {
        this.title = title;
        this.content = content;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "ArticleMemento{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}
