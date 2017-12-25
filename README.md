# BigSmallTextView

设置大小字体的View  

有时候在项目中可能会做下面的效果，为了简便，所以搞了这个View。

效果图：
![](art/view.png)

引用：
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  dependencies {
	      compile 'com.github.lizixian18:BigSmallTextView:v1.0'
	}
```

[![](https://jitpack.io/v/lizixian18/BigSmallTextView.svg)](https://jitpack.io/#lizixian18/BigSmallTextView)

使用说明：

| 方法 | 说明 | 示例 |
| :-------- | :----- | :-- |
| app:bigText | 设置左边的 text | app:bigText="你"<br>setBigText("你");|
| app:bigTextColor | 设置左边 text 的颜色| app:bigTextColor="@color/colorAccent"<br>setBigTextColor(ContextCompat.getColor(this,R.color.colorAccent));|
| app:bigTextMarginBottom | 如果左右两边字体相差较大，会出现字体下面不对齐的情况，这时候用这个来进行调整(针对左边)|app:bigTextMarginBottom="10dp"<br>  setBigTextMarginBottom(10);|
| app:bigTextSize | 设置左边较 text 的大小| app:bigTextSize="20sp"<br>setBigTextSize(25);|
| app:smallText | 设置右边的 text| app:smallText="好"<br>setSmallText("好");|
| app:smallTextColor | 设置右边 text 的字体颜色| app:smallTextColor="@color/colorPrimary"<br>setSmallTextColor(ContextCompat.getColor(this, R.color.colorPrimary));|
| app:smallTextMarginBottom | 如果左右两边字体相差较大，会出现字体下面不对齐的情况，这时候用这个来进行调整(针对右边)| app:smallTextMarginBottom="10dp"<br>setSmallTextMarginBottom(10);|
| app:smallTextSize | 右边 text 字体的大小| app:smallTextSize="16sp"<br>setSmallTextMarginBottom(10); |
| app:textOffset |设置左边和右边 text 之间的距离| app:textOffset="10dp"<br>setTextOffset(10);|

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

#### License

```
Copyright 2017 L_Xian   
 
Licensed under the Apache License, Version 2.0 (the "License");  
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at  

http://www.apache.org/licenses/LICENSE-2.0  

Unless required by applicable law or agreed to in writing, software  
distributed under the License is distributed on an "AS IS" BASIS,  
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
See the License for the specific language governing permissions and  
limitations under the License.
```

