import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public interface Finder<T> {
    // Find first matching element
    default T findOne(List<T> list, Predicate<T> condition) {
        for (T elem : list) {
            if (condition.test(elem)) {
                return elem;
            }
        }
        return null;
    }

    // Find all matching elements
    default List<T> findAll(List<T> list, Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T elem : list) {
            if (condition.test(elem)) {
                result.add(elem);
            }
        }
        return result;
    }

    // Find number of matching elements
    default long findNoOf(List<T> list, Predicate<T> condition) {
        long count = 0;
        for (T elem : list) {
            if (condition.test(elem)) {
                count++;
            }
        }
        return count;
    }

    // Find sum of a numeric property of matching elements
    default int findSumOf(List<T> list, Predicate<T> condition, ToIntFunction<T> mapper) {
        int sum = 0;
        for (T elem : list) {
            if (condition.test(elem)) {
                sum += mapper.applyAsInt(elem);
            }
        }
        return sum;
    }
}
