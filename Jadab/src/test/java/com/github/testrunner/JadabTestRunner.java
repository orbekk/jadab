package com.github.testrunner;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import java.io.File;
import org.junit.runners.model.InitializationError;

public class JadabTestRunner extends RobolectricTestRunner {

    public final static String testProjectLocation = "src/test/resources/AndroidTest";

    public JadabTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass, new File(testProjectLocation));
    }
}