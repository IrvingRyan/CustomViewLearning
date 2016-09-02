## CustomViewLearning ##
自定义View学习

> 参考文章地址  [http://blog.csdn.net/harvic880925/article/details/50995268](http://blog.csdn.net/harvic880925/article/details/50995268)

### View1(绘图基础) ###

### View2（基本图形的绘制） ###
- 画直线
- 画多条直线
- 画点
- 画多个点
- 画矩形
- 绘制带圆角的矩形
- 绘制圆形
- 绘制椭圆
- 绘制弧

### View3（路径及文字的绘制） ###
- 绘制直线路径
- 绘制矩形路径

### View3（路径及文字的绘制） ###
- 绘制直线路径
- 绘制矩形路径

### View4（文字的绘制） ###
- 绘图样式区别
- 绘图样式及倾斜度
- 指定单个文字位置绘制
- 按照路径绘制文字（参照View3）
- 更改文字字体
- 基线与绘制位置（paint.setTextAlign(Paint.Align.XXX)）
- drawText的四线格与FontMetrics
- 所绘文字宽度、高度和最小矩形获取

### View5（区域的绘制） ###
- 构造Region
- 使用SetPath() 构造不规则区域
- 区域的合并、交叉等操作

### View6（canvas 的变化与操作） ###
- 平移（translate） translate函数其实实现的相当于平移坐标系，即平移坐标系的原点的位置。
- 屏幕显示与Canvas关系
- 旋转（rotate）
- 缩放（scale）
- 扭曲（skew）
- 裁剪画布（clip系列函数）
- 画布的保存与恢复

### View7（贝塞尔曲线的应用(完成简单的手绘)） ###
> 参考文章地址
> [http://blog.csdn.net/harvic880925/article/details/50995587](http://blog.csdn.net/harvic880925/article/details/50995587)

- quadTo()的基本使用方法
- 绘制轨迹

### View8（贝塞尔曲线的应用(波浪动画效果)） ###
> 参考文章地址 
> [http://blog.csdn.net/harvic880925/article/details/50995587](http://blog.csdn.net/harvic880925/article/details/50995587)

- 使用rQuadTo()绘制波浪线
- 水波浪效果的实现

### View9（Paint 的函数用法汇总） ###
> 未演示的用法参考地址
> [http://blog.csdn.net/harvic880925/article/details/51010839](http://blog.csdn.net/harvic880925/article/details/51010839)

- 设置线冒 
- 线条结合处效果
- 路径效果 PathEffect
- 自定义路径效果（实现箭头延路径移动动画）
- 合并路径效果

### View10（ColorMatrix与滤镜效果） ###
> 本章较难，部分使用的时候再具体研究矩阵的问题，参考地址
> [http://blog.csdn.net/harvic880925/article/details/51187277](http://blog.csdn.net/harvic880925/article/details/51187277)

- 色彩矩阵的基本构成原理
- SaturationActivity对色彩饱和度、色彩旋转的调节

### View11（paint setXfermode方法的使用） ###
> 参考文章地址 
> [http://blog.csdn.net/harvic880925/article/details/51264653](http://blog.csdn.net/harvic880925/article/details/51264653)

- AvoidXfermode的用法
- PorterDuffXfermode的使用请查看ApiDemos Graphics/Xfermodes

### XfermodeActivity（paint 函数之setXfermode的应用） ###
> 参考文章地址 
> [http://blog.csdn.net/harvic880925/article/details/51284710](http://blog.csdn.net/harvic880925/article/details/51284710)

- View12 （PorterDuffXfermode 各个模式的详解）
- BookLightView（PorterDuff.Mode.LIGHTEN在实际中的运用)
- TwitterView（PorterDuff.Mode.MULTIPLY在实际中的运用）
- CornerRoundView（SRC_IN的应用）
- EraserView（SRC_IN实现橡皮擦功能）
- InvertedView（SRC_IN实现倒影）
- GuaguakaView（SRC_OUT实现刮刮奖效果）
- CocaColaView（实现可口可乐商标的波浪摆动 DST_IN）

总结：DST 与 SRC的函数是两个相对的模式 ，可以通过调换绘图顺序实现相同的效果

### CanvasActivity（Canvas与图层） ###
- FlagView(canvas的save函数所有flag的含义)
- QQView（实现QQ底部消息个数圆圈的定制）

### ShadowActivity（阴影效果的绘制） ###
- 使用layer-list 绘制阴影效果
- 自定义ShadowView绘制阴影（TextView,Button,EditView中的文字都具有阴影效果，可以直接在XML或者代码中设置）
- BlurMaskFilterView（模糊（发散）效果展示）
- MyLayout （[onMeasure 与 onLayout 的使用](http://blog.csdn.net/harvic880925/article/details/47029169)）
- BitmapShadowView（实现控件的封装）