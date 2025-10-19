from fractions import Fraction

def find_path_to_fraction(target, node=Fraction(1, 1), path=None, depth_limit=100):
    if path is None:
        path = [node]
    
    if node == target:
        return path
    
    if len(path) > depth_limit:
        return None  # Avoid infinite recursion
    
    # Generate children
    left = Fraction(node.numerator, node.numerator + node.denominator)
    right = Fraction(node.numerator + node.denominator, node.denominator)
    
    # Search left
    left_path = find_path_to_fraction(target, left, path + [left], depth_limit)
    if left_path:
        return left_path
    
    # Search right
    right_path = find_path_to_fraction(target, right, path + [right], depth_limit)
    if right_path:
        return right_path
    
    return None  # Not found

# Example usage:
target = Fraction(112, 50)
path = find_path_to_fraction(target)

if path:
    print("Path to", target, ":")
    for step in path:
        print(step)
else:
    print("Fraction not found within depth limit.")