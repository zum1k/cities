import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.*;

public class Runner {
    private static final Gson gsontest = new GsonBuilder().create();


        public static void main(String[] args) {
            State state = createState();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(state);

            try (FileWriter writer = new FileWriter("jsontest.json", false)) {
                writer.write(json);

                writer.close();

            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }


            try {
                State object = gson.fromJson(new FileReader("jsontest.json"), State.class);
                String json2 = gson.toJson(object);
                System.out.println(json2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }





            public void switchMenu() {

            System.out.println("Choose method of inputiing date:");
            System.out.println("1 - input by randomaizer");
            System.out.println("2 - input by parsing JSON file");
            System.out.println("Please choose...");

            Scanner in = new Scanner(System.in);
            int chooser = in.nextInt();
            in.close();

            switch (chooser) {

                case 1: {
                   System.out.println("Ur choose is" + chooser);
                   createState();
                   break;
                }
                case 2: {
                    System.out.println("Ur choose is" + chooser);
                    jsonParser();
                    break;
                }
                default: {
                    System.out.println("Ur choose is DEFAULT;");
                    createState();
                    break;
                }
            }

        }

        public void keyboardInput() {

        }

        public static void jsonParser() {

        }

    public static City createCity() {
        final List<String> cityFirstPart = Arrays.asList("Yar", "Nov", "Svyato", "Min", "Podol", "Uz", "Vlad", "Star", "Yaro");
        final List<String> citySecondpart = Arrays.asList("grad", "sk", "gorod", "burg");
        Random random = new Random();
        City city = new City((cityFirstPart.get(random.nextInt(9))) + citySecondpart.get(random.nextInt(4)), 25000 + random.nextInt(624500));
        return city;
    }

    public static District createDistrict() {
        Random random = new Random();
        int randomInt = 3 + new Random().nextInt(3);
        int[] iterat = new int[randomInt];
        HashSet<City> cities = new HashSet<>();
        City bufferCity = new City("default", 100000);
        District district;
        for (int r : iterat) {
            City c = createCity();
            cities.add(c);
            bufferCity = c;
        }
        if (bufferCity.getName().contains("sk")) {
            return district = new District(bufferCity.getName() + "ii", 500 + random.nextInt(1900), cities);
        } else {
            return district = new District(bufferCity.getName() + "skii", 500 + random.nextInt(1900), cities);
        }

    }

    public static Region createRegion(){
            Random random = new Random();
            int iterR = 3 + random.nextInt(2);
            int[]iterat = new int[iterR];
            HashSet<District> districts = new HashSet<>();
            District buffer = createDistrict();
            Region region;
        for (int r: iterat ) {
            District d = createDistrict();
            districts.add(d);
            buffer = d;
        }
        if(buffer.getCity().getName().contains("sk")){
            return region = new Region(buffer.getCity().getName()+"aya", buffer.getCity(),districts);
        }
        else{
            return region = new Region(buffer.getCity().getName()+"skaya", buffer.getCity(),districts);
        }

    }

    public static State createState(){
            Random random = new Random();
            int randomInt = 3 + random.nextInt(3);
           List<String> firstMorfemStateList = Arrays.asList("Bela", "Grey", "White");
           List<String> secondMorfemStateList = Arrays.asList("rus", "stan");
           HashSet<Region> regions = new HashSet<>();
           Region buffer = createRegion();
           int[]iterat = new int[randomInt];
        for (int i: iterat ) {
            Region r = createRegion();
            regions.add(r);
            buffer = r;
        }
        String nameState = firstMorfemStateList.get(random.nextInt(3))+secondMorfemStateList.get(random.nextInt(2));
        return new State(nameState, buffer.getCapital(),regions);

    }

    public static State randomaizer() {
        final List<String> regionNameP1 = Arrays.asList("aya", "skaya");
        final List<String> cityFirstPart = Arrays.asList("Yar", "Nov", "Svyato", "Min", "Podol", "Uz", "Vlad", "Star", "Yaro");
        final List<String> citySecondpart = Arrays.asList("grad", "sk", "gorod", "burg");
        final List<String> distrcitConstructor = Arrays.asList("skii", "ii");

        Random random = new Random();
        HashSet<City> cities = new HashSet<City>(36);
        HashSet<District> districts = new HashSet<District>(9);
        HashSet<Region> regions = new HashSet<Region>(3);


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                City city = new City((cityFirstPart.get(i)) +
                        citySecondpart.get(j), 25000 + random.nextInt(624500));
                cities.add(city);
            }

        }


        for (int i = 0; i < 9; i++) {
            Iterator<City> iterat = cities.iterator();
            String name = "Default";
            HashSet<City> districtCities = new HashSet<City>(4);
            while (iterat.hasNext()) {
                districtCities.add(iterat.next());
                name = iterat.next().getName();
            }

            if (name.matches("sk")) {
                District district = new District(name + "ii", 500 + random.nextInt(1900), districtCities);
                districts.add(district);

            } else {
                District district = new District(name + "skii", 500 + random.nextInt(1900), districtCities);
                districts.add(district);
            }

        }

        for(int i =0; i<3;i++){
            Iterator<District> iterat = districts.iterator();
            String name = "Default";
            HashSet<District> regionDistricts = new HashSet<District>(3);
            while (iterat.hasNext()){
                regionDistricts.add(iterat.next());
                name =iterat.next().getDistrictName();
            }
            if (name.matches("skii")){
                Region region = new Region(name.replace("skii", "skaya"), iterat.next().getCity(), regionDistricts);
                regions.add(region);

            }
            else {
                Region region = new Region(name.replace("ii", "aya"), iterat.next().getCity(), regionDistricts);
                regions.add(region);

            }
        }
        Iterator<Region> iterat = regions.iterator();
        State state = new State("Belarus",iterat.next().getCapital(),regions);

        return state;
    }

    }


