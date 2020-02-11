package edu.cis.cisgsearch.Model.GoogleSearch;

public class GTreeNode
{
    protected GTreeNode left;
    protected GTreeNode right;
    private int height;

    TARestProfile restaurantData; //information about a restaurant from tripAdvisor

    public GTreeNode(TARestProfile data)
    {
//        restaurantData = data;
    }

    public GTreeNode insert(GTreeNode node, TARestProfile data)
    {
        return null;
    }

    private GTreeNode rightRotate(GTreeNode y)
    {
        return null;
    }

    private GTreeNode leftRotate(GTreeNode x)
    {
        return null;
    }

    //a function that returns higher value between two restaurant names
    private String maxName(String leftNodeName, String rightNodeName)
    {
        return "";
    }

    private int getHeight(GTreeNode node)
    {
        return 0;
    }

    //different between children's heights
    private int getBalance(GTreeNode node)
    {
        return 0;
    }

    public TARestProfile getRestaurantDataData()
    {
        return restaurantData;
    }
}
