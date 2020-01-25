package datastructures.frequencies.CountMinSketch;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountMinSketchTest {

  @Test
  public void testIncrementBasic() {
    CountMinSketch testCMS = new CountMinSketch();

    int testElem = 45;
    for (int i = 0; i < 100; i++) {
      testCMS.increment(testElem);
    }

    // With no other elements added, estimate should be exact
    assertEquals(100, testCMS.estimate(testElem));

  }
}
