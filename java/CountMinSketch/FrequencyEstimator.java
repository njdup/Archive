package njdup.CountMinSketch;

public interface FrequencyEstimator {

  public void increment(int element);

  public int estimate(int element);
}
