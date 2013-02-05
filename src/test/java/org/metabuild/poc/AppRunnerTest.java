package org.metabuild.poc;

import org.junit.Test;

/**
 * @author: jburbrid
 * @since: 2/4/13
 */
public class AppRunnerTest {

    @Test
    public void testRun() {
        AppRunner runner = new AppRunner();
        runner.printPersons();
        runner.printGroups();
        runner.printPersonsDetailsJavaConfig();
    }
}
