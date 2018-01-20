
f <- function(x) (4*x^3 + 3 * x^2 - 2 * x - 1)

df <- function(x) {}
body(df) <- D(body(f), 'x')

curve(f, -4, 4, ylab = "Function and Derivative")
curve(df, -4, 4, add = TRUE, col = "Red")
