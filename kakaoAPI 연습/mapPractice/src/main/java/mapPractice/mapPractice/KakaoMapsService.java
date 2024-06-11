package mapPractice.mapPractice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.Map;

@Service
public class KakaoMapsService {
    @Value("${kakao.rest.api.key}")
    private String restApiKey;

    private  RestTemplate restTemplate;
    public KakaoMapsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> searchAddress(String query) {
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "KakaoAK " + restApiKey);

        String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + query;
        return restTemplate.getForObject(url, Map.class);
    }
}

//@Service
//@RequiredArgsConstructor
//public class KakaoMapsService{
//    @Value("${kakao.rest.api.key}")
//    private String restApiKey;
//
//    private final RestTemplate restTemplate;
//
//
//    public Map<String, Object> searchAddress(String query){
//        HttpHeaders headers = new org.springframework.http.HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        headers.set("Authorization", "KakaoAK " + restApiKey);
//
//        String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + query;
//        return restTemplate.getForObject(url, Map.class);
//    }
//
//}



















//@org.springframework.stereotype.Service
//public class Service {
//    @Autowired
//    private RestTemplate restTemplate;
//    //API 키
//    private final String apiKey = "b97cb92610acfa6862b281d12658b0fc";
//
//    public String getDongInfo(double latitude, double longitude, String format){
//        //API 요청 URL 설정
//        String apiUrl = "https://api.example.com/location?lat=" + latitude + "&lng=" + longitude + "&format=" + format;
//
//        //API 요청 헤더 설정
//         HttpHeaders headers = new org.springframework.http.HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//         headers.set("X-Api-Key", apiKey);
//
//         //API 요청 및 응답 처리
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
//        if (response.getStatusCode() == HttpStatus.OK){
//            return response.getBody();
//        }else {
//            return "Failed to fetch location information";
//        }
//    }
//}
