package com.example.demo.services;

import com.example.demo.model.Person;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpClientService {

    private Person person;

    public JSONObject getPerson() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://4solut.com.br/trabalho/MOCK_DATA.json");
        request.addHeader("accept", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        String json = IOUtils.toString(response.getEntity().getContent());

        return new JSONObject(json);
    }
}
