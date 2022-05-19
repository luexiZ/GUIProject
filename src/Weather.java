public class Weather{
    private double tempF;
    private double tempC;
    private String condition;
    private String UrlIcon;

    public Weather(double tempF, double tempC, String condition, String UrlIcon ) {
        this.tempF = tempF;
        this.tempC = tempC;
        this.condition = condition;
        this.UrlIcon = UrlIcon;

    }

        public double getTempC() {
            return tempC;
        }

        public double getTempF() {
            return tempF;
        }
        public String getCondition() {
            return condition;
        }

        public String getIcon() {
            return UrlIcon;
        }

}