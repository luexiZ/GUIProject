import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherNetworkingClient{
    private String APIkey;
    private String baseUrl;

    public WeatherNetworkingClient(){
        APIkey = "791ae537060d4435b1d135058221805";
        baseUrl = "http://api.weatherapi.com/v1/current.json?key=";
    }

    public Weather getWeather(int zipcode){
        String URL = baseUrl + APIkey + "&q=" + zipcode;
        String response = makeAPICall(URL);

        Weather weatherResults = parseWeatherJSON(response);
        return weatherResults;
    }

    private String makeAPICall(String url)
    {
        try {
            URI myUri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Weather parseWeatherJSON(String json){
        JSONObject jsonObj = new JSONObject(json);
        JSONObject current = jsonObj.getJSONObject("current");
        double tempC = current.getDouble("temp_c");
        double tempF = current.getDouble("temp_f");
        JSONObject innerCondition = current.getJSONObject("condition");
        String condition = innerCondition.getString("text");
        String icon = innerCondition.getString("icon");

        Weather weather = new Weather(tempF,tempC,condition,icon);
        return weather;

    }
}
