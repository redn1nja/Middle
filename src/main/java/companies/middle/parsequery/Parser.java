package companies.middle.parsequery;


import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Parser {
    private static String toParse;
    public Parser(String phrase){
        toParse = phrase;
    }
    @SneakyThrows
    public static String connection(){
        Document doc = Jsoup.parse(toParse);
        return null;
    }
    }