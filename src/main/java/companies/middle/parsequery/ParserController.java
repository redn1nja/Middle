package companies.middle.parsequery;

import companies.middle.queries.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/company")
public class ParserController {
    private ParserService parserService;
    @Autowired
    public ParserController(ParserService parserService) {
        this.parserService = parserService;
    }

    @GetMapping
    public String getSiteInfo(String request){
        return parserService.getParsedData(request);
    }
    @PostMapping
    public void addSiteInfo(@RequestBody Request request){
        parserService.addParsedData(request);
    }
}
