import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np
import mplcursors

# Define the equation: x + y = z
def equation(x, y):
    return (x+y)/(x-y)

# Create a grid of x and y values
x_values = np.linspace(-10, 10, 100)
y_values = np.linspace(-10, 10, 100)

# Create a meshgrid from x and y values
X, Y = np.meshgrid(x_values, y_values)

# Calculate corresponding z values using the equation
Z = equation(X, Y)

# Create a 3D plot
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')

# Scatter plot for the surface
ax.plot_surface(X, Y, Z, cmap='viridis', alpha=0.7)
ax.plot_wireframe(X, Y, Z, cmap='viridis', alpha=0.7)
# ax.tricontour(X, Y, Z, cmap='viridis', alpha=0.7)
# ax.tricontourf(X, Y, Z, cmap='viridis', alpha=0.7)

# Set labels
ax.set_xlabel('X-axis')
ax.set_ylabel('Y-axis')
ax.set_zlabel('Z-axis')

# Add hover annotations using mplcursors
mplcursors.cursor(hover=True).connect("add", lambda sel: sel.annotation.set_text(f"({sel.target[0]:.2f}, {sel.target[1]:.2f}, {equation(sel.target[0], sel.target[1]):.2f})"))

# Show the plot
plt.show()
