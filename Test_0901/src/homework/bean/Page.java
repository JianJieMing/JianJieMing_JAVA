package homework.bean;

/**
 * @author 铭
 * DATE: 18/9/1 下午3:20
 */
public class Page {
    private int page;
    private int count;

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", count=" + count +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
