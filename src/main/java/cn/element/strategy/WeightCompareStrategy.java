package cn.element.strategy;

public class WeightCompareStrategy implements CompareStrategy<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {

        if (o1.getWeight() - o2.getWeight() < 0) {
            return -1;
        } else if (o1.getWeight() - o2.getWeight() > 0) {
            return 1;
        }

        return 0;
    }
}
