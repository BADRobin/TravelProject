package dci.j24e01.TravelBlog.service;


import dci.j24e01.TravelBlog.models.Photo;
import dci.j24e01.TravelBlog.models.Route;
import dci.j24e01.TravelBlog.models.VacationPoint;
import dci.j24e01.TravelBlog.repositories.PhotoRepository;
import dci.j24e01.TravelBlog.repositories.RouteRepository;
import dci.j24e01.TravelBlog.repositories.VacationPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VacationService {

//    @Value("${file.upload-dir}")\


    @Autowired
    private VacationPointRepository vacationPointRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private RouteRepository routeRepository;

    public List<VacationPoint> getAllVacationPoints() {
        return vacationPointRepository.findAll();
    }

    public void saveVacationPoint(String title, String description, double latitude, double longitude, MultipartFile[] photos, String routeGeoJson)  {
        VacationPoint vacationPoint = new VacationPoint();


        vacationPoint.setTitle(title);
        vacationPoint.setDescription(description);
        vacationPoint.setLatitude(latitude);
        vacationPoint.setLongitude(longitude);
        vacationPoint.setApproved(false);


        VacationPoint savedPoint = vacationPointRepository.save(vacationPoint);

        if (photos != null) {
            List<Photo> photoList = new ArrayList<>();
            for (MultipartFile photo : photos) {
                try {
                    String extension = "";
                    int dotIndex = photo.getOriginalFilename().lastIndexOf(".");
                    if (dotIndex >= 0) {
                        extension = "." + photo.getOriginalFilename().substring(dotIndex + 1);
                    }
                    String filename = UUID.randomUUID() + extension;

                    Path appRoot = Path.of("").toAbsolutePath();
                    Path uploadsPath = appRoot.resolve("src/main/resources/static/photos");
                    Path destination = uploadsPath.resolve(filename);

                    Resource staticResource = new ClassPathResource("static");
                    Path targetUploadsPath = Path.of(staticResource.getURI()).resolve("photos");
                    Path targetDestination = targetUploadsPath.resolve(filename);

                    photo.transferTo(destination);
                    photo.transferTo(targetDestination);


                    Photo photoEntity = new Photo();
                    photoEntity.setPhotoPath(filename);
                    photoEntity.setVacationPoint(savedPoint);
                    photoList.add(photoEntity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            photoRepository.saveAll(photoList);
        }

        if (routeGeoJson != null && !routeGeoJson.isEmpty()) {
            Route route = new Route();
            route.setGeoJson(routeGeoJson);
            route.setVacationPoint(savedPoint);
            routeRepository.save(route);
        }
    }

    public void deleteVacationPoint(Long id) {
        vacationPointRepository.deleteById(id);
    }

    public void updateApprovalStatus(Long id, boolean approved) {
        VacationPoint vacationPoint = vacationPointRepository.findById(id).orElseThrow();
        vacationPoint.setApproved(approved);
        vacationPointRepository.save(vacationPoint);
    }

}
