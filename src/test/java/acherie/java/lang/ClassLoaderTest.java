package acherie.java.lang;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p>User: wangjie
 * <p>Date: 1/11/2017
 */
public class ClassLoaderTest {

    @Test
    public void classloaderForObject() {
        Object.class.getResourceAsStream("");
        ClassLoader classLoader = Object.class.getClassLoader();
        assertNull(classLoader);
    }

}
