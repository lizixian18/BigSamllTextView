# BigSmallTextView

设置大小字体的View  

效果图：
![](art/view.png)

使用说明：

- bigText：设置左边的 text，例：app:bigText="200" 

- bigTextColor：设置左边 text 的颜色，例：app:bigTextColor="@color/colorAccent"

- bigTextMarginBottom：如果左右两边字体相差较大，会出现字体下面不对齐的情况，这时候用这个来进行调整（针对左边），例：app:bigTextMarginBottom="10dp"

- bigTextSize：设置左边较 text 的大小，例：app:bigTextSize="30sp"

- smallText：设置右边的 text，例：app:smallText="元"

- smallTextColor：设置右边 text 的字体颜色，例：app:smallTextColor="@color/colorAccent"

- smallTextMarginBottom：如果左右两边字体相差较大，会出现字体下面不对齐的情况，这时候用这个来进行调整（针对右边），例：app:smallTextMarginBottom="5dp"

- smallTextSize：右边 text 字体的大小，例：app:smallTextSize="16sp"

- textOffset：设置左边和右边 text 之间的距离，例：app:textOffset="10dp"

原则上控件的样式是左边的 text 大，右边的 text 小，但如果你愿意，也可以设置成左边的 text 小，右边的 text 大。

欢迎提出 Issues，喜欢给个Star或者Fork，Thanks！
