package constraintBench.test.primTypes;

import constraintBench.utils.Configuration;

/**
 * 
 * @author Linghui Luo
 */
public class DoubleSingle1 {

  public void test() {
    double k = Configuration.featureK();
    if (k < 2.5) {
      System.out.println();
    }
  }

}
