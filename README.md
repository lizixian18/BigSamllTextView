# BigSmallTextView

设置大小字体的View  

有时候在项目中可能会做下面的效果，为了简便，所以搞了这个View。

效果图：
![](art/view.png)

使用说明：

| 方法      |    方法 | 说明|示例  |
| :-------- | :--------|:-----| :-- |
| app:bigText | setBigText() |设置左边的 text|  app:bigText="你"<br>mBigSmallTextView.setBigText("你");   |
| app:bigTextColor|  setBigTextColor() |设置左边 text 的颜色|  app:bigTextColor="@color/colorAccent"<br>mBigSmallTextView.setBigTextColor(ContextCompat.getColor(this,R.color.colorAccent));  |
| app:bigTextMarginBottom|  setBigTextMarginBottom() |如果左右两边字体相差较大，会出现字体下面不对齐的情况，这时候用这个来进行调整（针对左边）|  app:bigTextMarginBottom="10dp"<br>  mBigSmallTextView.setBigTextMarginBottom(10);  |
| app:bigTextSize|  setBigTextSize() |  设置左边较 text 的大小|  app:bigTextSize="20sp"<br>   mBigSmallTextView.setBigTextSize(25);  |
| app:smallText|  setSmallText() |设置右边的 text| app:smallText="好"<br> mBigSmallTextView.setSmallText("好");  |
| app:smallTextColor|  setSmallTextColor() |设置右边 text 的字体颜色| app:smallTextColor="@color/colorPrimary"<br>   mBigSmallTextView.setSmallTextColor(ContextCompat.getColor(this, R.color.colorPrimary));  |
| app:smallTextMarginBottom|  setSmallTextMarginBottom() |如果左右两边字体相差较大，会出现字体下面不对齐的情况，这时候用这个来进行调整（针对右边）|   app:smallTextMarginBottom="10dp"<br>   mBigSmallTextView.setSmallTextMarginBottom(10);  |
| app:smallTextSize|  setSmallTextSize() |右边 text 字体的大小|   app:smallTextSize="16sp"<br>   mBigSmallTextView.setSmallTextMarginBottom(10); |
|app:textOffset|setTextOffset()|设置左边和右边 text 之间的距离| app:textOffset="10dp"<br>mBigSmallTextView.setTextOffset(10);|

也可以在代码中使用 setXXX() 方法来设置。  
例子：  
```
  mBigSmallTextView
                .setBigTextSize(25)
                .setSmallTextSize(16)
                .setBigText("你")
                .setSmallText("好");
```
代码中设置字体大小单位默认为 sp ，设置距离单位默认为 dp  。


原则上控件的样式是左边的 text 大，右边的 text 小，但如果你愿意，也可以设置成左边的 text 小，右边的 text 大。

欢迎提出 Issues，喜欢给个Star或者Fork，Thanks！
