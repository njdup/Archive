
# Single like comment
#= Multi-line comment =#

# Julia uses 1-indexing, not 0-indexing

# Instal(?) packages: "using Pkg; Pkg.add("desired package")"
# Import package with clean namespace: "import package", then use
# qualify calls by package namespace

# import Plots
# const pl = Plots # Creates alias
# pl.pyplot()
# pl.plot(rand(4,4))

# import Plots: pyplot, plot
# This will specifically import the two specified functions
# from the namespace

# Variable names support a subset of Unicode symbols, so
# we can use greek letters in them!
# latex like syntax is used for them
#
# Main types of scalars are Int64, Float64, Char ('a'), String "abc", and Bool
#
# Strings
# Concatenation Operator: *
# interpolation: a = "$str1 is a string and $(myobject.int1) is an integer"

str1 = "(first string)"
test = "This is from $str1 and this is an expression: $(2 + 2)"
print(test)

# Arrays (lists)
# N-dimensional mutable containers
#
# empty arrays: a = []
# Explicit constructor: a = Array{T,1}()
# Vector alias: c = Vector{T}()
# 
# 5-elements zeros array: a=zeros(5)
# Column vector (Vector alias for 1-dimensional array):
#   a = [1;2;3]
#   a = [1,2,3]
#
# Row vector (Matrix container, alias for 2-dimensional array
#   a = [1 2 3]
#
# Arrays can be heterogeneous (But the array will be of Any type
# and in general much slower)
# x = [10, "foo", false]
#
# You can use Union keyword to store limited set of types efficiently: a = Union{Int64,String,Bool}[10, "Foo", false]
#
# a = Int64[] is shorthand for a = Array{Int64,1}()
# Note that a = Array{Int64,1} assigns the data type to a
