package ak.app;

import ak.app.model.db.*;
import ak.app.repository.FileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;


@SpringBootApplication
public class App {

	private static int SAMPLE_SIZE = 3;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

		//JsonParser csvParser = new JsonParser();
		//csvParser.readJSON("/Users/panda/Desktop/avid/src/main/java/ak/app/json/data.json");
	}

	@Bean
	CommandLineRunner initInMemoryDatabase(FileRepository fileRepository) {
		return (args) -> IntStream.range(0, SAMPLE_SIZE)
				.forEach(i -> {
					List<Asset> assets = new ArrayList<>();
					List<Attribute> attributes = new ArrayList<>();
					Attribute attribute = Attribute.builder()
							.group(String.format("group_%s", i))
							.name(String.format("name_%s", i))
							.value(String.format("value_%s", i))
							.build();
					attributes.add(attribute);
					Base base = Base.builder()
							.type(String.format("type_%s", i))
//							.id(String.format("id_%s", i))
							.build();
					List<MediaItem> mediaItemList = new ArrayList<>();
					mediaItemList.add(MediaItem.builder()
							.essenceType(String.format("essenceType_%s", i))
							.track(String.format("track_%s", i))
							.start(String.format("start_%s", i))
							.length(String.format("length_%s", i))
							.mobId(String.format("mob_id_%s", i))
							.online(String.format("online_%s", i))
							.type(String.format("type_%s", i))
							.build());
					Common common = Common.builder()
							.created(LocalDateTime.now())
							.created(LocalDateTime.now().plusHours(i))
							.name(String.format("name_%s", i))
							.build();

					Asset assetOne = Asset.builder()
							.attributes(attributes)
							.base(base)
							.mediaItems(mediaItemList)
							.common(common)
							.mobId(String.format("mobId_%s", i))
							.build();
					assets.add(assetOne);

					String path = String.format("path_%s_%s", i, UUID.randomUUID());
					MyFile myFile = MyFile.builder()
							.id(i)
							.assets(assets)
							.build();
					MyFileWithPath myFileWithPath = MyFileWithPath.builder()
							.path(path)
							.myFile(myFile)
							.build();
					fileRepository.save(myFileWithPath);
				});
	}

	private static File getFileFromResources(String fileName) {

		ClassLoader classLoader = App.class.getClassLoader();

		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found!");
		} else {
			return new File(resource.getFile());
		}

	}
}
