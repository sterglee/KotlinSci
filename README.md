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


