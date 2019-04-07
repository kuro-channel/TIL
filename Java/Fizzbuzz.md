## 問題文
1 から 100 までの数字を数えていき、  

3 の倍数なら Fizz  
5 の倍数なら Buzz  
3 の倍数かつ 5 の倍数なら FizzBuzz  
それ以外は、その数字を出力する。  

```
class FizzBuzz{
    public static void main(String[] args){
        int num = 100;
        for(int i = 1; i <= num; i++){
            if (i % 15 == 0) {
            /* if (i % 3 == 0 || i % 5 == 0) {*/
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
```
