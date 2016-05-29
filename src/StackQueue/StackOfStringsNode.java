/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackQueue;

/**
 *
 * @author Admin
 */
public class StackOfStringsNode
{
    private String item;
    private StackOfStringsNode node;   
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public StackOfStringsNode getNode() {
        return node;
    }
    public void setNode(StackOfStringsNode node) {
        this.node = node;
    }
    
    public StackOfStringsNode(String item, StackOfStringsNode node)
    {
        this.item = item;
        this.node = node;
    }
}
