# KotlinSci


## Installation and Running


1. Download and unzip 


2. Execute the KotlinSci.sh script


Then you can use code as:

plot(vrand(8000))



# Examples

## Chaotic map

```
import kotlin.math.sin as sin
import kotlin.math.cos as cos

// the Ikeda map
// avoids BigDecimal type by explicitly specifying double
var c1 = 0.4
var c2 = 0.9
var c3 = 9.0
var rho = 0.85

var x = 0.5; var y = 0.5
//niters = getInt("How many iterations of the Ikeda map");
var niters = 200000
var xall = DoubleArray(niters)
var yall = DoubleArray(niters)

tic()
for ( k in 0..niters-1 )  {
  var xp = x; var yp=y
  var taut = c1-c3/(1.0+xp*xp+yp*yp)
  x = rho + c2*xp*cos(taut)-yp*sin(taut)
  y = c2*(xp*sin(taut)+yp*cos(taut))
  xall[k] = x
  yall[k] = y
}

var tm = toc()
scatterPlotsOn()
figure(1)
plot(xall, yall, "time = "+tm)

```


## Plotting 


```

figure(1)

var t = inc(0.0, 0.01, 10.0)

var x = sin(t)

var lineSpecs="."
plot(t,x, lineSpecs)

println(t*8.8)
figure(2)
subplot(222)
var x11 = sin(t*4.56)
plot(t,x11)
hold(true)
lineSpecs = ":g"
plot(t,sin(x11*5.0), lineSpecs)
subplot(223)
lineSpecs = ":r"
plot(t,x11, lineSpecs)



// create a new figure and preform a plot at subplot 3,2,1
  figure(3)
 subplot(3,2,1)
 var t2 = inc(0.0, 0.01, 10.0);  var x2 = sin(t2*4.56)+cos(t2*8.7)
 plot(t2,x2, ".-")
 subplot(3,2,3)
var x3 = cos(t2*7.8)+sin(t2*8.9)*8.9
plot(t2, x3)
subplot(3,2,5)
var x4 = cos(t2*7.66)+sin(t2*3.23)*8.665
plot(t2, x4+x3)
subplot(3,2,6)
plot(t2, x4*8.77+x3)
title("x4*8.77+x3")

```


## Plotting with JFreePlot

```

jfigure(1)

var t = inc(0.0, 0.01, 10.0)

var x = sin(t)

var lineSpecs="."
jplot(t,x, lineSpecs)

println(t*8.8)
jfigure(2)
jsubplot(222)
var x11 = sin(t*4.56)
jplot(t,x11)
jhold(true)
lineSpecs = ":g"
jplot(t,sin(x11*5.0), lineSpecs)
jsubplot(223)
lineSpecs = ":r"
jplot(t,x11, lineSpecs)



// create a new figure and preform a plot at subplot 3,2,1
  jfigure(3)
 jsubplot(3,2,1)
 var t2 = inc(0.0, 0.01, 10.0);  var x2 = sin(t2*4.56)+cos(t2*8.7)
 jplot(t2,x2, ".-")
jsubplot(3,2,3)
var x3 = cos(t2*7.8)+sin(t2*8.9)*8.9
jplot(t2, x3)
jlineColor(1, Color.RED)
jsubplot(3,2,5)
var x4 = cos(t2*7.66)+sin(t2*3.23)*8.665
jplot(t2, x4+x3)
jlineColor(1, Color.GREEN)
jsubplot(3,2,6)
jplot(t2, x4*8.77+x3)
jtitle("x4*8.77+x3")
jlineColor(1, Color.BLUE)
```

