package org.metabuild.poc;

import org.junit.runner.RunWith;
import org.metabuild.poc.config.DataTestConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("integration-test")
@ContextConfiguration(classes={ DataTestConfig.class })
public class AbstractDataTester {

}
