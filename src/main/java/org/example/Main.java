package org.example;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{


    }

    private static void gsonWithHttpClient() throws URISyntaxException, IOException, InterruptedException {
        String url="https://cbu.uz/uz/arkhiv-kursov-valyut/json/";

        HttpClient client=HttpClient.newBuilder().build();
        HttpRequest request= HttpRequest
                .newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("send.statusCode() = " + send.statusCode());
        String currencies = send.body();
        Type type=TypeToken.getParameterized(List.class,Currency.class).getType();

        Gson gson=new Gson();
        List<Currency> resp= gson.fromJson(currencies, type);

        resp.forEach(System.out::println);
    }

    private static void exmaplke() throws IOException {
        Gson gson= new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        Joke joke = gson.fromJson(Files.readString(Path.of("joke.json")), Joke.class);

        System.out.println(joke);

        String jokeStr = gson.toJson(joke);

        Files.writeString(Path.of("newJoke.json"),jokeStr);
    }

    private static void writeToJson() throws IOException {
        User user=new User();
        user.setAge(26);
        user.setBalance(1000D);
        user.setBlood(4);
        user.setFirstName("Utkirbek");


        List<User> users=new ArrayList<>();
        users.add(user);
        users.add(user);
        users.add(user);

        Gson gson=new Gson();

        String json = gson.toJson(users);


        Files.writeString(Path.of("utkirbek.json"),json);

        System.out.println(json);
    }

    private static void readFromJson() throws IOException {
        String usd= Files.readString(Path.of("currencies.txt"));

        Gson gson=new Gson();
//        Currency currency = gson.fromJson(usd, Currency.class);

        Type type = TypeToken.getParameterized(ArrayList.class, Currency.class).getType();

        List<Currency> crs= gson.fromJson(usd, type);
    }

    private static void lombok() {
        User user=new User();
        user.setFirstName("test");
        user.setLastName("test1");
        System.out.println(user);
    }

    private static void fakerExamnple() {
        //        Faker faker=new Faker();
//        Faker faker=new Faker(new Random(13));
        Faker faker=new Faker(new Locale("ru"));

        Address address = faker.address();
//        System.out.println(address.country());
//
        System.out.println(address.state());

//
//        for (int i=0; i<100; i++) {
//            System.out.println(faker.chuckNorris().fact());
//        }

//        for (int i=0; i<50; i++) {
//            System.out.println(faker.programmingLanguage().name());
//        }
    }
}