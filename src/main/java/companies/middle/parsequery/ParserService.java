package companies.middle.parsequery;

import org.springframework.stereotype.Service;
import companies.middle.queries.Request;

@Service
public class ParserService {
    private ParserRepository parserRepository;

    public ParserService(ParserRepository parserRepository) {
        this.parserRepository = parserRepository;
    }

    public String getParsedData(String url){
        return parserRepository.findByDomain(url).toString();
    }

    public void addParsedData(Request req){
        if (parserRepository.findByDomain(req.getDomain()).isEmpty()){
            parserRepository.save(req);
        }

    }
}
