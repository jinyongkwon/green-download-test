package site.metacodig.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void api_요청() {
        StringBuilder sb = new StringBuilder();

        try {
            String uri = "http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst?serviceKey=406lrJVRiqLfSp8HVHaLUY%2Bo3a%2F1DtuHUz%2Fs9waJGTnvPuodbdMnS9eCCmMQFvRJUakGRGcnSaYJtm27C8IcjQ%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&CURRENT_DATE=2019122010&HOUR=24&COURSE_ID=1";
            URL url = new URL(uri);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;

            while ((returnLine = br.readLine()) != null) {
                sb.append(returnLine);
            }
            urlConnection.disconnect();

            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}