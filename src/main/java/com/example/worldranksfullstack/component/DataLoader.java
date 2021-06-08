package com.example.worldranksfullstack.component;

import com.example.worldranksfullstack.db.service.CountryService;
import com.example.worldranksfullstack.feign.CountryClient;
import com.example.worldranksfullstack.feign.DataClient;
import com.example.worldranksfullstack.model.CountryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component/**/
public class DataLoader implements CommandLineRunner {
    private final DataClient dataClient;
    private final CountryClient countryClient;
    private final CountryService countryService;

    @Autowired
    public DataLoader(DataClient dataClient, CountryClient countryClient, CountryService countryService) {
        this.dataClient = dataClient;
        this.countryClient = countryClient;
        this.countryService = countryService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<CountryModel> all = countryClient.getAll();

        for (CountryModel countryModel : all) {

            countryService.save(countryModel);
            System.out.println("Working...");
           /* String s = countryModel.getAlpha3Code().toLowerCase(Locale.ROOT);

            byte[] download = dataClient.download(String.format("%s.svg", s));

            File saveFile = new File("src/main/resources/flags/" + s + ".svg");
            OutputStream outputStream = new FileOutputStream(saveFile);
            outputStream.write(download);

            outputStream.close();*/
        }



/*
        Response response = dataClient.download("afg.svg");
        Response.Body body = response.body();

        System.out.println(response.status());
        System.out.println(response.headers());

        InputStream inputStream = body.asInputStream();

        System.out.println(body.length());
        System.out.println(inputStream.available());
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);

        File saveFile = new File("src/main/resources/salom.svg");
        OutputStream outputStream = new FileOutputStream(saveFile);
        outputStream.write(buffer);

        outputStream.close();
        inputStream.close();
        System.out.println(saveFile.getAbsolutePath());*/
    }
}
