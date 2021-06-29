package com.example.worldranksfullstack.db.service;

import com.example.worldranksfullstack.db.entity.*;
import com.example.worldranksfullstack.db.repository.*;
import com.example.worldranksfullstack.feign.DataClient;
import com.example.worldranksfullstack.model.CountryModel;
import com.example.worldranksfullstack.payload.ApiResponseModel;
import com.example.worldranksfullstack.payload.ResCountry;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryService implements CountryServiceInterface {

    private final CurrenciesItemRepository currenciesItemRepository;
    private final FlagRepository flagRepository;
    private final LanguagesItemRepository languagesItemRepository;
    private final RegionalBlocsItemRepository regionalBlocsItemRepository;
    private final TranslationsRepository translationsRepository;
    private final DataClient dataClient;
    private final AttachmentContentRepository attachmentContentRepository;
    private final AttachmentRepository attachmentRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CurrenciesItemRepository currenciesItemRepository, FlagRepository flagRepository, LanguagesItemRepository languagesItemRepository, RegionalBlocsItemRepository regionalBlocsItemRepository, TranslationsRepository translationsRepository, DataClient dataClient, AttachmentContentRepository attachmentContentRepository, AttachmentRepository attachmentRepository, CountryRepository countryRepository) {
        this.currenciesItemRepository = currenciesItemRepository;
        this.flagRepository = flagRepository;
        this.languagesItemRepository = languagesItemRepository;
        this.regionalBlocsItemRepository = regionalBlocsItemRepository;
        this.translationsRepository = translationsRepository;
        this.dataClient = dataClient;
        this.attachmentContentRepository = attachmentContentRepository;
        this.attachmentRepository = attachmentRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(CountryModel countryModel) {
        Country country = createCountry(countryModel);

        return countryRepository.save(country);
    }

    private Flag downloadFlag(String alpha3Code) {
        byte[] bytes = dataClient.download(alpha3Code.toLowerCase() + ".svg");

        Attachment attachment = new Attachment();
        attachment.setName(alpha3Code);
        attachment.setExtension("image/svg+xml");
        attachment.setSize((long) bytes.length);

        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(new String(bytes));
        attachmentContent = attachmentContentRepository.save(attachmentContent);

        attachment.setAttachmentContent(attachmentContent);
        attachment = attachmentRepository.save(attachment);

        Flag flag = new Flag();
        flag.setAttachment(attachment);

        return flagRepository.save(flag);
    }

    @Override
    public Country update(Country country) {
        return null;
    }

    @Override
    public void delete(Country country) {

    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public HttpEntity<?> getById(String alpha3Code) {
        Optional<Country> country = countryRepository.findByAlpha3Code(alpha3Code);

        if (country.isPresent()) {
            return ResponseEntity.ok(
                    new ApiResponseModel(
                            true,
                            "Found",
                            new ResCountry(country.get())));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    private Country createCountry(CountryModel countryModel) {
        Country country = new Country();

        Optional<Country> byAlpha3Code = countryRepository.findByAlpha3Code(countryModel.getAlpha3Code());

        country.setAlpha2Code(countryModel.getAlpha2Code());
        country.setAlpha3Code(countryModel.getAlpha3Code());
        country.setAltSpellings(countryModel.getAltSpellings());
        country.setArea(countryModel.getArea());
        country.setBorders(countryModel.getBorders());
        country.setCallingCodes(countryModel.getCallingCodes());
        country.setCapital(countryModel.getCapital());
        country.setCioc(countryModel.getCioc());
        country.setDemonym(countryModel.getDemonym());
        country.setGini(countryModel.getGini());
        country.setLatLang(countryModel.getLatlng());
        country.setName(countryModel.getName());
        country.setCapital(countryModel.getCapital());
        country.setNativeName(countryModel.getNativeName());
        country.setNumericCode(countryModel.getNumericCode());
        country.setNumericCode(countryModel.getNativeName());
        country.setRegion(countryModel.getRegion());
        country.setTimezones(countryModel.getTimezones());
        country.setSubregion(countryModel.getSubregion());
        country.setPopulation(countryModel.getPopulation());

        if (byAlpha3Code.isPresent()) {
            country.setId(byAlpha3Code.get().getId());
        }

        country = countryRepository.save(country);

        if (country.getFlag() == null)
            country.setFlag(downloadFlag(countryModel.getAlpha3Code()));

        if (country.getLanguages() == null)
            country.setLanguages(
                    countryModel
                            .getLanguages()
                            .stream().map(
                            model -> {
                                LanguagesItem languagesItem = new LanguagesItem(model);
                                return languagesItemRepository.save(languagesItem);
                            }
                    ).collect(Collectors.toList())
            );
        if (country.getCurrencies() == null)
            country.setCurrencies(
                    countryModel
                            .getCurrencies()
                            .stream().map(
                            model -> {
                                CurrenciesItem currenciesItem = new CurrenciesItem(model);
                                return currenciesItemRepository.save(currenciesItem);
                            })
                            .collect(Collectors.toList()));


        if (country.getRegionalBlocs() == null)
            country.setRegionalBlocs(
                    countryModel
                            .getRegionalBlocs()
                            .stream().map(
                            model -> {
                                RegionalBlocsItem regionalBlocsItem = new RegionalBlocsItem(model);
                                return regionalBlocsItemRepository.save(regionalBlocsItem);
                            })
                            .collect(Collectors.toList()));

        if (country.getTranslations() == null)
            if (countryModel.getTranslations() != null) {
                country.setTranslations(
                        translationsRepository
                                .save(new Translations(countryModel.getTranslations())));
            }


        return country;
    }
}