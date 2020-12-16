package nullpointers;

import java.util.HashMap;
import java.util.Map;

public class CountryFactory {

    private Map<String,Country> countries = new HashMap<>();
    private Country UNKNOWN = new Country("Unknown ","","Unknown");

    public CountryFactory(){
        countries.put("uk", new Country("United Kingdom","uk","London"));
        countries.put("fr", new Country("France","fr","Paris"));
        countries.put("es", new Country("Spain","es","Madrid"));
    }

    public Country findCountry(String prefix){
        Country foundCountry = countries.get(prefix);
        if(foundCountry == null){
            return UNKNOWN;
        }
        return foundCountry;
    }

    public class Country{

        private String name;
        private String prefix;
        private String capital;

        private Country(String name, String prefix, String capital){
            this.name = name;
            this.prefix = prefix;
            this.capital = capital;
        }

        public String name(){return name;}
        public String capital(){return capital;}

    }

    public static void main(String[] args){
        CountryFactory countryFactory = new CountryFactory();
        Country country = countryFactory.findCountry("it");
        System.out.println("Country name: "+ country.name() + " with capital "+country.capital());

        Country country2 = countryFactory.findCountry("es");
        System.out.println("Country name: "+ country2.name() + " with capital "+country.capital());
    }

}

