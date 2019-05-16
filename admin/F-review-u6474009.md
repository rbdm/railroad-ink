Reviewer: Mirhady Dorodjatun (u6474009)
Component: <IOUtil.java>
Author: Zhehao Chang (u6613739)

Review Comments:

1. IOUtil.java : it is a Util class about reading and writing player High Score. This code was just written last night but it already works as intended so that’s really good.

2. IOUtil.java : Later on, separating score code and read/write code might be better. For example, create 2 separate method 'void write(String s)' and 'String read()' to operate the IO, and the other method can focus on managing the scores.

3. IOUtil.java : Maybe we can add some comments on the tricky parts, to better follow code conventions and improve readability.

4. IOUtil.java 101-108: If the bestScore.txt has been changed incorrectly, it will report error (NullPointerException) and miss the correct record. We can make the initial string as empty string instead of null to avoid this.

5. IOUtil.java 70: There is a better way to write the IO than making the List<Class> to a txt, for example we can use Gson() to make it in a .JSON format.
