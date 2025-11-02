from graphviz import Digraph

def build_recursion_tree(n, parent, graph):
    node_label = f"print({n})"
    graph.node(node_label)
    if parent is not None:
        graph.edge(parent, node_label)
    if n == 0:
        return
    build_recursion_tree(n-1, node_label, graph)
    # output after first print(n-1)
    # For visualization, we don't add separate node for output
    build_recursion_tree(n-1, node_label, graph)
    # output after second print(n-1)

graph = Digraph(format='png')
build_recursion_tree(2, None, graph)
file_path = "/mnt/data/recursion_tree_print2.png"
graph.render(file_path, view=False)
file_path
