package com.thefonz.ed_tool.tcp_client;

import java.util.HashMap;

/**
 * Created by thefonz on 06/04/15.
 */
public class CustomKeyMap {

    public static void main(String[] args) {

        //create object of HashMap
        HashMap<String, String> currentmap = null;
        currentmap = new HashMap<String, String>();

    /*
      Add key value pair to HashMap using
      Object put(Object key, Object value) method of Java HashMap class,
      where key and value both are objects
      put method returns Object which is either the value previously tied
      to the key or null if no value mapped to the key.
    */
        currentmap.put("a", "{A}");
        currentmap.put("b", "{B}");
        currentmap.put("c", "{C}");
        currentmap.put("d", "{D}");
        currentmap.put("e", "{E}");
        currentmap.put("f", "{F}");
        currentmap.put("g", "{G}");
        currentmap.put("h", "{H}");
        currentmap.put("i", "{I}");
        currentmap.put("j", "{J}");
        currentmap.put("k", "{K}");
        currentmap.put("l", "{L}");
        currentmap.put("m", "{M}");
        currentmap.put("n", "{N}");
        currentmap.put("o", "{O}");
        currentmap.put("p", "{P}");
        currentmap.put("q", "{Q}");
        currentmap.put("r", "{R}");
        currentmap.put("s", "{S}");
        currentmap.put("t", "{T}");
        currentmap.put("u", "{U}");
        currentmap.put("v", "{V}");
        currentmap.put("w", "{W}");
        currentmap.put("x", "{X}");
        currentmap.put("y", "{Y}");
        currentmap.put("z", "{Z}");

        currentmap.put("up", "{UP}");
        currentmap.put("down", "{DOWN}");
        currentmap.put("left", "{LEFT}");
        currentmap.put("right", "{RIGHT}");
        currentmap.put("backspace", "{BACKSPACE}");
        currentmap.put("break", "{BREAK}");
        currentmap.put("caps", "{CAPSLOCK}");
        currentmap.put("del", "{DELETE}");
        currentmap.put("end", "{END}");
        currentmap.put("enter", "{ENTER}");
        currentmap.put("esc", "{ESC}");
        currentmap.put("home", "{HOME}");
        currentmap.put("insert", "{INSERT}");
        currentmap.put("numlock", "{NUMLOCK}");
        currentmap.put("pgdn", "{PGDN}");
        currentmap.put("pgup", "{PGUP}");
        currentmap.put("prntsc", "{PRTSC}");
        currentmap.put("scrolllock", "{SCROLLLOCK}");
        currentmap.put("tab", "{TAB}");

        currentmap.put("f1", "{F1}");
        currentmap.put("f2", "{F2}");
        currentmap.put("f3", "{F3}");
        currentmap.put("f4", "{F4}");
        currentmap.put("f5", "{F5}");
        currentmap.put("f6", "{F6}");
        currentmap.put("f7", "{F7}");
        currentmap.put("f8", "{F8}");
        currentmap.put("f9", "{F9}");
        currentmap.put("f10", "{F10}");
        currentmap.put("f11", "{F11}");
        currentmap.put("f12", "{F12}");
        currentmap.put("f13", "{F13}");
        currentmap.put("f14", "{F14}");
        currentmap.put("f15", "{F15}");
        currentmap.put("f16", "{F16}");
        currentmap.put("add", "{ADD}");
        currentmap.put("subtract", "{SUBTRACT}");
        currentmap.put("multiply", "{MULTIPLY}");
        currentmap.put("divide", "{DIVIDE}");

   /*
      Please note that put method accepts Objects. Java Primitive values CAN NOT
      be added directly to HashMap. It must be converted to corrosponding
      wrapper class first.
    */

        //retrieve value using Object get(Object key) method of Java HashMap class
//        Object obj = currentmap.get("a");
//        System.out.println(obj);

    /*
      Please note that the return type of get method is an Object. The value must
      be casted to the original class.
    */


    }
}
/*
Output of the program would be
1
*/


