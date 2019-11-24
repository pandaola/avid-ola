package ak.app.controller;

import ak.app.model.db.MyFile;
import ak.app.service.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/files", produces = MediaType.APPLICATION_JSON_VALUE)
public class FileController {

	private final FileService fileService;
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public FileController(FileService fileService) {
		this.fileService = fileService;
	}

	public static <T> T convertToView(Object model, Class<T> viewClass) {
		return objectMapper.convertValue(model, viewClass);
	}

	public static <T> List<T> convertToView(List<?> modelList, Class<T> viewClass) {
		List<T> views = new ArrayList<>();
		for (Object model : modelList) {
			T view = convertToView(model, viewClass);
			views.add(view);
		}
		return views;
	}

	@GetMapping
	public ResponseEntity<Map<String, MyFile>> getAll() {
		Map<String, MyFile> filesMap = fileService.getAll();
		return ResponseEntity
				.ok(filesMap);
	}

//	@GetMapping(value = "/{uuid}")
//	public ResponseEntity<MyFile> getOne(@PathVariable UUID uuid) {
//        MyFile myfile = fileService.getOne(uuid);
//        return ResponseEntity
//                .ok(convertToView(myfile, MyFile.class));
//	}
}
