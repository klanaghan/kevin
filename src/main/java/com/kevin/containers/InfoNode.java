package com.kevin.containers;

import java.util.Map;
import java.util.TreeMap;

public class InfoNode
{
  boolean mLeaf;
  Object mValue;
  Map<String, InfoNode> children = new TreeMap<>();

  public InfoNode(String inKevin, Object inKevinValue)
  {
    mValue = inKevinValue;
  }

  public InfoNode(Object inKevinValue, boolean isLeaf)
  {
    mValue = inKevinValue;
    mLeaf = isLeaf;
  }

  public InfoNode(String inKey, Object inKevinValue, boolean isLeaf)
  {
    mValue = inKevinValue;
    mLeaf = isLeaf;
  }

  public Map<String, InfoNode> getChildren()
  {
    return children;
  }

  public void setChildren(Map<String, InfoNode> inChildren)
  {
    children = inChildren;
  }

  public InfoNode(String inKey, boolean inLeaf)
  {
    mLeaf = inLeaf;
  }

  public InfoNode search(String... inKeys)
  {
    //  Map<String, InfoNode> current = children;
    InfoNode parent = this;
    for (String each : inKeys)
    {
      InfoNode current = parent.get(each);
      if (current == null)
      {
        break;
      }
      parent = current;
    }
    return parent;
  }

  public InfoNode get(String inKey)
  {
    InfoNode node = null;
    int i = 0;
    node = children.get(inKey);
    return node;
  }

  public Object getValue()
  {
    return mValue;
  }

  public void setValue(Object inValue)
  {
    mValue = inValue;
  }

  public void add(Object inValue, String... keys)
  {
    InfoNode child = null;
    int length = keys.length;
    int i = 0;
    InfoNode previous = this;
    for (String each : keys)
    {
      InfoNode current = previous.get(each);
      if (current == null)
      {
        current = new InfoNode(each, null, false);
        previous.getChildren().put(each, current);
      }
      i++;
      if (i == keys.length)
      {
        current.setValue(inValue);
        current.setLeaf(true);
      }
      previous = current;
    }
  }

  public boolean isLeaf()
  {
    return mLeaf;
  }

  public void setLeaf(boolean inLeaf)
  {
    mLeaf = inLeaf;
  }

  public static void main(String[] inArgs)
  {
    InfoNode root = new InfoNode("root", null);
    root.add("kevinValue", "key1", "key2", "key3");
    root.add("MarkValue", "key1", "key2", "key4");
    root.add("LanaghanValue", "key11", "key22", "key44");
    InfoNode k = root.search("key1", "key2", "key3");
    System.out.println(k.getValue());
    k = root.search("key1", "key2", "key4");
    System.out.println(k.getValue());
    k = root.search("key11", "key22", "key44");
    System.out.println(k.getValue());
  }
}
