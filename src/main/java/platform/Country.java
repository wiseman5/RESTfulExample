package platform;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 * Created by alisewiseman on 6/7/17.
 */
public class Country {
  private String country;
  private String capital;

  @Override
  public String toString() {
    return "<a href=\"http://localhost:8080/RESTfulExample/rest/hello/" + country + "/capital\">" + country + "</a>: " + capital;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public void capitalize() {
    country = country.replaceFirst(String.valueOf(country.charAt(0)), String.valueOf((char)(country.charAt(0) -32)));
    capital = capital.replaceFirst(String.valueOf(capital.charAt(0)), String.valueOf((char)(capital.charAt(0) -32)));
  }
}
