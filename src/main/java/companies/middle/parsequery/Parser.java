package companies.middle.parsequery;


import companies.middle.queries.Request;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public interface Parser {
    public void company(String cmp);
    public void key(String key);
    @SneakyThrows
    public Request ParseInfo();
}