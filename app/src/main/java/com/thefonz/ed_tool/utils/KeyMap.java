package com.thefonz.ed_tool.utils;

//import com.thefonz.ed_tool.Tab_ButtonBox;

import com.thefonz.ed_tool.Tab_ButtonBox;

import java.util.Objects;

/**
 * Created by theFONZ on 19/07/2015.
 */


/**
 *  ANY ADDITIONS OR CHANGES MADE HERE MUST ALSO BE MADE TO 'array_keymap.xml'
 *  ... AS ALL KEYCODES AND KEYEVENTS ARE TIED !
 */

public class KeyMap {
    public static void processKeyCode(String str2) {
        String keycode = null;
        if (Objects.equals(str2, "{A}")) {
            keycode = "1";
        }else if (Objects.equals(str2, "{B}")) {
            keycode = "2";
        }else if (Objects.equals(str2, "{C}")) {
            keycode = "3";
        }else if (Objects.equals(str2, "{D}")) {
            keycode = "4";
        }else if (Objects.equals(str2, "{E}")) {
            keycode = "5";
        }else if (Objects.equals(str2, "{F}")) {
            keycode = "6";
        }else if (Objects.equals(str2, "{G}")) {
            keycode = "7";
        } else if (Objects.equals(str2, "{H}")) {
            keycode = "8";
        }else if (Objects.equals(str2, "{I}")) {
            keycode = "9";
        }else if (Objects.equals(str2, "{J}")) {
            keycode = "10";
        }else if (Objects.equals(str2, "{K}")) {
            keycode = "11";
        }else if (Objects.equals(str2, "{L}")) {
            keycode = "12";
        }else if (Objects.equals(str2, "{M}")) {
            keycode = "13";
        }else if (Objects.equals(str2, "{N}")) {
            keycode = "14";
        }else if (Objects.equals(str2, "{O}")) {
            keycode = "15";
        }else if (Objects.equals(str2, "{P}")) {
            keycode = "16";
        }else if (Objects.equals(str2, "{Q}")) {
            keycode = "17";
        }else if (Objects.equals(str2, "{R}")) {
            keycode = "18";
        }else if (Objects.equals(str2, "{S}")) {
            keycode = "19";
        }else if (Objects.equals(str2, "{T}")) {
            keycode = "20";
        }else if (Objects.equals(str2, "{U}")) {
            keycode = "21";
        }else if (Objects.equals(str2, "{V}")) {
            keycode = "22";
        }else if (Objects.equals(str2, "{W}")) {
            keycode = "23";
        }else if (Objects.equals(str2, "{X}")) {
            keycode = "24";
        }else if (Objects.equals(str2, "{Y}")) {
            keycode = "25";
        }else if (Objects.equals(str2, "{Z}")) {
            keycode = "26";
        }else if (Objects.equals(str2, "{0}")) {
            keycode = "27";
        }else if (Objects.equals(str2, "{1}")) {
            keycode = "28";
        }else if (Objects.equals(str2, "{2}")) {
            keycode = "29";
        }else if (Objects.equals(str2, "{3}")) {
            keycode = "30";
        }else if (Objects.equals(str2, "{4}")) {
            keycode = "31";
        }else if (Objects.equals(str2, "{5}")) {
            keycode = "32";
        }else if (Objects.equals(str2, "{6}")) {
            keycode = "33";
        }else if (Objects.equals(str2, "{7}")) {
            keycode = "34";
        }else if (Objects.equals(str2, "{8}")) {
            keycode = "35";
        }else if (Objects.equals(str2, "{9}")) {
            keycode = "36";
        }else if (Objects.equals(str2, "{N0}")) {
            keycode = "37";
        }else if (Objects.equals(str2, "{N1}")) {
            keycode = "38";
        }else if (Objects.equals(str2, "{N2}")) {
            keycode = "39";
        }else if (Objects.equals(str2, "{N3}")) {
            keycode = "40";
        }else if (Objects.equals(str2, "{N4}")) {
            keycode = "41";
        }else if (Objects.equals(str2, "{N5}")) {
            keycode = "42";
        }else if (Objects.equals(str2, "{N6}")) {
            keycode = "43";
        }else if (Objects.equals(str2, "{N7}")) {
            keycode = "44";
        }else if (Objects.equals(str2, "{N8}")) {
            keycode = "45";
        }else if (Objects.equals(str2, "{N9}")) {
            keycode = "46";
        }else if (Objects.equals(str2, "{UP}")) {
            keycode = "47";
        }else if (Objects.equals(str2, "{DOWN}")) {
            keycode = "48";
        }else if (Objects.equals(str2, "{LEFT}")) {
            keycode = "49";
        }else if (Objects.equals(str2, "{RIGHT}")) {
            keycode = "50";
        }else if (Objects.equals(str2, "{BACKSPACE}")) {
            keycode = "51";
        }else if (Objects.equals(str2, "{BREAK}")) {
            keycode = "52";
        }else if (Objects.equals(str2, "{CAPSLOCK}")) {
            keycode = "53";
        }else if (Objects.equals(str2, "{DELETE}")) {
            keycode = "54";
        }else if (Objects.equals(str2, "{END}")) {
            keycode = "55";
        }else if (Objects.equals(str2, "{ENTER}")) {
            keycode = "56";
        }else if (Objects.equals(str2, "{ESC}")) {
            keycode = "57";
        }else if (Objects.equals(str2, "{HOME}")) {
            keycode = "58";
        }else if (Objects.equals(str2, "{INSERT}")) {
            keycode = "59";
        }else if (Objects.equals(str2, "{NUMLOCK}")) {
            keycode = "60";
        }else if (Objects.equals(str2, "{PGDN}")) {
            keycode = "61";
        }else if (Objects.equals(str2, "{PGUP}")) {
            keycode = "62";
        }else if (Objects.equals(str2, "{PRTSC}")) {
            keycode = "63";
        }else if (Objects.equals(str2, "{SCROLLLOCK}")) {
            keycode = "64";
        }else if (Objects.equals(str2, "{TAB}")) {
            keycode = "65";
        }else if (Objects.equals(str2, "{F1}")) {
            keycode = "66";
        }else if (Objects.equals(str2, "{F2}")) {
            keycode = "67";
        }else if (Objects.equals(str2, "{F3}")) {
            keycode = "68";
        }else if (Objects.equals(str2, "{F4}")) {
            keycode = "69";
        }else if (Objects.equals(str2, "{F5}")) {
            keycode = "70";
        }else if (Objects.equals(str2, "{F6}")) {
            keycode = "71";
        }else if (Objects.equals(str2, "{F7}")) {
            keycode = "72";
        }else if (Objects.equals(str2, "{F8}")) {
            keycode = "73";
        }else if (Objects.equals(str2, "{F9}")) {
            keycode = "74";
        }else if (Objects.equals(str2, "{F10}")) {
            keycode = "75";
        }else if (Objects.equals(str2, "{F11}")) {
            keycode = "76";
        }else if (Objects.equals(str2, "{F12}")) {
            keycode = "77";
        }else if (Objects.equals(str2, "{F13}")) {
            keycode = "78";
        }else if (Objects.equals(str2, "{F14}")) {
            keycode = "79";
        }else if (Objects.equals(str2, "{F15}")) {
            keycode = "80";
        }else if (Objects.equals(str2, "{F16}")) {
            keycode = "81";
        }else if (Objects.equals(str2, "{ADD}")) {
            keycode = "82";
        }else if (Objects.equals(str2, "{SUBTRACT}")) {
            keycode = "83";
        }else if (Objects.equals(str2, "{MULTIPLY}")) {
            keycode = "84";
        }else if (Objects.equals(str2, "{DIVIDE}")) {
            keycode = "85";
        }else if (Objects.equals(str2, "{CONTROL}")) {
            keycode = "86";
        }else if (Objects.equals(str2, "{SHIFT}")) {
            keycode = "87";
        }else if (Objects.equals(str2, "{ALT}")) {
            keycode = "88";
        }else if (Objects.equals(str2, "{SLASH}")) {
            keycode = "89";
        }else if (Objects.equals(str2, "{BACKSLASH}")) {
            keycode = "90";
        }else if (Objects.equals(str2, "{COMMA}")) {
            keycode = "91";
        }else if (Objects.equals(str2, "{EQUALS}")) {
            keycode = "92";
        }else if (Objects.equals(str2, "{OPENBRACKET}")) {
            keycode = "93";
        }else if (Objects.equals(str2, "{CLOSEBRACKET}")) {
            keycode = "94";
        }else if (Objects.equals(str2, "{PERIOD}")) {
            keycode = "95";
        }else if (Objects.equals(str2, "{QUOTE}")) {
            keycode = "96";
        }else if (Objects.equals(str2, "{BACKQUOTE}")) {
            keycode = "97";
        }else if (Objects.equals(str2, "{SEMICOLON}")) {
            keycode = "98";
        }else if (Objects.equals(str2, "{DECIMAL}")) {
            keycode = "99";
        }
        // Send the relevant KeyCode to the 'sendKey' function
        String finalCode = keycode;
        Tab_ButtonBox.sendKey(finalCode);
    }
}