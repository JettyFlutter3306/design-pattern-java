package cn.element.strategy;

public class HeightCompareStrategy implements CompareStrategy<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {

        if (o1.getHeight() - o2.getHeight() < 0) {
            return -1;
        } else if (o1.getHeight() - o2.getHeight() > 0) {
            return 1;
        }

        return 0;
    }
}
