package uk.danielarthur.learnwhile.gui;

import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.BorderLayout;
import uk.danielarthur.learnwhile.datatypes.BinaryTree;

/**
 * A JPanel that displays a BinaryTree visually
 * @author Daniel Arthur
 * @version February 2017
 * @see javax.swing.JPanel
 * @see uk.danielarthur.learnwhile.datatypes.BinaryTree
 */
public class TreeViewerPanel extends JPanel {

    private int canvasHeight;
    private int canvasWidth;

    private int rootY = 10;
    private int NODE_SIZE = 25;
    private int ROW_HEIGHT = 50;
    mxGraph graph = new mxGraph();
    Object parent = graph.getDefaultParent();
    
    
    /**
     * Creates an empty TreeViewerPanel with no binary tree to show.
     */
    public TreeViewerPanel() {
        super(new BorderLayout());
    }
    
    /**
     * Creates a new TreeViewerPanel and displays a Binary Tree
     * @param tree The binary tree to be displayed on the panel.
     */
    public TreeViewerPanel(BinaryTree tree) {
        super(new BorderLayout());
        
        canvasHeight = 500;
        canvasWidth = 1000;

        this.update(tree);

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        graph.setCellsEditable(false);
        graph.setCellsResizable(false);
        graph.setCellsBendable(false);
        graph.setCellsCloneable(false);
        graph.setCellsDisconnectable(false);
        graph.setCellsResizable(false);
        graph.setCellsMovable(false);
        graph.setCellsSelectable(false);
        graph.setCellsLocked(true);
        graphComponent.setConnectable(false);
        
        this.add(graphComponent, BorderLayout.CENTER);
    }

    private Object drawTree(BinaryTree tree, int depth, int index) {

        int myX = (int) ((canvasWidth * (index)) / (Math.pow(2, depth - 1) + 1));

        Object rootVertex;
        
        if (tree.isNil()) {
            rootVertex = graph.insertVertex(parent, null, "nil", myX, depth * ROW_HEIGHT + rootY, NODE_SIZE, NODE_SIZE, "fillColor:none");
            return rootVertex;
        }else {
            rootVertex = graph.insertVertex(parent, null, "", myX, depth * ROW_HEIGHT + rootY, NODE_SIZE, NODE_SIZE, "fillColor:none");
        }
        
        Object rightChildVertex = drawTree(tree.tail(), depth + 1, index * 2);

        if (rightChildVertex != null) {// edge
            graph.insertEdge(parent, null, "", rootVertex, rightChildVertex, "startArrow=none;endArrow=none;strokeWidth=1;strokeColor=black");
        }

        Object leftChildVertex = drawTree(tree.head(), depth + 1, index * 2 - 1);

        if (leftChildVertex != null) { // edge
            graph.insertEdge(parent, null, "", rootVertex, leftChildVertex, "startArrow=none;endArrow=none;strokeWidth=1;strokeColor=black");
        }

        return rootVertex;

    }
    
    private void update(BinaryTree tree) {

        graph.getModel().beginUpdate();

        try {

            Object[] cells = graph.getChildCells(parent, true, false);
            graph.removeCells(cells, true);
            drawTree(tree, 1, 1);

        } finally {
            graph.getModel().endUpdate();
        }
    }

}
