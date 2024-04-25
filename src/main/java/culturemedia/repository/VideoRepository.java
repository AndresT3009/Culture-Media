package culturemedia.repository;

import culturemedia.model.Video;
import java.util.List;
import java.util.Optional;

public interface VideoRepository {
    List <Video> findAll();

    Video save (Video video);

    List <Video> find(String tittle);

    List <Video> find(Double fromDuration, Double toDuration);

}
