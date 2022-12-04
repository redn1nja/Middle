package companies.middle.parsequery;

import companies.middle.queries.Request;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;


public class BFParser implements Parser{
    private String key;
    private String company;
    @Override
    public void company(String cmp) {
        this.company = cmp;
    }

    @Override
    public void key(String key) {
        this.key = key;
    }

    public BFParser(String ke, String compan){
        key(ke);
        company(compan);
    }

    @Override
    @SneakyThrows
    public Request ParseInfo() {
        String icon = null;
        String logo = null;
        String twitter = null;
        String facebook = null;
        String name = null;
        HttpResponse<String> response = Unirest.get("https://api.brandfetch.io/v2/brands/" + company)
                .header("Authorization", "Bearer ************************")
                .asString();
        JSONObject obj = new JSONObject(response.getBody());
        JSONArray logos = obj.getJSONArray("logos");
        JSONArray social = obj.getJSONArray("links");
        for (int i = 0; i < logos.length(); i++) {
            if(logos.getJSONObject(i).getString("type").equals("icon")){
                icon = logos.getJSONObject(i).getJSONArray("formats").getJSONObject(0).getString("src");
            }
            else if(logos.getJSONObject(i).getString("type").equals("logo")){
                logo = logos.getJSONObject(i).getJSONArray("formats").getJSONObject(0).getString("src");
            }
        }
        for (int i = 0; i < social.length(); i++) {
            if (logos.getJSONObject(i).getString("name").equals("twitter")) {
                twitter = logos.getJSONObject(i).getJSONArray("formats").getJSONObject(0).getString("src");
            }
            if (logos.getJSONObject(i).getString("name").equals("facebook")) {
                facebook = logos.getJSONObject(i).getJSONArray("formats").getJSONObject(0).getString("src");
            }
        }
        name = obj.getString("name");
        return Request.builder().icon(icon).twitter(twitter).domain(company).facebook(facebook).logo(logo).name(name).build();
    }
}
