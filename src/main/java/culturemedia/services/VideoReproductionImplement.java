package culturemedia.services;

import culturemedia.exceptions.VideoNotFoundException;
import culturemedia.model.VideoReproduction;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.VideoReproductionRepository;

public class VideoReproductionImplement {

    private VideoReproductionRepository videoReproductionRepository;

    public VideoReproduction save (VideoReproduction videoReproduction) throws VideoNotFoundException{
        try {
            VideoReproduction savedReproduction = videoReproductionRepository.save(videoReproduction);
            if (savedReproduction == null){
                throw new VideoNotFoundException("Error saving Video");
            }
            return savedReproduction;
        } catch (Exception e) {
            throw new VideoNotFoundException("Error saving Video" + e);
        }
    }


}
