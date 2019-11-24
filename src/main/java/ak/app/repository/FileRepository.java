package ak.app.repository;

import ak.app.model.db.MyFile;
import ak.app.model.db.MyFileWithPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FileRepository extends JpaRepository<MyFileWithPath, UUID> {

    List<MyFileWithPath> findAll();

    MyFileWithPath findByUuid(UUID uuid);

}
