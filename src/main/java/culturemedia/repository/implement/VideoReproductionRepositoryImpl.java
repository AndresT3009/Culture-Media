package culturemedia.repository.implement;

import culturemedia.exceptions.VideoNotFoundException;
import culturemedia.model.VideoReproduction;
import culturemedia.repository.VideoReproductionRepository;

import java.util.ArrayList;
import java.util.List;

public class VideoReproductionRepositoryImpl implements VideoReproductionRepository {

    private final List<VideoReproduction> videoReproduction;

    public VideoReproductionRepositoryImpl() {
        this.videoReproduction = new ArrayList<>();
    }

    @Override
    public VideoReproduction save(VideoReproduction videoReproduction) {
        this.videoReproduction.add( videoReproduction );
        return videoReproduction;
    }

}
