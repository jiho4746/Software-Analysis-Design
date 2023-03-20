package ch10.A4;

import java.lang.Comparable;
import java.util.Comparator;
//소팅 전략
public interface Sorter {
    public abstract void sort(Comparable[] data);
}
