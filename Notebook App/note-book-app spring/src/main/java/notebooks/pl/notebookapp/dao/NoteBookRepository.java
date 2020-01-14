package notebooks.pl.notebookapp.dao;

import notebooks.pl.notebookapp.dao.entity.NoteBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteBookRepository extends CrudRepository<NoteBook,Long> {
}
