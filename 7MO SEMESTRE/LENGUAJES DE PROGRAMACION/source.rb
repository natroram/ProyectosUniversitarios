print "Hello, World!\n"

# Variables and expressions.
a = 10
b = 3 * a + 2
c = 0.5

d = true and true or false
e = true && true || false
# Operators are really method invocations.
a = 10
b = 3.*(a).+(2)

a = [ 45, 3, 19, 8 ]
b = [ "sam", "max", 56, 98.9, 3, 10, "jill" ]

#hash
z = { "mike" => 75, "bill" => 18, "alice" => 32 }

#classes
class Fred
  
  # The initialize method is the constructor.  The @val is
  # an object value.
  def initialize(v)
    @val = v
  end

  # Set it and get it.
  def set(v)
    @val = v
  end

  def get
    return @val
  end
end


