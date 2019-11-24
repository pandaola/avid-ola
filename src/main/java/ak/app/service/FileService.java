package ak.app.service;

import ak.app.exception.NotFoundException;
import ak.app.model.db.MyFile;
import ak.app.model.db.MyFileWithPath;
import ak.app.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class FileService {

	private final FileRepository fileRepository;

	@Autowired
	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	public Map<String, MyFile> getAll() {
		List<MyFileWithPath> myFileWithPathList = fileRepository.findAll();
		return myFileWithPathList.stream()
				.collect(Collectors.toMap(MyFileWithPath::getPath, MyFileWithPath::getMyFile));
	}

}
