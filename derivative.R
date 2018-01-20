# testing code from http://rpubs.com/wkmor1/simple-derivatives-in-r

f <- function(x) (x^3 + 3 * x^2 - 6 * x - 8)
curve(f, -5, 4, ylab = "y=f(x)")
g <- function(x) {}
body(g) <- D(body(f), 'x')
body(g)
curve(g, -5, 4, ylab = "g(x)")