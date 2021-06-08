package com.example.worldranksfullstack.feign;

import feign.FeignException;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.form.spring.converter.SpringManyMultipartFilesReader;
import okhttp3.OkHttpClient;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@FeignClient(value = "dataClient", url = "https://restcountries.eu/data", configuration = DataClient.ClientConfiguration.class)
public interface DataClient {
    @GetMapping("{img}")
    byte[] download(@PathVariable("img") String img);


    class ClientConfiguration {

        @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;

        @Bean
        public OkHttpClient client() {
            return new OkHttpClient();
        }

       /* @Bean
        public Decoder feignDecoder() {
            List<HttpMessageConverter<?>> springConverters =
                    messageConverters.getObject().getConverters();

            List<HttpMessageConverter<?>> decoderConverters =
                    new ArrayList<>(springConverters.size() + 1);

            decoderConverters.addAll(springConverters);

            decoderConverters.add(new SpringManyMultipartFilesReader(4096));

            HttpMessageConverters httpMessageConverters = new HttpMessageConverters(decoderConverters);
            return new Decoder() {
                @Override
                public Object decode(Response response, Type type) throws DecodeException, FeignException {
                    System.out.println(response);
                    return httpMessageConverters;
                }
            };
        }*/
    }
}


