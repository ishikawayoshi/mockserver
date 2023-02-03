package com.ishikawa.mockserver.services;

import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.HarReaderException;
import de.sstoehr.harreader.model.Har;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URI;

@Service
public class HarReaderService {

    public void simple_test() {
        System.out.println("Test");
    }

    public String readHar() throws HarReaderException {
        File file = new File("./hars/stackoverflow.com.har");
        HarReader harReader = new HarReader();
        Har har = harReader.readFromFile(file);
        System.out.println(har.getLog().getCreator().getName());
        String urlOrigin = "stackoverflow.com";
        har.getLog().getEntries().stream()
//                .filter(harEntry -> harEntry.getRequest().getUrl().contains(urlOrigin))
                .forEach(harEntry -> {
                    String url = harEntry.getRequest().getUrl();
                    URI uri = URI.create(url);
                    String name = harEntry.getRequest().getMethod().name();
                    String mimeType = harEntry.getResponse().getContent().getMimeType();
                    System.out.println(url + " " + name + " " + mimeType);
                    System.out.println(uri.getHost());
                    System.out.println(uri.getPath());
                });

        return "";
    }

}
