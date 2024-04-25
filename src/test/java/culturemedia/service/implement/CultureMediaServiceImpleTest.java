package culturemedia.service.implement;

import culturemedia.exceptions.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.VideoReproductionRepository;
import culturemedia.repository.implement.VideoRepositoryImpl;
import culturemedia.repository.implement.VideoReproductionRepositoryImpl;
import culturemedia.services.CultureMediaService;
import culturemedia.services.implement.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CultureMediaServiceImpleTest {

    CultureMediaService cultureMediaService;
    VideoRepository videoRepository;
    VideoReproductionRepository videoReproductionRepository;

    @BeforeEach
    void init(){
        videoRepository = new VideoRepositoryImpl();
        videoReproductionRepository = new VideoReproductionRepositoryImpl();
        cultureMediaService = new CultureMediaServiceImpl(videoRepository,videoReproductionRepository);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        var video = new Video("01","Título 1","Pelicula",3.5);
        cultureMediaService.save( video );
        List<Video> videos = cultureMediaService.findAll( );
        assertEquals(1, videos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findAll();
        });
    }
    @Test
    void when_FindByTittle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find("Movie");
        });
    }

    @Test
    void when_FindByTittle_videos_should_be_returned_successfully() throws VideoNotFoundException {
        var video = new Video("01","Duna","Pelicula",3.5);
        cultureMediaService.save( video );
        List<Video> videos = cultureMediaService.find("Duna");
        assertEquals(1, videos.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find(1.5,2.0);
        });
    }

    @Test
    void when_FindByDuration_videos_should_be_returned_successfully() throws VideoNotFoundException {
        var video = new Video("01","Duna","Pelicula",3.5);
        cultureMediaService.save( video );
        List<Video> videos = cultureMediaService.find(2.5,3.5);
        assertEquals(1, videos.size());
    }
}
