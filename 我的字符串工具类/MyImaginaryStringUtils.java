// 当我向我的朋友分享代码时，我的字符串工具类长这个样子：
class MyImaginaryStringUtils{
  /**
   * 判断字符串是否为null或者空字符串
   *
   * @param str 字符串
   * @return 当字符串为null或者空字符串时返回true，否则返回false
   */
  public static boolean isEmpty(String str) {
    return str == null || str.length() == 0;
  }
  
  /**
   * 判断是否存在任意null或者空的字符串
   *
   * @param strings 可变字符串参数
   * @return 当所有字符串都不为null或者空时返回true，否则返回false
   */
  public static boolean isAnyEmpty(String... strings) {
    for (String str : strings) if (isEmpty(str)) return true;
    return false;
  }
  
  /**
   * 从一个给定的字符串中查询子字符串出现的次数
   *
   * @param str 字符串
   * @param sub 需要查询的子字符串
   * @return 子字符串出现次数
   */
  public static int countStr(String str, String sub) {
    if (isAnyEmpty(str, sub)) return -1;
    int i = 0;
    for (; str.contains(sub); i++) str = str.substring(str.indexOf(sub) + sub.length());
    return i;
  }
  
  // 测试
  public static void main(String[] args) {
    System.out.println(isEmpty("Hello")); // false
    System.out.println(isEmpty(""));      // true
    System.out.println(isEmpty(null));    // true
  
    System.out.println(isAnyEmpty("a", "b", "c"));    // false
    System.out.println(isAnyEmpty("a", "", "c"));     // true
    System.out.println(isAnyEmpty(null, "a", "c"));   // true
  
    System.out.println(countStr("Hello, my name is San and my parents are from China.", "my"));  // 2
  }
}
