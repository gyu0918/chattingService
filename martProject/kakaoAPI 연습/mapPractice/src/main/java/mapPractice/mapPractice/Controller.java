package mapPractice.mapPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Objects;

@RestController
public class Controller{
    private  KakaoMapsService kakaoMapsService;

    public Controller(KakaoMapsService kakaoMapsService) {
        this.kakaoMapsService = kakaoMapsService;
    }

    @GetMapping("/search/address")
    public Map<String, Object> searchAddress(@RequestParam String query){
        return kakaoMapsService.searchAddress(query);
    }
}













//@RestController
//public class Controller {
//    @Autowired
//    private Service service;
//
//    @GetMapping("/location")
//    public String getLocationInfo(@RequestParam double latitude, @RequestParam double longitude, @RequestParam(required = false, defaultValue = "json") String format){
//        return service.getDongInfo(latitude, longitude, format);
//    }
//}
