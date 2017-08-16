package platform;

import java.util.List;

/**
 * Created by alisewiseman on 6/7/17.
 */
public class WorldGeography {
  private List<Continent> continents;

  public String getCapital(String country) {
    for (Continent continent: continents) {
      if (continent.hasCountry(country)) {
        return continent.getCapital(country);
      }
    }
    return null;
  }

  public String getContinent(String country) {
    for (Continent continent: continents) {
      if (continent.hasCountry(country)) {
        return continent.getName();
      }
    }
    return null;
  }

  public String getCountries(String continentName) {
    for (Continent continent: continents) {
      if (continent.getName().toLowerCase().equals(continentName)) {
        return continent.getCountries().toString();
      }
    }
    return null;
  }

  public List<Continent> getContinents() {
    return continents;
  }

  public void setContinents(List<Continent> continents) {
    this.continents = continents;
  }

  public void capitalize() {
    for (Continent continent: continents) {
      continent.capitalize();
    }
  }
}
