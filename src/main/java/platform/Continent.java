package platform;

import java.util.List;

/**
 * Created by alisewiseman on 6/7/17.
 */
public class Continent {
  private String name;
  private List<Country> countries;

  public boolean hasCountry(String countryName) {
    for (Country country: countries) {
      if (country.getCountry().toLowerCase().equals(countryName)) {
        return true;
      }
    }
    return false;
  }

  public String getCapital(String countryName) {
    for (Country country: countries) {
      if (country.getCountry().toLowerCase().equals(countryName)) {
        return country.getCapital();
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return countries.toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Country> getCountries() {
    return countries;
  }

  public void setCountries(List<Country> countries) {
    this.countries = countries;
  }

  public void capitalize() {
    for (Country country: countries) {
      country.capitalize();
    }
  }
}
