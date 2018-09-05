public class PallindromePartitions {

  public static void main(String[] args) {
    System.out.println(pallindromicPartitions(0, 6));
  }

  public static int pallindromicPartitions(int left, int right) {
    if (left == right || left == right - 1) {
      return 1;
    }

    if (left > right) {
      return 0;
    }

    int currentPartitions = 1;

    for (; left <= right; left++, right--) {
      currentPartitions += pallindromicPartitions(left + 1, right - 1);
    }

    return currentPartitions;
  }
}
