package culturemedia.repository;

import culturemedia.model.Video;
import java.util.List;
import java.util.Optional;

public interface VideoRepository {
    List <Video> findAll();

    Video save (Video video);

    List <Video> findByTittle(String tittle);

    List <Video> findByDuration(Double fromDuration, Double toDuration);

}
