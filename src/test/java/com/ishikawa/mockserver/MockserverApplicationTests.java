package com.ishikawa.mockserver;

import com.ishikawa.mockserver.configuration.MockServerConfiguration;
import com.ishikawa.mockserver.services.HarReaderService;
import de.sstoehr.harreader.HarReaderException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MockServerConfiguration.class})
class MockserverApplicationTests {

	@Autowired
	private HarReaderService harReaderService;

	@Test
	void contextLoads() throws HarReaderException {
		this.harReaderService.simple_test();
		this.harReaderService.readHar();
	}

}
