package site.metacodig.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Download {

    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/json; charset=UTF8")
    public @ResponseBody String download(String id) {
        StringBuilder sb = new StringBuilder();

        try {
            String uri = "http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst?serviceKey=406lrJVRiqLfSp8HVHaLUY%2Bo3a%2F1DtuHUz%2Fs9waJGTnvPuodbdMnS9eCCmMQFvRJUakGRGcnSaYJtm27C8IcjQ%3D%3D&pageNo=1&numOfRows=1&dataType=JSON&CURRENT_DATE=2019122010&HOUR=24&COURSE_ID="
                    + id;
            URL url = new URL(uri);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;

            while ((returnLine = br.readLine()) != null) {
                sb.append(returnLine);
            }
            urlConnection.disconnect();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "실패";
        }

    }

    @GetMapping("/")
    public String main() {
        return "main";
    }

}
