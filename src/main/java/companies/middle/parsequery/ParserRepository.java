package companies.middle.parsequery;

import companies.middle.queries.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParserRepository extends JpaRepository<Request, Integer> {
    List<Request> findByDomain(String domain);
}
