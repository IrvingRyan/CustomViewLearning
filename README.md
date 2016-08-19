# CustomViewLearning
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